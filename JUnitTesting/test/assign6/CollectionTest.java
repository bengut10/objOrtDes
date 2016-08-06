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
	
	@Before
	public void setUp()
	{
		collection = new Collection();
		resource = new Book(10,"title","isbn","author");
		resource2 = new Movie(7,"title","upc");
		assertNull(collection.findResource(7));
		assertNull(collection.findResource(10));
		collection.addResource(resource);
		collection.addResource(resource2);
	}
	
	@Test
	public void testAddedResources()
	{
		assertEquals(resource, collection.findResource(10));
		assertEquals(resource2, collection.findResource(7));
	}
	
	@Test
	public void testAddExistingResources()
	{
		testAddedResources();
		Resource resource3 = new Book(10,"title2","isbn2","author2");
		Resource resource4 = new Movie(7,"title2","upc2");
		assertFalse(collection.addResource(resource3));	
		assertFalse(collection.addResource(resource4));
	}
}
