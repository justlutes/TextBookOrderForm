package JUnitTesting;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import finalProject.model.InstructorModel;

public class InstructorModelTest {

	@Test
	public void test_returnInstructor() {
		InstructorModel instructor1 = new InstructorModel("12345", "Password", 
				"Prof. S", false, null);		
		InstructorModel instructor2 = new InstructorModel("101", "Password", 
				"John", true, null);
		
		assertEquals("12345", instructor1.getInstructor_ID());
		assertEquals("Password", instructor2.getPassword());
		assertEquals("Prof. S", instructor1.getName());
		assertEquals(true, instructor2.isAdmin());
		
		instructor1.setInstructor_ID("1025");
		assertEquals("1025", instructor1.getInstructor_ID());
		
		instructor2.setName("Bob");
		assertEquals("Bob", instructor2.getName());
		
		instructor1.setAdmin(true);
		assertEquals(true, instructor1.isAdmin());
		
		
		
		
	}

}
