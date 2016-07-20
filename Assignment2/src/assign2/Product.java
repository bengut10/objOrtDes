package assign2;
import java.io.*;
import java.util.Formatter;
import java.text.*;

/** Class Product holds the attributes and operations of a product.
* @author Jose G.
* @author Ryan J.
* @version 1.0
*/
abstract public class Product implements Serializable, Comparable<Product>
{
	private static final long serialVersionUID = 1L;
	private int SKU;
	private double price;
	private String title;
	private int quantity;
	
	/**
	 *  Displays a product's attributes
	 */
	abstract void displayProduct();
	
	/**
	 *  Calculates the commission on a sale.
	 *  @param totalPrice
	 *  @returns commission of sale
	 */
	abstract public double getCommission(double totalPrice);
	
	/**
	 *  Calculates the shipping credit on a sale.
	 *  @param quantity
	 *  @returns shipping credit of a sale.
	 */
	abstract public double getShipCredit(int quantity);
	
	/**
	 *  Returns the type  of product.
	 *  @returns name of product.
	 */
	abstract public String getTypeName();
	
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
	@Override
	public String toString()
	{
		String pattern = "##.00";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(this.price);
		return "SKU: " + this.SKU + "\n" + "Title: " 
				+ this.title + "\n" 
				 + "Price: $" + output + "\n"
				+ "Quantity: " + this.quantity + "\n";
	}
	
	/**
	 *  Aux function to display an entire inventory.
	 */
	public void displayProductInventory()
	{
		String pattern = "##.00";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(this.price);
		Formatter fmt = new Formatter();
		String cname = this.getTypeName();
		
		fmt.format("%2s %4s %6s %9s %1s\n", cname,
				this.SKU, this.quantity, "$" + output, this.title );
		System.out.println (fmt);
	}
	
	/**
     * Displays the formatted header for a product with the 4 common
     * attributes; SKU, Quantity, Price,and Title.
     */
	public void displayHeader()
	{
		Formatter header = new Formatter();
		header.format("%1s %2s %4s %6s %8s\n",
				"Product", "SKU", "Quantity", "Price", "Title");
		System.out.println(header);
	}
	
	 /**
     * 
     * @param quantity number of Products.
     * @return the total price of the product to be sold.
     */
	public double totalPrice(int quantity)
	{	
		return this.price * quantity;		
	}
	
	/**
     * Outputs and the processed sale in a formatted display.
     * @param tPrice total price of product.
     * @param tShipCre total cost of shipping credits.
     * @param tCommission total commission cost.
     * @param shipCost shipping cost.
     * @param redQuan the quantity being removed.
     */
	public void processSale(double tPrice, double tShipCre, 
			double tCommission, double shipCost, int redQuan)
	{
		String pattern = "###.00";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		
		String output = myFormatter.format(tPrice);
		System.out.println("Total Price:   "  + output);
		
		output = myFormatter.format(tShipCre);
		System.out.println("Total Shipping Credit:   "  + output);
		
		output = myFormatter.format(tCommission);
		System.out.println("Total Commision:   "  + output);
		
		double profit = (tPrice + tShipCre) - (tCommission + shipCost);
		output = myFormatter.format(profit);
		System.out.println("Profit:   "  + output);
		this.quantity = this.quantity - redQuan; 
	}
	/**
     * 
     * @param sellQuantity amount of products to sell
     * @return true if there is enough quantity in inventory to sell.
     */
	public boolean haveEnough(int sellQuantity) 
	{
		return sellQuantity <= this.quantity;
	}
	
	@Override
	public int compareTo(Product o) 
	{
		Integer rhsSKU = o.SKU;
		Integer lhsSKU = this.SKU;
		return lhsSKU.compareTo(rhsSKU);
	}
	
}
	

