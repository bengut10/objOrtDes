package assign2;
import java.util.ArrayList;
import java.util.Collections;


/** class Inventory contains the ArrayList of Products.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public class Inventory{
	
	private ArrayList <Product> list = null;
	
	/**
     * Initializes an Inventory with an ArrayList of Products
     * @param list 
     */
	Inventory(ArrayList <Product> list)
	{
		this.list = list;
	}
	
	 /**
     * Checks if movie was successfully added to the inventory. 
     * @param SKU
     * @param quantity
     * @param price
     * @param title
     * @param upc
     * @return True if Movie was successfully added to the inventory.
     */
	public boolean addMovie(int SKU, int quantity, 
			double price, String title, String upc)
	{	
		
		if(findSku(SKU) != null)
		{
			System.out.println("Product with that SKU already exists");
		}
		Movie movie = new Movie(SKU,
			 quantity, price, title, upc);
		list.add(movie);
		return true;
	}
	
	/**
     * Checks if Toy was successfully added to the inventory.
     * @param SKU
     * @param quantity
     * @param price
     * @param title
     * @param weight
     * @return True if Toy was successfully added to ArrayList.
     */
	public boolean addToy(int SKU, int quantity, 
			double price, String title, double weight)
	{	
		if(findSku(SKU) != null)
		{
			System.out.println("Product with that SKU already exists");
		}
		Toy toy = new Toy(SKU,
			 quantity, price, title, weight);
		list.add(toy);
		return true;
	}
	
	/**
     * True if Book was successfully added to ArrayList.
     * @param SKU
     * @param quantity
     * @param price
     * @param title
     * @param isbn
     * @param AuthorName
     * @return True if Book was successfully added to ArrayList.
     */
	public boolean addBook(int SKU, int quantity, 
			double price, String title, int isbn, String AuthorName)
	{	
		if(findSku(SKU) != null)
		{
			System.out.println("Product with that SKU already exists");
		}
		Book book = new Book(isbn, AuthorName,
				SKU, quantity, price, title);
		list.add(book);
		return true;
	}
	
	  /**
     * Removes a product id is available to remove from inventory.
     * @param SKU
     * @return True if Product is successfully removed.
     */
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
	
	/**
     * Checks if inventory is empty and displays if 
     * inventory is not empty.
     * @return True if inventory is not empty
     *  and displayed successfully.
     */
	public boolean displayInventory()
	{
		if(list.isEmpty())
		{
			return false;
		}
		Collections.sort(list);
		for(Product m : list)
		{
			m.displayProductInventory();	
		}
		return true;
	}
	
	/**
     * Checks if Inventory is empty and if SKU exists
     *  and displays product.
     * attributes
     * @param SKU
     * @return True if Product exists
     */
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
	
	 /**
     * Finds the SKU of a Product.
     * @param SKU unique id for each movie.
     * @return 
     */
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
