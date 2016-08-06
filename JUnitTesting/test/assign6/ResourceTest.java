package assign6;

import static org.junit.Assert.*;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import lms.Book;
import lms.Resource;

public class ResourceTest {
	Resource resource;
	Calendar dueDate;
	Calendar returnDate;
	
	@Before
	public void setUp()
	{
		resource = new Book(0, null, null, null);
		dueDate = Calendar.getInstance();
		dueDate.add(Calendar.DATE, 0);
		resource.setDueDate(dueDate);
	}
	
	@Test
	public void returnOnDueDate() 
	{	
		returnDate = Calendar.getInstance();
		returnDate.add(Calendar.DATE,0);
		assertEquals("Fine should be: ", 0.00,
				resource.calculateFine(returnDate), .01);
	}
	
	@Test
	public void returnBeforeDueDate()
	{
		returnDate = Calendar.getInstance();
		returnDate.add(Calendar.DATE, -10);
		assertEquals("Fine should be: ", 0.00,
				resource.calculateFine(returnDate), .01);
	}
	
	@Test
	public void returnAfterDueDate()
	{
		returnDate = Calendar.getInstance();
		returnDate.add(Calendar.DATE, 10);
		assertEquals("Fine should be: ", 2.50,
				resource.calculateFine(returnDate), .01);
	}
	
	@Test
	public void returnAfter20Days()
	{
		returnDate = Calendar.getInstance();
		returnDate.add(Calendar.DATE, 21);
		assertEquals("Fine should be: ", 5.00,
				resource.calculateFine(returnDate), .01);
	}
}
