package grpc.trafficservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TrafficClient {
	
	public static void main(String[] args) {
		
		//Build a channel (to connect the server and client)
		int port = 50051; 
		String host = "localhost"; // location of the server
		
		//Create the channel 
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	}
	

}
