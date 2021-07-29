package grpc.trafficservice;

import java.util.concurrent.TimeUnit;

import grpc.trafficservice.trafficServiceGrpc.trafficServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TrafficClient {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Build a channel (to connect the server and client)
		int port = 50051; 
		String host = "localhost"; // location of the server
		
		//Create the channel 
		ManagedChannel trafficChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	
		//now build our message
		
		RequestEmergency rEmergency = RequestEmergency.newBuilder().setMessage("Emergency at Capel Street").build();
	
		//Create a stub, pass the channel to the stub
		//for unary -> need a BlockingStub
		trafficServiceBlockingStub bStub = trafficServiceGrpc.newBlockingStub(trafficChannel);
	
		// bring back the message from the server
		EmergencyResponse response = bStub.sendEmergency(rEmergency);
		System.out.println(response.getText());
		
		trafficChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	
	}
	

}
;