package assign5;

/**
 * Class Iterator loops through the elements of a 
 * Roster object 
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public interface Iterator 
{
	/**
	 * If there is a next student in the roster 
	 * @return true
	 * @author Jose G.
	 * @author Ryan J.
	 * @version 1.0
	 */
	public boolean hasNext();
	
	/**
	 * Returns the next student object in the roster list.
	 * @return object.
	 * @author Jose G.
	 * @author Ryan J.
	 * @version 1.0
	 */
	public Object next();
}
