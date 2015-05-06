package finalProject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class InstructorModel {
	private Connection con;
	private String instructor_ID;
	private String password;
	
	private String name;
	
	private boolean admin;
	
	private Map<String, String> courses_sections = new HashMap<String, String>();
	
	private String query;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public InstructorModel(){};
	
	public InstructorModel( String id, Connection con ){
		this.setInstructor_ID( id );
		this.setCon( con );
		
		try {
			this.mapInstructor();
			this.populateCourses_Sections();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println( "CONSTRUCTOR: " + this.getName() );
	};
		
	public InstructorModel( String id, String pw, String name, boolean is_admin, Connection con ) {
		setInstructor_ID( id );
		setPassword( pw );
		setName( name );
		this.setAdmin( is_admin );
		this.setCon( con );	
	}
	
	public void mapInstructor() throws SQLException {
		query = "SELECT * from instructor WHERE instructor_ID = ?";
		ps = this.getCon().prepareStatement( query );
		ps.setString( 1,  this.getInstructor_ID() );
		rs = ps.executeQuery();
		
		System.out.println( "Got this far." );
		while( rs.next() ){
			this.setInstructor_ID( rs.getString( 1 ) );
			this.setPassword( rs.getString( 2 ) );
			this.setName( rs.getString( 3 ) );
			
			System.out.println( rs.getString( 3 ) );
			System.out.println( this.getName() );
			
			if(rs.getString( 4 ).equals("1")){
				this.setAdmin(true);
			}
		}
	}
		
	public void populateCourses_Sections(){
		query = "SELECT course_id, section_id "
				+ "FROM instructor INNER JOIN section "
				+ "ON instructor.instructor_ID = section.instructor_ID "
				+ "WHERE instructor.instructor_ID = ?";
		try {
			ps = this.getCon().prepareStatement( query );
			ps.setString( 1, this.getInstructor_ID() );
			rs = ps.executeQuery();
			while( rs.next() ){
				courses_sections.put( rs.getString( 1 ), rs.getString( 2 ) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showCourses_Sections(){
		for( Map.Entry<String, String> entry : this.getCourses_sections().entrySet() ){
			System.out.println( "Course = " + entry.getKey() + ", Section = " + entry.getValue() );
		}
	}
	
	/**
	 * @return the instructor_ID
	 */
	public String getInstructor_ID() {
		return instructor_ID;
	}

	/**
	 * @param instructor_ID the instructor_ID to set
	 */
	public void setInstructor_ID(String instructor_ID) {
		this.instructor_ID = instructor_ID;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InstructorModel [instructor_ID=" + instructor_ID
				+ ", password=" + password + ", name=" + name + ", admin="
				+ admin + "]";
	}

	/**
	 * @return the courses_sections
	 */
	public Map<String, String> getCourses_sections() {
		return courses_sections;
	}

	/**
	 * @param courses_sections the courses_sections to set
	 */
	public void setCourses_sections(Map<String, String> courses_sections) {
		this.courses_sections = courses_sections;
	}

	/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}

	/**
	 * @param con the con to set
	 */
	public void setCon(Connection con) {
		this.con = con;
	}
}
