package grpc.client;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import grpc.trafficservice.Area;
import grpc.trafficservice.EmergencyResponse;
import grpc.trafficservice.RequestEmergency;
import grpc.trafficservice.trafficServiceGrpc;
import grpc.trafficservice.trafficServiceGrpc.trafficServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;



public class MainGUIApplication {
	
	private static trafficServiceBlockingStub blockingStub;
	
	private JFrame frame;
	private JTextField textLocation, textNumber; //text field is declared here
	private JTextArea textResponse, textResponse2 ; //text area to put the response into

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
		
		int port = 50051;
		String host = "localhost"; 
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		blockingStub = trafficServiceGrpc.newBlockingStub(channel);
		
		initialize(); //defined below
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); 
		frame.setTitle("Traffic Client - Service Controller");
		frame.setBounds(100, 100, 500, 300); //where the window will be and its size
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
		JLabel lblNewLabel_1 = new JLabel(" Send emergency at (enter location) ");
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
		
	}
}
