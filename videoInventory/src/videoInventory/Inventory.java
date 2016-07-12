package videoInventory;
import java.util.ArrayList;

public class Inventory{
	
	private ArrayList <Movie> list = null;
	
	Inventory(ArrayList <Movie> list) 
	{
		this.list = list;
	}
	
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
	
	boolean removeMovie(int SKU)
	{
		assert(list.size() > 0);
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
	
	boolean displayMovie(int SKU)
	{
		assert(list.size() > 0);
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
	
	void displayInventory()
	{
		assert(list.size() > 0);
		Movie m2 = new Movie();
		for (int i = 0; i < list.size(); i++) 
		{
			 m2 = list.get(i);
			 m2.displayInventory();
		}
	}
	
	boolean SKUExists(int SKU)
	{
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
