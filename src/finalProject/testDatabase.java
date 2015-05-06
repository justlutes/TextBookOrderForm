package finalProject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import finalProject.model.ConnectionInfoModel;
import finalProject.model.UserSessionModel;

public class testDatabase {

	public static void main(String[] args) {
		ConnectionInfoModel con = new ConnectionInfoModel();
		UserSessionModel user = new UserSessionModel( "1", "boobs", con.getCon() );
		try {
			user.authenticate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query;
		PreparedStatement ps;
		ResultSet rs;
		Map<String, String> courses_sections = new HashMap<String, String>();
		
		query = "SELECT course_id, section_id "
				+ "FROM instructor INNER JOIN section "
				+ "ON instructor.instructor_ID = section.instructor_ID "
				+ "WHERE instructor.instructor_ID = ?";
		try {
			ps = con.getCon().prepareStatement( query );
			ps.setString( 1, "1" );
			rs = ps.executeQuery();
			while( rs.next() ){
				courses_sections.put( rs.getString( 1 ), rs.getString( 2 ) );				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for( Map.Entry<String, String> entry : courses_sections.entrySet() ){
			System.out.println( "Course = " + entry.getKey() + ", Section = " + entry.getValue() );
		}
		con.disconnect();
	}

}
