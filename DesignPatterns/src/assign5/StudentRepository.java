package assign5;

import java.util.ArrayList;

/**
 * StudentRepository contains the Student objects and contains the Iterator
 * to get the averages.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public class StudentRepository implements Container
{
	private ArrayList<Student> list = null;    // an ArrayList of Student Objects
	private Roster roster;			   // a Roster instance.
	
	/**
	 * Constructor for StudentRepository Object/
	 * @param object 
	 */
	StudentRepository(Object object)
	{
		this.roster =(Roster) object;
		this.list = roster.getRoster();
	}
	
	/**
	 * Returns a new Iterator to a calling class.
	 * @return StudentIterator Object.
	 */ 
	@Override
	public Iterator getIterator() 
	{
		return new StudentIterator();
	}
	
	/**
	 * StudentIterator contains the Iterator methods and 
	 * can iterate over the ArrayList of Students.
	 */ 
	private class StudentIterator implements Iterator
	{
		int index;
		
		/**
		 * Checks if list has next element
		 * @return True if index is not at the last element in list.
		 */ 
		@Override
		public boolean hasNext() 
		{
			return (index < list.size());
		}

		/**
		 * @return the Average of a student from ArrayList list.
		 */
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
