package finalProject;

import java.util.ArrayList;

import javax.swing.JFrame;

import finalProject.model.BookModel;
import finalProject.model.ConnectionInfoModel;
import finalProject.model.CourseModel;
import finalProject.model.InstructorModel;
import finalProject.model.RequisitionModel;
import finalProject.view.LoginScreen;

public class Main {
	
	private JFrame frmLoginScreen;

	public static void main(String[] args) {
		
		System.out.println( "No errors, yet." );
		
		//Starts the GUI
		{
		LoginScreen window = new LoginScreen();
		window.frmLoginScreen.setVisible(true);
		}
	}

}
