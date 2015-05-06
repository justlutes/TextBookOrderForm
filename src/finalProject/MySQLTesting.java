package finalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLTesting {

	public static void main(String[] args) {
		Connection con = null;
		try {
			//REGISTER JDBC DRIVER
			System.out.println( "Registering JDBC:mySQL Driver... " );
			Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
			System.out.println( "Successfully loaded JDBC:mySQL driver." );
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//OPEN A CONNECTION
		System.out.println( "Connecting to Database..." );
		try {
			con = DriverManager.getConnection( "jdbc:mysql://doubledproductions.org:3306/final_project", "team9", "boobs" );
			System.out.println( "Connection successful!" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//DISCONNECT
		System.out.println( "Disconnecting from Database..." );
		try {
			con.close();
			System.out.println( "Connection closed successfully!" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
