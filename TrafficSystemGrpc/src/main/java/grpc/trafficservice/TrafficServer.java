package grpc.trafficservice;


import java.io.IOException;

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
		
		int port = 50051; // port number that we will use
		
		// use the builder to build the object for us
		server = ServerBuilder.forPort(port).addService(new TrafficServerImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	
	
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

				//send multiple messages
				@Override
				public void onNext(Video value) {
					System.out.println("Receiving pedestrian numbers from client: " + value.getPedestrianNumber());
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					WarningResponse.Builder response = WarningResponse.newBuilder();
					
					response.setText("Message from server, streaming from the camera now completed");
					
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
					String responseLocation = "Alert at " +  value.getAlert().getLocation();
					String responseMessage = value.getAlert().getMessage();
					
					UserAlertResponse userAlertResponse = UserAlertResponse.newBuilder()
							.setResult(responseLocation + "\n" + responseMessage)
							.build();
					
					responseObserver.onNext(userAlertResponse);
					
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