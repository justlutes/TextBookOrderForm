package finalProject.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import finalProject.model.RequisitionModelMapper;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class overView {

	JFrame frame;
	private JTable table;
	private String instructorName = "";
	private Connection con;


	/**
	 * Create the application.
	 */
	public overView(String instName, Connection kahn) {
		this.instructorName = instName;
		con = kahn;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = 	new JFrame();
		frame.setBounds(100, 100, 675, 400);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Department : Order Approval");
		
		JLabel lblDepartmentHead = new JLabel("Department Head: ");
		lblDepartmentHead.setBounds(10, 11, 105, 22);
		frame.getContentPane().add(lblDepartmentHead);
		
		JLabel lblPlaceholder = new JLabel(instructorName);
		lblPlaceholder.setBounds(125, 11, 85, 22);
		frame.getContentPane().add(lblPlaceholder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 639, 268);
		frame.getContentPane().add(scrollPane);
		
		
		
		RequisitionModelMapper reqMap = new RequisitionModelMapper(con);
		
		reqMap.mapOrderByID( "8" );
		ArrayList<String> test = reqMap.getAllOrders();
		Object[] kewl = test.toArray();
		String[][] hack = new String[kewl.length][1];
		for(int i = 0; i < kewl.length; i++){
			reqMap.mapOrderByID((String) kewl[i]);
			hack[i][0] = reqMap.getOrder().orderDetails(); 
		}
		
		final DefaultTableModel model = new DefaultTableModel(hack,new String[]{"Testing"});
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Loop To Refresh and Pull New Database Table Here
			}
		});
		btnRefresh.setBounds(10, 49, 89, 23);
		frame.getContentPane().add(btnRefresh);
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Timestamp for Order
				String orderDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
				
				int order = table.getSelectedRow();
				
				JOptionPane.showMessageDialog(frame, "Order was successfully approved.");
				
			}
		});
		btnApprove.setBounds(109, 49, 89, 23);
		frame.getContentPane().add(btnApprove);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frame, 
		            "Are you sure you wish to close?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
		    }
		});
	}
}
