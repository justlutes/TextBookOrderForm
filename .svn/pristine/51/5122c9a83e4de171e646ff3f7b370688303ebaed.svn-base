package finalProject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSessionModel {
	private String username;
	private String password;
	private Connection con;
	
	private InstructorModel user; 
	
	private String query;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UserSessionModel(){};
	
	/**
	 * Constructor 
	 * @param user
	 * @param pass
	 * @param con
	 */
	public UserSessionModel( String user, String pass, Connection con ){
		this.setUsername(user);
		this.setPassword(pass);
		this.setCon(con);
	}
	
	public void mapUser() throws SQLException {
		query = "SELECT * from instructor WHERE instructor_ID = ?";
		ps = this.getCon().prepareStatement( query );
		ps.setString( 1,  this.getUsername() );
		rs = ps.executeQuery();
		
		while( rs.next() ){
			user.setInstructor_ID( rs.getString( 1 ) );
			user.setPassword( rs.getString( 2 ) );
			user.setName( rs.getString( 3 ) );
			if(rs.getString( 4 ).equals("1")){
				user.setAdmin(true);
			}
			user.setCon( this.getCon() );
		}
	}
	
	public boolean authenticate() throws SQLException{
		boolean valid_user;
		String dbpass;
		query = "SELECT instructor_PW FROM instructor WHERE instructor_ID = ?";
		
		ps = this.getCon().prepareStatement( query );
		ps.setString( 1, getUsername() );
		
		rs = ps.executeQuery();
		
		rs.next();
		dbpass = rs.getString( 1 );

		if( dbpass.equals( getPassword() ) ) {
			valid_user = true;
			this.setUser( new InstructorModel() );
			this.mapUser();
		}
		else {
			valid_user = false;
		}
		
		return valid_user;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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

	/**
	 * @return the user
	 */
	public InstructorModel getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(InstructorModel user) {
		this.user = user;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the ps
	 */
	public PreparedStatement getPs() {
		return ps;
	}

	/**
	 * @param ps the ps to set
	 */
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	/**
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}

	/**
	 * @param rs the rs to set
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserSessionModel [username=" + username + ", password="
				+ password + ", con=" + con + ", user=" + user + ", query="
				+ query + ", ps=" + ps + ", rs=" + rs + "]";
	}

}
