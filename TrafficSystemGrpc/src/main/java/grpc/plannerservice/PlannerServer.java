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
		server = ServerBuilder.forPort(port).addService(new PlannerServerImpl()).build().start();
		
		System.out.println("Server running on port: " + port);
		
		server.awaitTermination();	
	}
	
	// Extend abstract base class for our implementation
	static class PlannerServerImpl extends PlannerServiceImplBase{
		
		// Server streaming method 1
		@Override
		public void getPedestrianStreets(DayRequest request, StreamObserver<StreetResponse> responseObserver) {
			System.out.println("receiving day: " + request.getDayOfTheWeek());		
			
			try {				
				// Now build our response
				StreetResponse.Builder response = StreetResponse.newBuilder(); // builder object
				
				switch (request.getDayOfTheWeek()) {
				case MONDAY:
					// first response
					response.setMessage("O'Connell Street is pedestrian only today.");	
					// Send out message (build our response)
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);
					
					// second response
					response.setMessage("Parnell Street is pedestrian only today.");
					// Send out message (build our response)
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);				
					break;
				case TUESDAY:
					response.setMessage("William Street is pedestrian only today.");	
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);

					response.setMessage("George Street is pedestrian only today.");
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);				
					break;
				case WEDNESDAY:
					response.setMessage("Capel Street is pedestrian only today.");	
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);
					
					response.setMessage("Max Street is pedestrian only today.");
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);				

					response.setMessage("John Street is pedestrian only today.");
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);				
					break;					
				case THURSDAY:
					response.setMessage("Herbert Street is pedestrian only today.");	
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);

					response.setMessage("Henry Street is pedestrian only today.");
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);				
					break;
				case FRIDAY:
					response.setMessage("Herbert Street is pedestrian only today.");	
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);
					
					response.setMessage("Henry Street is pedestrian only today.");
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);				
					break;
				case SATURDAY:
					response.setMessage("Capel Street is pedestrian only today.");	
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);
					
					response.setMessage("St Stephen Street is pedestrian only today.");
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);				
					
					response.setMessage("Merrion Square W is pedestrian only today.");
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);				
					break;
				case SUNDAY:
					response.setMessage("John Street is pedestrian only today.");	
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);
					
					response.setMessage("Fitz Street is pedestrian only today.");
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);				
					
					response.setMessage("Arnold Street is pedestrian only today.");
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);				
					break;			
				default:
					response.setMessage("Choose a day of the week!");
					// Send out message (build our response)
					responseObserver.onNext(response.build()); 			
					break;
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				responseObserver.onCompleted();
				
			}
			
		}
		
		//server streaming method 2
		@Override
		public void getDiningStreets(TimeRequest request, StreamObserver<DiningStreetResponse> responseObserver) {
			
			System.out.println("receiving time: " + request.getTime());
			
			try {
				
				DiningStreetResponse.Builder response = DiningStreetResponse.newBuilder(); 
				float time = request.getTime(); 
				
				//depending on the time of the day, send different responses
				if (time >= 11 && time <= 24) { // if it's between 11am and midnight
					response.setIsClosed(true);	
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);

					response.setIsClosed(true);
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);	
					
				} else { // if it's past midnight and before 11am
					response.setIsClosed(false);	
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);

					response.setIsClosed(false);
					responseObserver.onNext(response.build()); 
					Thread.sleep(1000);	
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				responseObserver.onCompleted();
			}
		}
		
	}

}
