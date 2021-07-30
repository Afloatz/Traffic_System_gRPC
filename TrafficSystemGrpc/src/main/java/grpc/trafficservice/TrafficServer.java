package grpc.trafficservice;


import java.io.IOException;

import grpc.newservice.containsString;
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
		
			// Now build our response
			StreetSituation.Builder response = StreetSituation.newBuilder(); // builder object
		
			// first response
			response.setTextSituation("O'Connelll street is very busy with a lot of pedestrians on the road.");			
			// Send out message (build our response)
			responseObserver.onNext(response.build()); 
			
			// second response that we are sending back to the client
			response.setTextSituation("Parnell street is has not much pedestrian traffic at the moment.");			
			responseObserver.onNext(response.build()); 
			
			// third response
			response.setTextSituation("Avoid Bachelors Walk as a protest is happening!");			
			responseObserver.onNext(response.build()); 
		
			responseObserver.onCompleted();
		
		}
		
		// client streaming method
		@Override
		public StreamObserver<Video> calculatePedestrianNumber(StreamObserver<WarningResponse> responseObserver){
			
			return new StreamObserver<Video>() {

				@Override
				public void onNext(Video value) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					
				}
			};
		}
		
	}

}