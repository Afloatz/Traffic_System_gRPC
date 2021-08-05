package grpc.trafficservice;


import java.io.IOException;
import java.util.ArrayList;

import grpc.jmdns.SimpleServiceRegistration;
import grpc.trafficservice.trafficServiceGrpc.trafficServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class TrafficServer {
	
	private Server server; // the grpc server

	public static void main(String[] args) throws IOException, InterruptedException {
		
		final TrafficServer trafficServer = new TrafficServer(); // create the server object
		trafficServer.start();

	}

	private void start() throws IOException, InterruptedException {

		System.out.println("Starting traffic Server");
		
		//Service Registration:
		int port = 50051; // port number that we will use
		String service_type = "_grpc1._tcp.local.";
		String service_name = "GrpcTrafficServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
		try {
			// use the builder to build the object for us
			server = ServerBuilder.forPort(port).addService(new TrafficServerImpl()).build().start();		
			System.out.println("Server running on port: " + port);			
			server.awaitTermination();	
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	}
	
	// Extend abstract base class for our implementation
	static class TrafficServerImpl extends trafficServiceImplBase {
		
		// Unary method
		@Override
		public void sendEmergency(RequestEmergency request, StreamObserver<EmergencyResponse> responseObserver) {
			
			// Find out what was sent by client
			String emergencyString = request.getMessage();
			System.out.println("The emergency message is: " + emergencyString);
		
			// Now build our response
			EmergencyResponse.Builder response = EmergencyResponse.newBuilder(); // builder object
		
			response.setText("Your request for emergency has been received. We are sending the emergency team.");
			
			// Send out message (build our response)
			responseObserver.onNext(response.build()); // unary, so only 1 message
		
			responseObserver.onCompleted();
		
		}
		
		// Server streaming method
		@Override
		public void liveFeed(Area request, StreamObserver<StreetSituation> responseObserver) {
			
			// Find out for which area the client wants information
			int intArea= request.getIntArea();
			System.out.println("The Dublin district is: " + intArea);
		

			try {
				// Now build our response
				StreetSituation.Builder response = StreetSituation.newBuilder(); // builder object
				
				// Provides different livefeed depending on the area (Dublin 1 to 22)
				// Note: for this project I only entered responses for Dublin 1 and 2 to avoid entering 22 different set of responses
				switch (intArea) {
				case 1: //Dublin 1
					// first response
					response.setTextSituation("O'Connelll street is very busy with a lot of pedestrians on the road.");			
					// Send out message (build our response)
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);
					
					// second response that we are sending back to the client
					response.setTextSituation("Parnell street is has not much pedestrian traffic at the moment.");			
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);
					
					// third response
					response.setTextSituation("Avoid Bachelors Walk as a protest is happening!");			
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);					
					break;
				case 2: //Dublin 2
					response.setTextSituation("Exchequer Street is very busy.");			
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);
					
					response.setTextSituation("Dame Street has an emergency situation.");			
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);
				default: //if the user enters a wrong input (not supported district number)
					response.setTextSituation("Please enter a valid district number for Dublin (1 or 2)");			
					responseObserver.onNext(response.build()); 
					break;
				}	
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				responseObserver.onCompleted();
			}					
		
		}
		
		// client streaming method
		@Override
		public StreamObserver<Video> calculatePedestrianNumber(StreamObserver<WarningResponse> responseObserver){
			
			System.out.println("inside streaming implementation");
			
			return new StreamObserver<Video>() {		
				ArrayList<Integer> pedestrians = new ArrayList<Integer>();

				@Override
				public void onNext(Video value) {
					System.out.println("Receiving pedestrian numbers from client: " + value.getPedestrianNumber());
					//store the values received from the camera in the ArrayList
					pedestrians.add(value.getPedestrianNumber());
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
					
				}

				@Override
				public void onCompleted() {
					
					System.out.println("Message from server: streaming from the camera now completed");
					
					//calculate the current number of pedestrian in the street
					int sum = 0;
					for(int i = 0; i < pedestrians.size(); i++) {
						sum += pedestrians.get(i);
					} 
																							
					String reply = "";
					
					if (sum > 400) {
						//if the number of pedestrian currently in the street is more then 400, send a warning
						reply = "Warning, be careful while driving, the street has currently more pedestrians than its capacity!";
					} else {
						reply = "You can safely drive in the street";
					}
					
					WarningResponse.Builder response = WarningResponse.newBuilder();
					response.setText(reply);
					//send one message back
					responseObserver.onNext(response.build());
					responseObserver.onCompleted();										
				}
			};
		}
		
		//bi-di
		@Override
		public StreamObserver<UserAlertRequest> streetAlert(StreamObserver<UserAlertResponse> responseObserver) {
	
			StreamObserver<UserAlertRequest> requestObserver = new StreamObserver<UserAlertRequest>() {

				@Override
				public void onNext(UserAlertRequest value) {
					
					String location = value.getAlert().getLocation();
					String message = value.getAlert().getMessage();
					
					//user receives all alerts received at a given location from other users
					if (location.equalsIgnoreCase("Exchequer Street")) {
						//send the alerts received from that location to the user 
						UserAlertResponse userAlertResponse = UserAlertResponse.newBuilder()
								.setResult("Alerts received at " + location + ": " + message)
								.build();
						
						responseObserver.onNext(userAlertResponse);		
					} else if (location.equalsIgnoreCase("George Street")) {
						UserAlertResponse userAlertResponse = UserAlertResponse.newBuilder()
								.setResult("Alerts received at " + location + ": " + message)
								.build();
						
						responseObserver.onNext(userAlertResponse);		
					} else {
						UserAlertResponse userAlertResponse = UserAlertResponse.newBuilder()
								.setResult("No alerts received at " + location + " . You are the first one sending an alert at that location." )
								.build();
						
						responseObserver.onNext(userAlertResponse);		
					}								
			
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();					
				}

				@Override
				public void onCompleted() {
					responseObserver.onCompleted();					
				}
			};
			return requestObserver;
		}
		
	}

}