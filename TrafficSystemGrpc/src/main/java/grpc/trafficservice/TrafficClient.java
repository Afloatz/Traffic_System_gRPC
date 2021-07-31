package grpc.trafficservice;

import java.util.concurrent.TimeUnit;

import grpc.trafficservice.trafficServiceGrpc.trafficServiceBlockingStub;
import grpc.trafficservice.trafficServiceGrpc.trafficServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class TrafficClient {
	
	private static trafficServiceBlockingStub bStub;
	private static trafficServiceStub asyncStub;
	
	public static void main(String[] args) throws InterruptedException {
		
		//Build a channel (to connect the server and client)
		int port = 50051; 
		String host = "localhost"; // location of the server
		
		//Create the channel 
		ManagedChannel trafficChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	
		//Create a stub, pass the channel to the stub
		//for unary -> need a BlockingStub
		bStub = trafficServiceGrpc.newBlockingStub(trafficChannel);
		
		// async stub
		asyncStub = trafficServiceGrpc.newStub(trafficChannel);
		
		try {		
			
			//sendEmergency();	
			liveFeed();
			//calculatePedestrianNumber();
			
			
		} catch (StatusRuntimeException e) {
			System.out.println(e.getMessage());
		} finally {
			trafficChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);			
		}
			
			
	}
	
	//  unary rpc
	public static void sendEmergency() {
		//now build our message
		RequestEmergency rEmergency = RequestEmergency.newBuilder().setMessage("Emergency at Capel Street").build();
			
		// bring back the message from the server
		EmergencyResponse response = bStub.sendEmergency(rEmergency);
		System.out.println(response.getText());	
	}
	
	
	// server streaming
	public static void liveFeed() {
		//prepare the request
		Area requestArea = Area.newBuilder().setIntArea(1).build();
		
		//stream the responses
		bStub.liveFeed(requestArea).forEachRemaining(StreetSituation -> {
			System.out.println(StreetSituation.getTextSituation());
		});
	}
	
	// client streaming rpc
	public static void calculatePedestrianNumber() throws InterruptedException {
		
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
				System.out.println("stream completed, received data from the camera.");	
			}				
		};
		
		//create the message and send it to the server
		StreamObserver<Video> requestObserver = asyncStub.calculatePedestrianNumber(responseObserver);
		//1st data
		requestObserver.onNext(Video.newBuilder().setPedestrianNumber(86).build());
		Thread.sleep(500);
		//2dn data
		requestObserver.onNext(Video.newBuilder().setPedestrianNumber(189).build());
		Thread.sleep(500);
		
		requestObserver.onNext(Video.newBuilder().setPedestrianNumber(152).build());
		Thread.sleep(500);
		
		requestObserver.onNext(Video.newBuilder().setPedestrianNumber(140).build());
		Thread.sleep(500);
		
		System.out.println("Sending data");
		
		requestObserver.onCompleted();
		
		Thread.sleep(5000); //pause our thread		
	}
	

}
