package grpc.trafficservice;

import java.util.concurrent.TimeUnit;

import grpc.trafficservice.trafficServiceGrpc.trafficServiceBlockingStub;
import grpc.trafficservice.trafficServiceGrpc.trafficServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class TrafficClient {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Build a channel (to connect the server and client)
		int port = 50051; 
		String host = "localhost"; // location of the server
		
		//Create the channel 
		ManagedChannel trafficChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	
		//Create a stub, pass the channel to the stub
		//for unary -> need a BlockingStub
		trafficServiceBlockingStub bStub = trafficServiceGrpc.newBlockingStub(trafficChannel);
		
		// async stub
		trafficServiceStub asyncStub = trafficServiceGrpc.newStub(trafficChannel);
		
		try {
			// code for the unary rpc -> put it in a separate method
			//now build our message
//			RequestEmergency rEmergency = RequestEmergency.newBuilder().setMessage("Emergency at Capel Street").build();
//				
//			// bring back the message from the server
//			EmergencyResponse response = bStub.sendEmergency(rEmergency);
//			System.out.println(response.getText());
			
			
			// Code for the client streaming
			StreamObserver<WarningResponse> responseObserver = new StreamObserver<WarningResponse>() {

				@Override
				public void onNext(WarningResponse value) {
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
			
			
			
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
		} finally {
			trafficChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);			
		}
			
	
	}
	

}
