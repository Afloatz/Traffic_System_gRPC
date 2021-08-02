package grpc.plannerservice;

import java.util.concurrent.TimeUnit;

import grpc.plannerservice.DayRequest.Builder;
import grpc.plannerservice.DayRequest.DayOfTheWeek;
import grpc.plannerservice.PlannerServiceGrpc.PlannerServiceBlockingStub;
import grpc.plannerservice.PlannerServiceGrpc.PlannerServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class PlannerClient {
	
	private static PlannerServiceBlockingStub bStub;
	private static PlannerServiceStub asyncStub;
	
	public static void main(String[] args) throws InterruptedException {
		//Build a channel (to connect the server and client)
		int port = 50052; 
		String host = "localhost"; // location of the server
		
		//Create the channel 
		ManagedChannel plannerChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	
		//Create a stub, pass the channel to the stub
		//for unary -> need a BlockingStub
		bStub = PlannerServiceGrpc.newBlockingStub(plannerChannel);
		
		// async stub
		asyncStub = PlannerServiceGrpc.newStub(plannerChannel);
		
		try {		
			getPedestrianStreets();
				
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

}
