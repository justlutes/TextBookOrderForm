package JUnitTesting;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;


public class ConnectionInfoModelTest {

	@Test
	public void test_ConnectionInfo() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:myslql://doubledproduction.org:3306/final_project"
				, "team9", "boobs");
		
		assertNotNull(con);
		assertTrue(con.isValid(0));
		
		con.close();
		
		
	}

}
