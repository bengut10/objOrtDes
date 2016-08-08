package assign5;

import java.util.ArrayList;

/**
<<<<<<< HEAD
 * Class StudentRepository is provides a way to return an iterator
 * for a give roster object.
=======
 * StudentRepository contains the Student objects and contains the Iterator
 * to get the averages.
>>>>>>> branch 'master' of https://github.com/bengut10/objOrtDes.git
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public class StudentRepository implements Container
{
	private ArrayList<Student> list = null;    // an ArrayList of Student Objects
	private Roster roster;			   // a Roster instance.
	
	/**
<<<<<<< HEAD
	 * Constructor of a Student repository
	 * @param Object
	 * @author Jose G.
	 * @author Ryan J.
	 * @version 1.0
=======
	 * Constructor for StudentRepository Object/
	 * @param object 
>>>>>>> branch 'master' of https://github.com/bengut10/objOrtDes.git
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
<<<<<<< HEAD
	 * Class student iterator moves through a list of
	 * students in a roster list.
	 * @author Jose G.
	 * @author Ryan J.
	 * @version 1.0
	 */
=======
	 * StudentIterator contains the Iterator methods and 
	 * can iterate over the ArrayList of Students.
	 */ 
>>>>>>> branch 'master' of https://github.com/bengut10/objOrtDes.git
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
