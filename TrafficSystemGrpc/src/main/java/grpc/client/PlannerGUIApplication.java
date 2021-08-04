package grpc.client;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import grpc.plannerservice.DayRequest.DayOfTheWeek;
import grpc.plannerservice.DayRequest;
import grpc.plannerservice.PlannerServiceGrpc;
import grpc.plannerservice.PlannerServiceGrpc.PlannerServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PlannerGUIApplication {
	
	private static PlannerServiceBlockingStub blockingStub;
	
	private JFrame frame;
	private JTextArea textResponse; //text area to put the response into

	/**
	 * Launch the application.
	 */

	//standard structure for the main method to launch the GUI
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlannerGUIApplication window = new PlannerGUIApplication();
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
	public PlannerGUIApplication() {
		
		int port = 50052;
		String host = "localhost"; 
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		blockingStub = PlannerServiceGrpc.newBlockingStub(channel);
		
		initialize(); //defined below
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame(); 
		frame.setTitle("Planner Client - Service Controller");
		frame.setBounds(100, 100, 500, 300); //where the window will be and its size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		JPanel panel_service_1 = new JPanel(); 
		frame.getContentPane().add(panel_service_1);
		//flowlayout to display the components
		panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		/**
		 * //SERVER STREAMING RPC GetPedestrianStreets
		 */
		
		//create new label and add it to the panel
		JLabel lblNewLabel_1 = new JLabel(" Choose a day: ");
		panel_service_1.add(lblNewLabel_1);
		
		
		//combo box
		//dropdown list with the values that the user can choose from
		String[] days = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		JComboBox comboDays = new JComboBox();
		comboDays.setModel(new DefaultComboBoxModel(days));
		panel_service_1.add(comboDays);
			
		
		JButton btnSend = new JButton("Tell me which streets are closed on that day");
		
		//add an action listener to our button
		btnSend.addActionListener(new ActionListener() {
			
			//this will happen when the button is clicked
			public void actionPerformed(ActionEvent e) {
				
				//retrieve data from GUI (here 1 data: index of the corresponding day)
				int index = comboDays.getSelectedIndex();
				DayOfTheWeek day = DayOfTheWeek.forNumber(index);
					
				//talk to the server
				DayRequest requestDay = DayRequest.newBuilder().setDayOfTheWeek(day).build();

				//populate the JTextArea in the panel
				blockingStub.getPedestrianStreets(requestDay).forEachRemaining(StreetResponse -> {
					textResponse.append("\nReply: " + StreetResponse.getMessage());
				});
				
			}
		});
		panel_service_1.add(btnSend);
		
		textResponse = new JTextArea(5, 30); //construct a new text area for the response
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		panel_service_1.add(scrollPane);
	}
}
