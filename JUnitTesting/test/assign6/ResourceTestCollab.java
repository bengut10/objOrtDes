package assign6;

import static org.junit.Assert.*;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import lms.*;

public class ResourceTestCollab {

	//This class will test the collaborating classes Member and 
	//Resource as they carry out the CalculateNueDate operation.
	//The test will be passed if the dueDate satisfies the 
	//functional requirement of when a resource is due.
	
	Member member1, member2;
	Resource resource1, resource2;
	Calendar dueDate, checkOut, check;

	/*
	* setUp method creates two Calendar objects with the current date.
	*/
	@Before
	public void setUp()
	{
		checkOut = Calendar.getInstance();	
		check = Calendar.getInstance();		
	}
	
<<<<<<< HEAD
	//Test a student and a book as resource.
=======
	/*
	* testStudentBook checks if the due date was correctly set for
	* a student's book.
	*/
>>>>>>> branch 'master' of https://github.com/bengut10/objOrtDes.git
	@Test
	public void testStudentBook()
	{
		member1 = new Student(123);
		resource1 = new Book(10, "fefe", "gtgt", "rer");
		//Books are checked out to students for 4 weeks.
		check.add(Calendar.DATE, 28);
		//Check will be a few milliseconds higher than 
		//dueDate since it was called first.
		dueDate = resource1.calculateNewDueDate(checkOut, member1);
		//Check for difference in time less than .1 second.
		assertTrue((check.getTimeInMillis() 
				- dueDate.getTimeInMillis()) <= 100);
	}
	
<<<<<<< HEAD
	//Test a faculty member and a book as resource.
=======
	/*
	* testFacultyBook checks if the due date was correctly set for 
	* a faculty member's book.
	*/
>>>>>>> branch 'master' of https://github.com/bengut10/objOrtDes.git
	@Test
	public void testFacultyBook()
	{
		member1 = new Faculty(123);
		resource1 = new Book(10, "fefe", "gtgt", "rer");
		//Books are checked out to faculty members for 3 months.
		check.add(Calendar.MONTH, 3);
		//Check will be a few milliseconds higher than 
		//dueDate since it was called first.
		dueDate = resource1.calculateNewDueDate(checkOut, member1);
		//Check for difference in time less than .1 second.
		assertTrue((check.getTimeInMillis() 
				- dueDate.getTimeInMillis()) <= 100);
	}
	
<<<<<<< HEAD
	//Test a student and a movie as resource.
=======
	/*
	* testStudentMovie checks if the due date was correctly set for 
	* a student's movie.
	*/
>>>>>>> branch 'master' of https://github.com/bengut10/objOrtDes.git
	@Test
	public void TestStudentMovie()
	{
		member1 = new Student(123);
		resource1 = new Movie(10,"e2e","fl3");
		//Movies are checked out for 7 days.
		check.add(Calendar.DATE, 7);
		//Check will be a few milliseconds higher than 
		//dueDate since it was called first.
		dueDate = resource1.calculateNewDueDate(checkOut, member1);
		//Check for difference in time less than .1 second.
		assertTrue((check.getTimeInMillis()
				- dueDate.getTimeInMillis()) <= 100);
	}
	
<<<<<<< HEAD
	//Test a faculty member and a movie as resource.
=======
	/*
	* testFacultyBook checks if the due date was correctly set for 
	* a faculty member's movie.
	*/
>>>>>>> branch 'master' of https://github.com/bengut10/objOrtDes.git
	@Test
	public void TestFacultyMovie()
	{
		member1 = new Faculty(123);
		resource1 = new Movie(10,"e2e","fl3");
		//Movies are checked out for 7 days.
		check.add(Calendar.DATE, 7);
		//Check will be a few milliseconds higher than 
		//dueDate since it was called first.
		dueDate = resource1.calculateNewDueDate(checkOut, member1);
		//Check for difference in time less than .1 second.
		assertTrue((check.getTimeInMillis() - dueDate.getTimeInMillis()) <= 100);
	}	
}
