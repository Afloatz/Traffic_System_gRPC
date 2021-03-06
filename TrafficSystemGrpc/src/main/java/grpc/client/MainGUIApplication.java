package grpc.client;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.jmdns.ServiceInfo;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import grpc.jmdns.SimpleServiceDiscovery;
import grpc.trafficservice.Alert;
import grpc.trafficservice.Area;
import grpc.trafficservice.EmergencyResponse;
import grpc.trafficservice.RequestEmergency;
import grpc.trafficservice.UserAlertRequest;
import grpc.trafficservice.UserAlertResponse;
import grpc.trafficservice.Video;
import grpc.trafficservice.WarningResponse;
import grpc.trafficservice.trafficServiceGrpc;
import grpc.trafficservice.trafficServiceGrpc.trafficServiceBlockingStub;
import grpc.trafficservice.trafficServiceGrpc.trafficServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;



public class MainGUIApplication {
	
	private static trafficServiceBlockingStub blockingStub;
	private static trafficServiceStub asyncStub;
	
	private JFrame frame;
	private JTextField textLocation, textLocation2, textLocation3, textNumber, textMessage1, textMessage2; //text field is declared here
	private JTextArea textResponse, textResponse2, textResponse3, textResponse4; //text area to put the response into

	/**
	 * Launch the application.
	 */

	//launch the GUI
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUIApplication window = new MainGUIApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUIApplication() {
		
		//Service discovery:
		ServiceInfo serviceInfo;
		String service_type = "_grpc1._tcp.local."; //type of service we are looking for on the server
		//Now retrieve the service info 
		serviceInfo = SimpleServiceDiscovery.run(service_type); //discover the port
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		blockingStub = trafficServiceGrpc.newBlockingStub(channel);
		asyncStub = trafficServiceGrpc.newStub(channel);
		
		initialize(); //defined below
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); 
		frame.setTitle("Traffic Client - Service Controller");
		frame.setBounds(100, 100, 400, 700); //where the window will be and its size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		JPanel panel_service_1 = new JPanel(); 
		frame.getContentPane().add(panel_service_1);
		//flowlayout to display the components
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		/**
		 * //UNARY RPC SendEmergency
		 */
		
		//create new label and add it to the panel
		JLabel lblNewLabel_1 = new JLabel(" Send emergency at (enter street name) ");
		panel_service_1.add(lblNewLabel_1);
		
		//Input textbox (associated with the label we have a text field)
		textLocation = new JTextField();
		panel_service_1.add(textLocation);
		//how wide should input box be?
		textLocation.setColumns(10);		
		
		JButton btnSend = new JButton("Send the emergency team");
		
		//add an action listener to that first button
		btnSend.addActionListener(new ActionListener() {
			
			//this will happen when the button is clicked
			public void actionPerformed(ActionEvent e) {
								
				//retrieve data from GUI 
				String location = textLocation.getText();
					
				//talk to the server
				RequestEmergency rEmergency = RequestEmergency.newBuilder().setMessage(location).build();
				EmergencyResponse response = blockingStub.sendEmergency(rEmergency);
				
				//Populate the GUI with the response
				textResponse.append("reply: " + response.getText()); 
				
				System.out.println("response: " + response.getText()); //display on the console
			}
		});
		panel_service_1.add(btnSend);
		
		textResponse = new JTextArea(3, 20); //construct a new text area for the response
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		panel_service_1.add(scrollPane);
		
		
		/**
		 * //SERVER STREAMING RPC LiveFeed
		 */
		
		JLabel lblNewLabel_2 = new JLabel(" Get livefeed (enter Dublin district number) ");
		panel_service_1.add(lblNewLabel_2);
		
		//Input textbox (associated with the label we have a text field)
		textNumber = new JTextField();
		panel_service_1.add(textNumber);
		//how wide should input box be?
		textNumber.setColumns(10);
			
		
		JButton btnSend2 = new JButton("Send me the livefeed from that area");
		
		//add an action listener to our 2nd button
		btnSend2.addActionListener(new ActionListener() {
			
			//this will happen when the button is clicked
			public void actionPerformed(ActionEvent e) {
							
				//retrieve data from GUI 
				int num = Integer.parseInt(textNumber.getText());
					
				//talk to the server
				Area requestArea = Area.newBuilder().setIntArea(num).build();
				
				//Populate the GUI with the response
				blockingStub.liveFeed(requestArea).forEachRemaining(StreetSituation -> {
					textResponse2.append("\nReply: " + StreetSituation.getTextSituation());
				});
				

			}
		});
		panel_service_1.add(btnSend2);
		
		textResponse2 = new JTextArea(5, 30); //construct a new text area for the server streaming response
		textResponse2.setLineWrap(true);
		textResponse2.setWrapStyleWord(true);
		
		JScrollPane scrollPane2 = new JScrollPane(textResponse2);
		
		panel_service_1.add(scrollPane2);
		
		
		/**
		 * //CLIENT STREAMING RPC CalculatePedestrianNumber
		 */
						
		JButton btnSend3 = new JButton("Get foot traffic situation");
		
		//add an action listener to our 3rd button
		btnSend3.addActionListener(new ActionListener() {
			
			//this will happen when the button is clicked
			public void actionPerformed(ActionEvent e) {
							
				//no data to retrieve from GUI since the client in that case is a remote device (a camera with a screen to display the response)
				
				StreamObserver<WarningResponse> responseObserver = new StreamObserver<WarningResponse>() {

					@Override
					public void onNext(WarningResponse value) {
						// print the response from the server on the console
						System.out.println("Response: " + value.getText());	
						//Populate the GUI with the response
						textResponse3.append("\nReply: " + value.getText());	
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
				//2dn data
				requestObserver.onNext(Video.newBuilder().setPedestrianNumber(randomNumber2).build());
								
				requestObserver.onNext(Video.newBuilder().setPedestrianNumber(randomNumber3).build());				
				
				requestObserver.onNext(Video.newBuilder().setPedestrianNumber(randomNumber4).build());		
				
				System.out.println("Sending data");
				
				requestObserver.onCompleted();						
			}
		});
		panel_service_1.add(btnSend3);
		
		textResponse3 = new JTextArea(5, 30); //construct a new text area for the server streaming response
		textResponse3.setLineWrap(true);
		textResponse3.setWrapStyleWord(true);
		
		JScrollPane scrollPane3 = new JScrollPane(textResponse3);
		
		panel_service_1.add(scrollPane3);
		
		/**
		 * //BiDi RPC StreetAlert
		 */
		
		// 1ST ALERT
		
		//create new label and add it to the panel
		JLabel lblNewLabel_3 = new JLabel(" Enter the street1 ");
		panel_service_1.add(lblNewLabel_3);
		
		//Input textbox (associated with the label we have a text field)
		textLocation2 = new JTextField();
		panel_service_1.add(textLocation2);
		//how wide should input box be?
		textLocation2.setColumns(10);	
		
		//create new label and add it to the panel
		JLabel lblNewLabel_4 = new JLabel(" Enter your message alert ");
		panel_service_1.add(lblNewLabel_4);
		
		//Input textbox (associated with the label we have a text field)
		textMessage1 = new JTextField();
		panel_service_1.add(textMessage1);
		//how wide should input box be?
		textMessage1.setColumns(10);	
		
		// 2DN ALERT
		
		//create new label and add it to the panel
		JLabel lblNewLabel_5 = new JLabel(" Enter the street2 ");
		panel_service_1.add(lblNewLabel_5);
		
		//Input textbox (associated with the label we have a text field)
		textLocation3 = new JTextField();
		panel_service_1.add(textLocation3);
		//how wide should input box be?
		textLocation3.setColumns(10);
		
		//create new label and add it to the panel
		JLabel lblNewLabel_6 = new JLabel(" Enter your message alert ");
		panel_service_1.add(lblNewLabel_6);
		
		//Input textbox (associated with the label we have a text field)
		textMessage2 = new JTextField();
		panel_service_1.add(textMessage2);
		//how wide should input box be?
		textMessage2.setColumns(10);
		
		
		
		JButton btnSend4 = new JButton("Receive alerts from the locations");
		
		//add an action listener to that first button
		btnSend4.addActionListener(new ActionListener() {
			
			//this will happen when the button is clicked
			public void actionPerformed(ActionEvent e) {
								
				//retrieve data from GUI 
				String location2 = textLocation2.getText();
				String location3 = textLocation3.getText();
				
				String message1 = textMessage1.getText();
				String message2 = textMessage2.getText();
					
				//talk to the server
				
				StreamObserver<UserAlertRequest> requestObserver = asyncStub.streetAlert(new StreamObserver<UserAlertResponse>() {

					@Override
					public void onNext(UserAlertResponse value) {
						textResponse4.append("Receiving alerts: " + value.getResult());				
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
				
				requestObserver.onNext(UserAlertRequest.newBuilder().setAlert(Alert.newBuilder().setLocation(location2).setMessage(message1)).build());
				requestObserver.onNext(UserAlertRequest.newBuilder().setAlert(Alert.newBuilder().setLocation(location3).setMessage(message2)).build());

			}
		});
		panel_service_1.add(btnSend4);
		
		textResponse4 = new JTextArea(5, 30); //construct a new text area for the response
		textResponse4 .setLineWrap(true);
		textResponse4.setWrapStyleWord(true);
		
		JScrollPane scrollPane4 = new JScrollPane(textResponse4);
		
		panel_service_1.add(scrollPane4);
		
	}
	
	
}
