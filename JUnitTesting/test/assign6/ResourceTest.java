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
	
	
	/*
	* setUp method sets a Resource object
	* of Book to null and two Calendar objects.
	* setUp is run again before each test method.
	*/
	@Before
	public void setUp()
	{
		resource = new Book(0, null, null, null);
		dueDate = Calendar.getInstance();
		dueDate.add(Calendar.DATE, 0);
		resource.setDueDate(dueDate);
	}
	/*
	* returnOnDueDate method checks that there is no fine if
	* resource is returned on due date.
	*/
	@Test
	public void returnOnDueDate() 
	{	
		returnDate = Calendar.getInstance();
		returnDate.add(Calendar.DATE,0);
		assertEquals("Fine should be: ", 0.00,
				resource.calculateFine(returnDate), .01);
	}
	/*
	* returnBeforeDueDate method checks that there is no fine if
	* resource is returned before due date.
	*/
	@Test
	public void returnBeforeDueDate()
	{
		returnDate = Calendar.getInstance();
		returnDate.add(Calendar.DATE, -10);
		assertEquals("Fine should be: ", 0.00,
				resource.calculateFine(returnDate), .01);
	}
	
	/*
	* returnAfterDueDate method checks that there is an appropriate
	* fine dependant on the number of days the resource is past due.
	*/
	@Test
	public void returnAfterDueDate()
	{
		returnDate = Calendar.getInstance();
		returnDate.add(Calendar.DATE, 10);
		assertEquals("Fine should be: ", 2.50,
				resource.calculateFine(returnDate), .01);
	}
	
	/*
	* returnAfter20Days checks that the fine does not exceed the
	* $5.00 max limit, but still gives the $5.00 fine.
	*/
	@Test
	public void returnAfter20Days()
	{
		returnDate = Calendar.getInstance();
		returnDate.add(Calendar.DATE, 21);
		assertEquals("Fine should be: ", 5.00,
				resource.calculateFine(returnDate), .01);
	}
}
