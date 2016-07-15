package assignment1;
import java.util.ArrayList;

/** Class Inventory performs operations on movie objects.
 * 
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public class Inventory{
	
	private ArrayList <Movie> list = null;
	
	/**
	 *  Initializes an ArrayList as a class container 
	 *  @param  ArrayList of movie objects.
	 */
	Inventory(ArrayList <Movie> list) 
	{
		this.list = list;
	}
	/**
	 *  Adds a movie object to the inventory.
	 *  @param  SKU unique id for each movie.
	 *  @param  quantity number of movie copies.
	 *  @param  price cost of the movie .
	 *  @param  title of the movie.
	 *  @return true if the movie was added successfully.
	 *  False other wise.
	 */
	boolean addMovie(int SKU, int quantity, double price, String title)
	{
		if(SKUExists(SKU))
		{
			return false;
		}
		Movie movie = new Movie(SKU,quantity,price,title);
		list.add(movie);
		return true;
	}
	/**
	 *  Removes a movie object from the inventory.
	 *  @param  SKU unique id the movie to be removed.
	 *  @return True if the movie was deleted successfully.
	 *  False other wise
	 */
	boolean removeMovie(int SKU)
	{
		if(list.isEmpty())
		{
			return false;
		}
		Movie m2 = new Movie();
		for (int i = 0; i < list.size(); i++) 
		{
			m2 = list.get(i);
			if(m2.getSKU() == SKU)
			{
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	 *  Displays a movie given a SKU.
	 *  @param  SKU unique id the movie to be displayed.
	 *  @return True if the movie was displayed successfully.
	 *  False other wise
	 */
	boolean displayMovie(int SKU)
	{
		if(list.isEmpty())
		{
			return false;
		}
		Movie m2 = new Movie();
		for (int i = 0; i < list.size(); i++) 
		{
			m2 = list.get(i);
			if(m2.getSKU() == SKU)
			{
				m2.displayMovie();
				return true;
			}
		}
		return false;
	}
	
	/**
	 *  Displays the entire inventory.
	 */
	boolean displayInventory()
	{
		if(list.isEmpty())
		{
			return false;
		}
		Movie m2 = new Movie();
		for (int i = 0; i < list.size(); i++) 
		{
			 m2 = list.get(i);
			 m2.displayInventory();
		}
		return true;
	}
	/**
	 *  Determines whether a movie exists in the inventory.
	 *  @param  SKU unique id the movie to be found.
	 *  @return True if the movie exists in the inventory.
	 *  False other wise
	 */
	boolean SKUExists(int SKU)
	{
		if(list.isEmpty())
		{
			return false;
		}
		for (Movie m1 : list) 
		{
		  if (m1.getSKU() == SKU)
		  {
			  return true; 
		  }
		}	
		return false; // movie not found
	}
}
