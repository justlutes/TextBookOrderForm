package finalProject.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import finalProject.model.ConnectionInfoModel;
import finalProject.model.UserSessionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class LoginScreen {

	public JFrame frmLoginScreen;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private String credUsername, credPassword;

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ConnectionInfoModel con = new ConnectionInfoModel();
		frmLoginScreen = new JFrame();
		frmLoginScreen.setTitle("Login Screen");
		frmLoginScreen.setBounds(100, 100, 450, 280);
		frmLoginScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmLoginScreen.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterYour = new JLabel("Sign In");
		lblPleaseEnterYour.setFont(new Font("Impact", Font.PLAIN, 25));
		lblPleaseEnterYour.setBounds(20, 11, 190, 45);
		frmLoginScreen.getContentPane().add(lblPleaseEnterYour);
		
		JLabel lblSignIntoThe = new JLabel("Sign Into the Order Form with your credentials below.");
		lblSignIntoThe.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSignIntoThe.setBounds(20, 55, 250, 30);
		frmLoginScreen.getContentPane().add(lblSignIntoThe);
		
		JLabel lblUsername = new JLabel("Teacher ID");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(20, 96, 180, 30);
		frmLoginScreen.getContentPane().add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(20, 137, 250, 20);
		frmLoginScreen.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(20, 155, 100, 30);
		frmLoginScreen.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(20, 185, 145, 20);
		frmLoginScreen.getContentPane().add(passwordField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				credUsername = textFieldUsername.getText();
				credPassword = new String(passwordField.getPassword());
				
				//Initial DB Connection made to check username and Password and log them in.
				UserSessionModel user = new UserSessionModel(credUsername, credPassword, con.getCon());
				
				//Change this flag if pass or fail.
				boolean credentialsPass = false;
				try {
					if(user.authenticate() == true){
						credentialsPass = true;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//Checks the login credentials to see if they are accurate.
				if(credentialsPass){
					//Maybe pull the Name from the DB Table?
					String instructorEmail = user.getUsername();
					String instructorName = user.getUser().getName();
					
					int flag = 0;
					if(user.getUser().isAdmin() == true){
						flag = 1;
					}
					
					//If they do not have that flag they get the generic teacher view to order a book for a class.
					if(flag == 0){
						TeacherOrderForm window = new TeacherOrderForm( instructorName, instructorEmail, user.getUser(), con.getCon());
						window.frame.setVisible(true);
						frmLoginScreen.setVisible(false);
					}
					else if(flag == 1){
						
						Object[] options = {
								"Teacher View",
								"Department View",
								"Cancel"
						};
						
						int n = JOptionPane.showOptionDialog(frmLoginScreen,
							    "Would you like to login "
							    + "with Teacher View or Department View?",
							    "Which View",
							    JOptionPane.YES_NO_CANCEL_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,
							    options,
							    options[2]);
						
						if(n == 1){
							overView window = new overView(instructorName, con.getCon());
							window.frame.setVisible(true);
							frmLoginScreen.setVisible(false);
						}
						else if(n == 0){
							TeacherOrderForm window = new TeacherOrderForm( instructorName, instructorEmail, user.getUser(), con.getCon());
							window.frame.setVisible(true);
							frmLoginScreen.setVisible(false);
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Credentials are invalid. Please try again.");
				}
			}
		});
		btnSubmit.setBounds(236, 208, 89, 23);
		frmLoginScreen.getContentPane().add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowClosing();
			}
		});
		btnCancel.setBounds(335, 208, 89, 23);
		frmLoginScreen.getContentPane().add(btnCancel);
		
		frmLoginScreen.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frmLoginScreen, 
		            "Are you sure you wish to close?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
		    }
		});
	}
	public void windowClosing() {
        if (JOptionPane.showConfirmDialog(frmLoginScreen, 
            "Are you sure you wish to close?", "Really Closing?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}
