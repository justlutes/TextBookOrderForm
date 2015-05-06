package JUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import finalProject.Required;
import finalProject.model.BookModel;

public class BookModelTest {

	@Test
	public void test() {
		BookModel book1 = new BookModel(
				"1234A", "3303", "1", "Bob Smith", "White Press",
				"Programming", 1, 1, false );
		BookModel book2 = new BookModel(
				"2345B", "4030", "2", "Pablo Peterson", "Red Press",
				"More Programming", 1,
				1, false );
		
		assertEquals("1234A", book1.getIsbn());
		assertEquals("Bob Smith", book1.getAuthor_ID());
		assertEquals("Red Press", book2.getPublisher_ID());
		assertEquals("More Programming", book2.getTitle());
		assertEquals(Required.REQUIRED, book2.getRequired());
		
		book1.setTitle("Awesome Programming");
		assertEquals("Awesome Programming", book1.getTitle());
		
		book2.setPublisher_ID("Lu Kang");
		assertEquals("Lu Kang", book2.getPublisher_ID());
		
		book1.setAuthor_ID("Kewl Hand Mc Steely Face");
		assertEquals("Kewl Hand Mc Steely Face", book1.getAuthor_ID());
		
		book1.setIsbn("007");
		assertEquals("007", book1.getIsbn());
		
		book2.setRequired(Required.OPTIONAL);
		assertEquals(Required.OPTIONAL, book2.getRequired());
		
		
		
		
		
	}

}
