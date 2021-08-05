package grpc.trafficservice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import grpc.jmdns.SimpleServiceDiscovery;
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
		
		//Service discovery:
		ServiceInfo serviceInfo;
		String service_type = "_grpc1._tcp.local."; //type of service we are looking for on the server
		//Now retrieve the service info 
		serviceInfo = SimpleServiceDiscovery.run(service_type); //discover the port
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		//Create the channel 
		ManagedChannel trafficChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	
		//Create a stub, pass the channel to the stub
		bStub = trafficServiceGrpc.newBlockingStub(trafficChannel);	
		//async stub
		asyncStub = trafficServiceGrpc.newStub(trafficChannel);
		
		try {					
			// Uncomment the rpc that you want to use:
			//sendEmergency();	
			//liveFeed();
			//calculatePedestrianNumber();
			streetAlert();	
			
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
		Area requestArea = Area.newBuilder().setIntArea(4).build();
		
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
				// print the response from the server
				System.out.println("Response: " + value.getText());				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();			
			}

			@Override
			public void onCompleted() {
				System.out.println("stream completed, received data from the camera.");	
			}				
		};
		
		//generate random numbers that represents the number of people currently in the street
		Random myRan = new Random();
		int randomNumber1 = myRan.nextInt(100); // 0, 1, 2, ..., 98, 99
		int randomNumber2 = myRan.nextInt(200);
		int randomNumber3 = myRan.nextInt(50);
		int randomNumber4 = myRan.nextInt(400);
		
		//create the message and send it to the server
		StreamObserver<Video> requestObserver = asyncStub.calculatePedestrianNumber(responseObserver);
		//1st data
		requestObserver.onNext(Video.newBuilder().setPedestrianNumber(randomNumber1).build());
		Thread.sleep(500);
		//2dn data
		requestObserver.onNext(Video.newBuilder().setPedestrianNumber(randomNumber2).build());
		Thread.sleep(500);
		
		requestObserver.onNext(Video.newBuilder().setPedestrianNumber(randomNumber3).build());
		Thread.sleep(500);
		
		requestObserver.onNext(Video.newBuilder().setPedestrianNumber(randomNumber4).build());
		Thread.sleep(500);
		
		System.out.println("Sending data");
		
		requestObserver.onCompleted();
		
		Thread.sleep(5000); //pause our thread		
	}
	
	//bi-di rpc
	public static void streetAlert() throws InterruptedException {
				
		StreamObserver<UserAlertRequest> requestObserver = asyncStub.streetAlert(new StreamObserver<UserAlertResponse>() {

			@Override
			public void onNext(UserAlertResponse value) {
				System.out.println("Receiving alerts: " + value.getResult());				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();				
			}

			@Override
			public void onCompleted() {
				System.out.println("Server is done sending alerts");
			}
		});
		
		requestObserver.onNext(UserAlertRequest.newBuilder().setAlert(Alert.newBuilder().setLocation("Parnell Street").setMessage("Pedestrian lying on the road")).build());
		//Thread.sleep(500);
		requestObserver.onNext(UserAlertRequest.newBuilder().setAlert(Alert.newBuilder().setLocation("Exchequer Street").setMessage("Careful, lot of people partying")).build());
		//Thread.sleep(500);
		requestObserver.onNext(UserAlertRequest.newBuilder().setAlert(Alert.newBuilder().setLocation("Merrion Square W").setMessage("Protests in progress")).build());
		//Thread.sleep(500);
		requestObserver.onNext(UserAlertRequest.newBuilder().setAlert(Alert.newBuilder().setLocation("George Street").setMessage("Street is overcrowded")).build());
		//Thread.sleep(500);
		
		requestObserver.onCompleted();
		Thread.sleep(5000);	
	}
}
