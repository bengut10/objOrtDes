package assign5;

import java.util.ArrayList;

public class StudentRepository implements Container
{
	private ArrayList<Student> list = null;
	private Roster roster;
	
	
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
