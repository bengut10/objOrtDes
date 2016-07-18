package assignment1;
import java.io.*;
import java.util.Formatter;
import java.text.*;

/** Class Movie holds the attributes and operations of a movie.
* @author Jose G.
* @author Ryan F.
* @version 1.0
*/
 public class Movie implements Serializable
 {
	private static final long serialVersionUID = 1L;
	private int SKU;
	private double price;
	private String title;
	private int quantity;
	
	/**
	 *  Initializes a movie with no assigned values.
	 */
	Movie() {}
	
	/**
	 *  Initializes a movie with assigned values.
	 *  @param  SKU unique id for each movie.
	 *  @param  quantity number of movie copies.
	 *  @param  price cost of the movie .
	 *  @param  title of the movie.
	 */
	Movie(int SKU, int quantity, double price, String title)
	{
		this.SKU = SKU;
		this.price = price;
		this.quantity = quantity;
		this.title = title;
	}

	/**
	 *  Returns the SKU of a particular movie. 
	 *  @param SKU the unique identifier of a movie.
	 */
	public int getSKU()
	{
		return SKU;
	}
	
	/**
	 *  Displays a movie's attributes 
	 */
	public void displayMovie()
	{
		String pattern = "###.##";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(this.price);
		System.out.println ("SKU: " + this.SKU);
		System.out.println ("Title: " + this.quantity);
		System.out.println ("Price: " + output);
		System.out.println ("Quantity: " + this.title);
	}
	
	/**
	 *  Aux function to display an entire inventory.
	 */
	public void displayInventory()
	{
		String pattern = "###.##";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(this.price);
		Formatter fmt = new Formatter();
		fmt.format("%2s %6s %9s %1s\n",
				this.SKU, this.quantity, "$" + output, this.title );

		System.out.println (fmt);
	}
}
