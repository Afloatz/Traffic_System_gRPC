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
		// to run multiple services each needs their own port
		
		// use the builder to build the object for us
		server = ServerBuilder.forPort(port).addService(new TrafficServerImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();
	
	
	}
	
	// Extend abstract base class for our implementation
	static class TrafficServerImpl extends trafficServiceImplBase {
		
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
		
	}

}