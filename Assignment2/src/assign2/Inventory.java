package assign2;

import java.util.ArrayList;

public class Inventory {
	
	ArrayList <Product> list = null;
	
	Inventory()
	{
		list = new ArrayList<Product>();
	}
	
	public boolean addMovie(int SKU, int quantity, 
			double price, String title, String upc)
	{	
		Movie movie = new Movie(SKU,
			 quantity, price, title, upc);
		list.add(movie);
		return true;
	}
	
	public boolean addToy(int SKU, int quantity, 
			double price, String title, double weight)
	{	
		Toy toy = new Toy(SKU,
			 quantity, price, title, weight);
		list.add(toy);
		return true;
	}
	
	public boolean addBook(int SKU, int quantity, 
			double price, String title, int isbn, String AuthorName)
	{	
		Book book = new Book(isbn, AuthorName,
				SKU, quantity, price, title);
		list.add(book);
		return true;
	}
	
	boolean removeProduct(int SKU)
	{
		if(list.isEmpty())
		{
			return false;
		}
		Product m  = findSku(SKU);
		if(m == null)
		{
			return false;
		}
		list.remove(m);
		return true;
	}
	
	public boolean displayInventory()
	{
		if(list.isEmpty())
		{
			return false;
		}
		for(Product m : list)
		{
			m.displayProductInventory();
		}
		return true;
	}
	
	public boolean displayProduct(int SKU){
		if(list.isEmpty())
		{
			return false;
		}
		Product m = findSku(SKU);
		if (m != null)
		{
			m.displayProduct();
			return true;
		}
		return false;		
	}
	
	public Product findSku(int SKU)
	{
		for(Product m : list)
		{
			if(m.getSKU() == SKU)
			{
				return m;
			}
		}
		return null;
	}
}
