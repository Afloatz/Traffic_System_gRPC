package grpc.plannerservice;

import java.util.concurrent.TimeUnit;

import grpc.plannerservice.DayRequest.DayOfTheWeek;
import grpc.plannerservice.PlannerServiceGrpc.PlannerServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class PlannerClient {
	
	private static PlannerServiceBlockingStub bStub;
	
	public static void main(String[] args) throws InterruptedException {
		//Build a channel (to connect the server and client)
		int port = 50052; 
		String host = "localhost"; // location of the server
		
		//Create the channel 
		ManagedChannel plannerChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	
		//Create a stub, pass the channel to the stub
		bStub = PlannerServiceGrpc.newBlockingStub(plannerChannel);
		
		PlannerServiceGrpc.newStub(plannerChannel);
		
		try {		
			// Uncomment the rpc that you want to use:
			//getPedestrianStreets();
			getDiningStreets();
			
				
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
		} finally {
			plannerChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);			
		}	
		
	}
	
	// server streaming
	public static void getPedestrianStreets() {
		//prepare the request
		DayRequest requestDay = DayRequest.newBuilder().setDayOfTheWeek(DayOfTheWeek.WEDNESDAY).build();
		
		//stream the responses
		bStub.getPedestrianStreets(requestDay).forEachRemaining(StreetResponse -> {
			System.out.println(StreetResponse.getMessage());
		});
	}
	
	// server streaming for rpc 2
	public static void getDiningStreets() {
		//prepare the request
		TimeRequest request = TimeRequest.newBuilder().setTime(12f).build();
		
		//stream the responses
		System.out.println("List of streets having or not outdoor dining at the time you selected: ");
		bStub.getDiningStreets(request).forEachRemaining(DiningStreetResponse -> {
			if (DiningStreetResponse.getHasOutdoorDining()) {
				System.out.println(DiningStreetResponse.getStreetName() + ": has outdoor dining.");			
			} else {
				System.out.println(DiningStreetResponse.getStreetName() +": no outdoor dining at this time");
			}
		});
	}

}
