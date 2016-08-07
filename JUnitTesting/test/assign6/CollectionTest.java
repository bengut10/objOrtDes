package assign6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import lms.Book;
import lms.Collection;
import lms.Movie;
import lms.Resource;

public class CollectionTest 
{
	Resource resource;
	Resource resource2;
	Collection collection;
	
	/*
	* setUp method instantiates new Objects and assigns
	* parameters to Book and Movie
	*/
	@Before
	public void setUp()
	{
		collection = new Collection();
		resource = new Book(10,"title","isbn","author");
		resource2 = new Movie(7,"title","upc");
		collection.addResource(resource);
		collection.addResource(resource2);
	}
	
	/*
	* testAddedBook method checks if the Book resource
	* was successfully added to the ArrayList.
	*/
	@Test
	public void testAddedBook()
	{
		assertEquals(resource, collection.findResource(10));
	}
	
	/*
	* testAddedBook method checks if the Movie resource
	* was successfully added to the ArrayList.
	*/
	@Test
	public void testAddedMovie()
	{
		assertEquals(resource2, collection.findResource(7));
	}
	
	/*
	* testAddExistingBook checks if the program will add an existing
	* Book to the ArrayList.
	*/
	@Test
	public void testAddExistingBook()
	{
		Resource resource3 = new Book(10,"title2","isbn2","author2");
		assertFalse(collection.addResource(resource3));	
	}
	
	/*
	* testAddExistingBook checks if the program will add an existing
	* Book to the ArrayList.
	*/
	@Test
	public void testAddExistingMovie()
	{
		Resource resource4 = new Movie(7,"title2","upc2");
		assertFalse(collection.addResource(resource4));
	}
}
