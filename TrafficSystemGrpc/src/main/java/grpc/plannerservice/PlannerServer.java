package grpc.plannerservice;

import java.io.IOException;

import grpc.plannerservice.PlannerServiceGrpc.PlannerServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class PlannerServer {
	
	private Server server;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		final PlannerServer plannerServer = new PlannerServer();
		plannerServer.start();

	}

	private void start() throws IOException, InterruptedException {

		System.out.println("Starting planner Server");
		
		int port = 50052; // port number that we will use for this planner service 
		
		// use the builder to build the object for us
		// server = ServerBuilder.forPort(port).addService(new PlannerServerImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();	
	}
	
	// Extend abstract base class for our implementation
//	static class PlannerServerImpl extends PlannerServiceImplBase{
//		
//		// Server streaming method
//		@Override
//		public void getPedestrianStreets(DayRequest request, StreamObserver<StreetResponse> responseObserver) {
//			System.out.println("receiving day: " + request.getDayOfTheWeek());		
//			
//			try {				
//				// Now build our response
//				StreetResponse.Builder response = StreetResponse.newBuilder(); // builder object
//				
//				switch (request.getDayOfTheWeek()) {
//				case MONDAY:
//					// first response
//					response.setIsClosed(false);	
//					// Send out message (build our response)
//					responseObserver.onNext(response.build()); 
//					Thread.sleep(1000);
//					
//					break;
//
//				default:
//					break;
//				}
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			} finally {
//				
//			}
//			
//		}
//		
//	}

}
