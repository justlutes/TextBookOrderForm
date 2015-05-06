package JUnitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import finalProject.model.BookModel;
import finalProject.model.RequisitionModel;

public class RequisitionModelTest {
	
	ArrayList<BookModel> books1;
	ArrayList<BookModel> books2;
	
	@Before
	public void setUp() {
		BookModel book1 = new BookModel(
				"1234A", "3303", "1", "Bob Smith", "White Press",
				"Programming", 1, 1, false );
		BookModel book2 = new BookModel(
				"2345B", "4030", "2", "Pablo Peterson", "Red Press",
				"More Programming", 1,
				1, false );
		
		books1 = new ArrayList<BookModel>();
		books1.add(book1);
		books2 = new ArrayList<BookModel>();
		books2.add(book2);
	}

	@Test
	public void test_returnRequisition() {
		
		RequisitionModel requisition = new RequisitionModel("007", 
				"12345", "3024", books1, 200);
		RequisitionModel requisition2 = new RequisitionModel("006", 
				"111", "3324", books2, 350);
		
		assertEquals("007", requisition.getInstructor_ID());
		assertEquals("111", requisition2.getCourse_ID());
		assertEquals(200, requisition.getExpectedEnrollment());
		
		requisition.setInstructor_ID("009");
		assertEquals("009", requisition.getInstructor_ID());
		
		requisition2.setExpectedEnrollment(500);
		assertEquals(500, requisition2.getExpectedEnrollment());
		
		assertEquals(books1, requisition.getBooks());
		assertEquals(books2, requisition2.getBooks());
		
		
	}

}
