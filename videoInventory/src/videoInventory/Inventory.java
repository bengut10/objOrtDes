package videoInventory;
import java.util.ArrayList;
import java.io.*;

public class Inventory{
	
	ArrayList <Movie> list = new ArrayList <Movie> ();

	Inventory() 
	{
		readFromFile();
	}
	
	@SuppressWarnings("unchecked")
	void readFromFile()
	{
		try
        {
            FileInputStream fis = new FileInputStream("myfile.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Movie>) ois.readObject();
            ois.close();
            fis.close();
         }
		catch(IOException ioe)
		{
             ioe.printStackTrace();
             return;    
         }
		catch(ClassNotFoundException c)
		{
             System.out.println("Class not found");
             c.printStackTrace();
             return;
        }
	}
	
	void writeToFile()
	{
		try
		{
	         FileOutputStream fos= new FileOutputStream("myfile.txt");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(list);
	         oos.close();
	         fos.close();
	      }

		catch(IOException ioe)
		{ 
			ioe.printStackTrace();
		}
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
				m2.display();
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
