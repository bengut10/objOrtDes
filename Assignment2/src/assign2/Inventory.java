package assign2;
import java.util.HashMap;

public class Inventory {
	
	HashMap <Integer, Object> mapper = null;
	
	Inventory()
	{
		mapper = new HashMap <Integer, Object>();
	}
	
	/*public boolean addMovie(int SKU, int quantity, 
			double price, String title, String upc)
	{	
		Movie movie = new Movie(SKU,
			 quantity, price, title, upc);
		mapper.put(SKU, movie);
		return true;
	}
	
	public boolean addToy(int SKU, int quantity, 
			double price, String title, int weight)
	{	
		Toy toy = new Toy(SKU,
			 quantity, price, title, weight);
		mapper.put(SKU, toy);
		return true;
	}
	*/	
	
	public boolean addBook(int SKU, int quantity, 
			double price, String title, int isbn, String AuthorName)
	{	
		Book book = new Book(isbn, AuthorName,
				SKU, quantity, price, title);
		mapper.put(SKU, book);
		return true;
	}
	
	boolean removeProduct(int SKU)
	{
		if(mapper.isEmpty())
		{
			return false;
		}
		if(mapper.containsKey(SKU))
		{
			mapper.remove(SKU);
			return true;
		}
		return false;
	}
	
	public boolean displayInventory()
	{
		if(mapper.isEmpty())
		{
			return false;
		}
		mapper.forEach((k,v)->
		{
			Object v1 = new Object();
		    v1 = mapper.get(k);
		    Product item2 = (Product) v1;
		    item2.displayProductInventory();
		});	
		return true;
	}
	
	public boolean findSku(int SKU)
	{
		if(mapper.isEmpty())
		{
			return false;
		}
		if(mapper.containsKey(SKU))
		{
			Object v1 = new Object();
		    v1 = mapper.get(SKU);
		    DisplayProduct dp = (DisplayProduct) v1;
		    dp.displayProduct();    
		    return true;
		}
		return false;
	}
}
