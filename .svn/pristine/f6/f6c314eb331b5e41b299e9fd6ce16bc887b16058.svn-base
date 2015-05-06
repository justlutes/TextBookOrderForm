package JUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import finalProject.model.CourseModel;
import finalProject.model.InstructorModel;
import finalProject.model.SectionModel;

public class SectionModelTest {
	
	CourseModel course1 = new CourseModel("101", "Programming");
	InstructorModel instructor1 = new InstructorModel("12345", "Password", 
			"Prof. S", false, null);

	@Test
	public void test() {
		SectionModel section = new SectionModel();
		
		section.setSection_ID("008");
		assertEquals("008", section.getSection_ID());
		
		section.setCourse_ID(course1);
		assertEquals(course1, section.getCourse_ID());
		
		section.setInstructor_ID(instructor1);
		assertEquals(instructor1, section.getInstructor_ID());
	}

}
