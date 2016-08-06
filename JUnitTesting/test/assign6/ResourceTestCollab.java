package assign6;

import static org.junit.Assert.*;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import lms.Book;
import lms.Faculty;
import lms.Member;
import lms.Movie;
import lms.Resource;
import lms.Student;

public class ResourceTestCollab {

	Member member1, member2;
	Resource resource1, resource2;
	Calendar dueDate, checkOut, check;

	@Before
	public void setUp()
	{
		checkOut = Calendar.getInstance();	
		check = Calendar.getInstance();		
	}
	
	@Test
	public void testStudentBook()
	{
		member1 = new Student(123);
		resource1 = new Book(10, "fefe", "gtgt", "rer");
		//Books are checked out to students for 4 weeks.
		check.add(Calendar.DATE, 28);
		dueDate = resource1.calculateNewDueDate(checkOut, member1);
		//Check for difference in time less than .1 second.
		assertTrue((check.getTimeInMillis() - dueDate.getTimeInMillis()) <= 100);
	}
	
	@Test
	public void testFacultyBook()
	{
		member1 = new Faculty(123);
		resource1 = new Book(10, "fefe", "gtgt", "rer");
		//Books are checked out to faculty members for 3 months.
		check.add(Calendar.MONTH, 3);
		dueDate = resource1.calculateNewDueDate(checkOut, member1);
		//Check for difference in time less than .1 second.
		assertTrue((check.getTimeInMillis() - dueDate.getTimeInMillis()) <= 100);
	}
	
	@Test
	public void TestStudentMovie()
	{
		member1 = new Student(123);
		resource1 = new Movie(10,"e2e","fl3");
		//Movies are checked out for 7 days.
		check.add(Calendar.DATE, 7);
		dueDate = resource1.calculateNewDueDate(checkOut, member1);
		//Check for difference in time less than .1 second.
		assertTrue((check.getTimeInMillis() - dueDate.getTimeInMillis()) <= 100);
	}
	
	@Test
	public void TestFacultyMovie()
	{
		member1 = new Faculty(123);
		resource1 = new Movie(10,"e2e","fl3");
		//Movies are checked out for 7 days.
		check.add(Calendar.DATE, 7);
		dueDate = resource1.calculateNewDueDate(checkOut, member1);
		//Check for difference in time less than .1 second.
		assertTrue((check.getTimeInMillis() - dueDate.getTimeInMillis()) <= 100);
	}	
}
