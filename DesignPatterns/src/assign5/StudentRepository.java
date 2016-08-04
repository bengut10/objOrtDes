package assign5;

import java.util.ArrayList;

/**
 * Class StudentRepository is provides a way to return an iterator
 * for a give roster object.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public class StudentRepository implements Container
{
	private ArrayList<Student> list = null;
	private Roster roster;
	
	/**
	 * Constructor of a Student repository
	 * @param Object
	 * @author Jose G.
	 * @author Ryan J.
	 * @version 1.0
	 */
	StudentRepository(Object object)
	{
		this.roster =(Roster) object;
		this.list = roster.getRoster();
	}
	
	@Override
	public Iterator getIterator() 
	{
		return new StudentIterator();
	}
	
	/**
	 * Class student iterator moves through a list of
	 * students in a roster list.
	 * @author Jose G.
	 * @author Ryan J.
	 * @version 1.0
	 */
	private class StudentIterator implements Iterator
	{
		int index;
		@Override
		public boolean hasNext() 
		{
			return (index < list.size());
		}

		@Override
		public Object next() 
		{
			if(this.hasNext())
			{
				Student s1 = list.get(index++);
				return s1.getAverage();
			}
	        return null;
		}	
	}
}
