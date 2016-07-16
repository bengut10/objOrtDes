package assign2;
import java.io.*;
import java.util.Formatter;
import java.text.*;

/** Class Product holds the attributes and operations of a product.
* @author Jose G.
* @author Ryan J.
* @version 1.0
*/
public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int SKU;
	private double price;
	private String title;
	private int quantity;
	
	/**
	 *  Initializes a product with no assigned values.
	 */
	Product() {}
	
	/**
	 *  Initializes a product with assigned values.
	 *  @param  SKU unique id for each product.
	 *  @param  quantity number of products.
	 *  @param  price cost of the product .
	 *  @param  name of the product.
	 */
	Product(int SKU, int quantity, double price, String title)
	{
		this.SKU = SKU;
		this.price = price;
		this.quantity = quantity;
		this.title = title;
	}
	
	/**
	 *  Returns the SKU of a particular product. 
	 *  @param SKU the unique identifier of a product.
	 */
	public int getSKU()
	{
		return SKU;
	}
	
	/**
	 *  Displays a product's attributes 
	 */
	public String toString()
	{
		String pattern = "###.##";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(this.price);
		return "SKU: " + this.SKU + "\n" + "Title: " + this.quantity + "\n" 
				 + "Price: " + output + "\n" + "Quantity: " + this.title + "\n";
	}
	
	/**
	 *  Aux function to display an entire inventory.
	 */
	public void displayProductInventory()
	{
		String pattern = "###.##";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(this.price);
		Formatter fmt = new Formatter();
		fmt.format("%2s %6s %9s %1s\n",
				this.SKU, this.quantity, "$" + output, this.title );
		System.out.println (fmt);
	}
	
	public void displayHeader()
	{
		Formatter header = new Formatter();
		header.format("%1s %4s %6s %8s\n", "SKU", "Quantity", "Price", "Title");
		System.out.println(header);
	}
}
	

