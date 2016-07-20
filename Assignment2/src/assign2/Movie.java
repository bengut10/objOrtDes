package assign2;
import java.io.*;

/** Class Movie holds the attributes and operations of a movie.
* @author Jose G.
* @author Ryan J.
* @version 1.0
*/
 public class Movie extends Product implements Serializable
 {
	private static final long serialVersionUID = 1L;
	private String UPC;
	private double shipping = 2.98;
	private double commission = .12;
	
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
         *  @param upc of the movie.
	 */
    Movie(int SKU, int quantity, double price, String title, String UPC)
	{
		super (SKU, quantity, price, title);
		this.UPC = UPC;
	}

    @Override
    public void displayProduct()
    {
    	System.out.println(toString() + "ISBN: " + "\n" +
				"UPC: " + this.UPC);
    }
    
    @Override
    public double getCommission(double totalPrice)
    {
            return  totalPrice * this.commission;
            
    }

	@Override
	public double getShipCredit(int quantity) 
	{
		return this.shipping * quantity;
	}

	@Override
	public String getTypeName() {
		return "Movie";
	}
	
}