package finalProject;

import javax.swing.plaf.synth.SynthSeparatorUI;

import finalProject.model.ConnectionInfoModel;
import finalProject.model.InstructorModel;

public class TestInstructorModel {

	public static void main(String[] args) {
		ConnectionInfoModel connection = new ConnectionInfoModel();
		InstructorModel instructor = new InstructorModel( "2", connection.getCon() );
		System.out.println( instructor.getName() );
		System.out.println( instructor.toString() );
		instructor.showCourses_Sections();
		
		connection.disconnect();

	}

}
