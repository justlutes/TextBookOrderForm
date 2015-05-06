package finalProject.view;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import finalProject.model.BookModel;
import finalProject.model.InstructorModel;
import finalProject.model.RequisitionModel;
import finalProject.model.RequisitionModelMapper;

public class TeacherOrderForm {

	JFrame frame;
	private JTextField textFieldBDEDCP;
	private JTextField textFieldISBN;
	private JTextField textFieldAuthor;
	private JTextField textFieldEnrollmentNum;
	private JTextField textFieldBookTitle;
	private JTextField textFieldPublisher;
	private JTextField txtSpecialInstructions;
	private InstructorModel instructor;
	
	private int[] section;
	private String author, publisher, isbn, bookTitle, instructorEmail, instructorName, sectionsInput, specialInstructions, bdEDCP;
	private int latestEditionFlag = 0, isRecommended = 0;
	private int enrollmentNum = 0;
	private int reqOP = 0;
	private Connection con;
	


	/**
	 * Create the application.
	 */
	public TeacherOrderForm(String name, String email, InstructorModel teacher, Connection kahn) {
		instructorEmail = email;
		instructorName = name;
		instructor = teacher;
		con = kahn;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 435);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Teacher Order Form");
		
		JLabel lblInstructor = new JLabel("Instructor:");
		lblInstructor.setBounds(10, 11, 85, 25);
		frame.getContentPane().add(lblInstructor);
		
		JLabel lblInstructorNameLoc = new JLabel(instructorName);
		lblInstructorNameLoc.setBounds(90, 11, 94, 25);
		frame.getContentPane().add(lblInstructorNameLoc);
		
		JLabel lblEmail = new JLabel("ID:");
		lblEmail.setBounds(10, 47, 65, 25);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblEmailLoc = new JLabel(instructorEmail);
		lblEmailLoc.setBounds(90, 49, 125, 25);
		frame.getContentPane().add(lblEmailLoc);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(10, 120, 46, 25);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(10, 156, 46, 25);
		frame.getContentPane().add(lblIsbn);
		
		JLabel lblEd = new JLabel("BD/ED/CP");
		lblEd.setBounds(10, 192, 65, 25);
		frame.getContentPane().add(lblEd);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 228, 46, 25);
		frame.getContentPane().add(lblStatus);
		
		textFieldBDEDCP = new JTextField();
		textFieldBDEDCP.setBounds(69, 194, 86, 20);
		frame.getContentPane().add(textFieldBDEDCP);
		textFieldBDEDCP.setColumns(10);
		
		textFieldISBN = new JTextField();
		textFieldISBN.setBounds(69, 158, 115, 20);
		frame.getContentPane().add(textFieldISBN);
		textFieldISBN.setColumns(10);
		
		textFieldAuthor = new JTextField();
		textFieldAuthor.setBounds(69, 122, 149, 20);
		frame.getContentPane().add(textFieldAuthor);
		textFieldAuthor.setColumns(24);
		
		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setBounds(250, 125, 65, 20);
		frame.getContentPane().add(lblBookTitle);
		
		JLabel lblNewLabel = new JLabel("Publisher");
		lblNewLabel.setBounds(250, 161, 65, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSections = new JLabel("Sections");
		lblSections.setBounds(250, 238, 65, 25);
		frame.getContentPane().add(lblSections);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setBounds(250, 192, 65, 25);
		frame.getContentPane().add(lblNote);
		
		JLabel lblExpectedEnrollment = new JLabel("Expected Enrollment");
		lblExpectedEnrollment.setBounds(250, 11, 110, 29);
		frame.getContentPane().add(lblExpectedEnrollment);
		
		textFieldEnrollmentNum = new JTextField();
		textFieldEnrollmentNum.setBounds(370, 13, 40, 20);
		frame.getContentPane().add(textFieldEnrollmentNum);
		textFieldEnrollmentNum.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		textFieldBookTitle = new JTextField();
		textFieldBookTitle.setBounds(325, 122, 308, 20);
		frame.getContentPane().add(textFieldBookTitle);
		textFieldBookTitle.setColumns(10);
		
		textFieldPublisher = new JTextField();
		textFieldPublisher.setBounds(325, 158, 220, 20);
		frame.getContentPane().add(textFieldPublisher);
		textFieldPublisher.setColumns(10);
		
		txtSpecialInstructions = new JTextField();
		txtSpecialInstructions.setText("Special Instructions?");
		txtSpecialInstructions.setBounds(325, 194, 250, 20);
		frame.getContentPane().add(txtSpecialInstructions);
		txtSpecialInstructions.setColumns(10);
		
		JRadioButton rdbtnUseLatestEdition = new JRadioButton("Use Latest Edition?");
		rdbtnUseLatestEdition.setBounds(20, 296, 125, 30);
		frame.getContentPane().add(rdbtnUseLatestEdition);
		
		JComboBox comboBoxReqOpRec = new JComboBox();
		comboBoxReqOpRec.setModel(new DefaultComboBoxModel(new String[] {"Required", "Optional"}));
		comboBoxReqOpRec.setBounds(69, 230, 76, 30);
		frame.getContentPane().add(comboBoxReqOpRec);
		
		btnCancel.setBounds(585, 363, 89, 23);
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				windowsClosing();
			}
			
		});
		frame.getContentPane().add(btnCancel);
		
		
		
		JRadioButton rdbtnRecommended = new JRadioButton("Recommended");
		rdbtnRecommended.setBounds(20, 260, 109, 32);
		frame.getContentPane().add(rdbtnRecommended);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(325, 241, 308, 105);
		frame.getContentPane().add(scrollPane);
		
		//Gets Everything ready for the Course / Sections Area
		instructor.populateCourses_Sections();
		Map<String, String> courses = instructor.getCourses_sections();
		String[][] coursesList = new String[courses.size()][2];
		//Goes through the Map that is returned and addes everything the an Array to be added to a JTable
		int ii = 0;
		for(Map.Entry entry : courses.entrySet()){
			coursesList[ii][0] = entry.getKey().toString();
			coursesList[ii][1] = entry.getValue().toString();
			
			ii++;
		}
		
		//Sets up the headers for the JTable
		final DefaultTableModel model = new DefaultTableModel(coursesList,new String[]{"Course","Section"});
		//Adds the JTable and makes it Multiple Selection Capable
		JTable listSections = new JTable(model);
		listSections.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(listSections);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int error = 0;
				author = textFieldAuthor.getText();
				if(author.equals("") && error < 1){
					JOptionPane.showMessageDialog(frame, "Author Field cannot be blank!");
					error = 1;
				}
				publisher = textFieldPublisher.getText();
				if(publisher.equals("") && error < 1){
					JOptionPane.showMessageDialog(frame, "Publisher Field cannot be blank!");
					error = 1;
				}
				isbn = textFieldISBN.getText();
				if(isbn.equals("") && error < 1){
					JOptionPane.showMessageDialog(frame, "ISBN Field cannot be blank!");
					error = 1;
				}
				bookTitle = textFieldBookTitle.getText();
				if(bookTitle.equals("") && error < 1){
					JOptionPane.showMessageDialog(frame, "Book Title Field cannot be blank!");
					error = 1;
				}
				bdEDCP = textFieldBDEDCP.getText();
				if(bdEDCP.equals("") && error < 1){
					JOptionPane.showMessageDialog(frame, "BDEDCP Field cannot be blank!");
					error = 1;
				}
				
				specialInstructions = txtSpecialInstructions.getText();
				
				//Calculate Enrollment Number and checks for correct integer input.
				int enroll = 0;
				if(textFieldEnrollmentNum.getText() != ""){
					try{ 
						enroll = Integer.parseInt(textFieldEnrollmentNum.getText());
					}catch(Exception e){
						System.out.println(e);
					}
				}
				else{
					JOptionPane.showMessageDialog(frame, "Expected Enrollment Field cannot be blank!");
					error = 1;
				}
				
				if(enroll > 0 ){
					enrollmentNum = enroll;
				}
				else{
					error = 1;
					JOptionPane.showMessageDialog(frame, "Expected Enrollment Field cannot be blank!");
				}
				
				//Checks Radio Button and updates flag as necessary.
				if(rdbtnUseLatestEdition.isSelected()){
					latestEditionFlag = 1;
				}
				else{
					latestEditionFlag = 0;
				}
				
				//Checks Radio Button for Recommended and updates flag as necessary.
				if(rdbtnRecommended.isSelected()){
					isRecommended = 1;
				}
				Boolean rec = false;
				if(isRecommended ==1){
					rec = true;
				}
				
				// 0 for Required 1 For Optional 2 For Recommended Defaults to Optional if not selected.
				if(comboBoxReqOpRec.getSelectedItem() == "Recommended"){
					reqOP = 2;
				}
				else{
					reqOP = 1;
				}
				
				//Gets Selected Sections / Rows and concatenates them
				int[] courseSelection = listSections.getSelectedRows();
				if(courseSelection.length == 0){
					JOptionPane.showMessageDialog(frame, "Please select some courses / sections.");
					error = 1;
				}
				String selectedCourses = "";
				String selectedSection = "";
				for(int i = 0; i < courseSelection.length;i++){
					selectedCourses = (String) selectedCourses + " " + listSections.getValueAt(i, 0);
				}
				for(int i = 0; i < courseSelection.length;i++){
					selectedSection = (String) selectedSection + " " + listSections.getValueAt(i, 1);
				}
				
				//System.out.println(selectedCourses);
				//System.out.println(selectedSection);
				
				//ERIC modified this to add CourseID and SectionID
				if(error < 1){
					BookModel newOrderBook = new BookModel( isbn, selectedCourses, selectedSection,  author,  publisher,
							   bookTitle, latestEditionFlag, reqOP, rec );
					
					//Timestamp for Order To Be Used with the Order
					String orderDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
					
					ArrayList<BookModel> bookOrder = new ArrayList<BookModel>();
					bookOrder.add(newOrderBook);
					
					RequisitionModel order = new RequisitionModel(instructor.getInstructor_ID(), selectedCourses, selectedSection, bookOrder,enrollmentNum);
					order.setOrderDate(orderDate);
					
					RequisitionModelMapper map = new RequisitionModelMapper(con);
					map.insertOrder(order);
					
					
					JOptionPane.showMessageDialog(frame, "Order was successfully placed.");
					clearForm();
				}
				
			}
		});
		btnSubmit.setBounds(486, 363, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
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
	
	/**
	 * Generates Dialog window and closes the form.
	 * @param windowEvent
	 */
	public void windowsClosing() {
        if (JOptionPane.showConfirmDialog(frame, 
            "Do you wish to close?", "Really Closing?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
	
	/**
	 * Clears the form for another order.
	 */
	public void clearForm(){
		textFieldAuthor.setText("");
		textFieldPublisher.setText("");
		textFieldBDEDCP.setText("");
		textFieldISBN.setText("");
		textFieldBookTitle.setText("");
		textFieldEnrollmentNum.setText("");
	}
}
