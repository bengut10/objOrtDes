package assign6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import lms.*;

public class ControllerTest 
{
	//This class will test the controller checkout operation.
	//More specifically it will test whether the Member and Resources
	//were changed appropriately after the operation.
	
	Member member;
	Resource resource;
	Controller controller;
	Collection collection;
	MemberList memberlist;
	
	@Before
	public void setUp() 
	{
		member = new Student(10);
		resource = new Book(10,"fnei", "ewrw", "wer");
		collection = new Collection();
		memberlist = new MemberList();
		memberlist.addMember(member);
		collection.addResource(resource);
		controller = new Controller(memberlist,collection);
		controller.checkout(10, 10);
	}
	
	//Test that the resource was properly checkout out to the member.
	@Test
	public void TestMemberCheckout()
	{
		assertEquals(resource,member.findResource(10));
	}
	
	//Test that the book with the given id status was changed properly.
	@Test 
	public void TestResourceCheckout()
	{
		assertTrue(member.findResource(10).getStatus() == 0);
	}

}
