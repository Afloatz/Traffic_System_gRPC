package grpc.plannerservice;

import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import grpc.jmdns.SimpleServiceDiscovery;
import grpc.plannerservice.DayRequest.DayOfTheWeek;
import grpc.plannerservice.PlannerServiceGrpc.PlannerServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class PlannerClient {
	
	private static PlannerServiceBlockingStub bStub;
	
	public static void main(String[] args) throws InterruptedException {
		
		//Service discovery:
		ServiceInfo serviceInfo;
		String service_type = "_grpc2._tcp.local."; //type of service we are looking for on the server
		//Now retrieve the service info 
		serviceInfo = SimpleServiceDiscovery.run(service_type); //discover the port
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
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
		float time = 12f;
		TimeRequest request = TimeRequest.newBuilder().setTime(time).build();
		
		//stream the responses
		
		//User input validation, time must be in between 0 and 24
		if (time >= 0f && time <= 24f) {
			System.out.println("List of streets having or not outdoor dining at the time you selected: ");
			bStub.getDiningStreets(request).forEachRemaining(DiningStreetResponse -> {
				if (DiningStreetResponse.getHasOutdoorDining()) {
					System.out.println(DiningStreetResponse.getStreetName() + ": has outdoor dining.");			
				} else {
					System.out.println(DiningStreetResponse.getStreetName() +": no outdoor dining at this time");
				}
			});
		} else {
			System.out.println("\n Please enter a correct time");
		}	
	}

}
