package JUnitTesting;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import finalProject.model.UserSessionModel;

public class UserSessionModelTest {

	@Test
	public void test() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:myslql://doubledproduction.org:3306/final_project"
				, "team9", "boobs");
		UserSessionModel session = new UserSessionModel("testuser", "testpass", con);
		
		assertNotNull(con);
		assertTrue(con.isValid(0));
		
		con.close();
		assertEquals("testuser", session.getUsername());
		assertEquals("testpass", session.getPassword());
		
		session.setUsername("testuser2");
		assertEquals("testuser2", session.getPassword());
	}

}
