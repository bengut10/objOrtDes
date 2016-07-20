package assign2;

/** Class Toy holds the attributes and operations of a Toy.
* @author Jose G.
* @author Ryan J.
* @version 1.0
*/
public class Toy extends Product{

	private static final long serialVersionUID = 1L;
	private double weight;
	private final double shipCre = 4.49;
	private final double commission = .15;
	private final double varCost = .50;
   
    /**
     * Initializes a Toy with assigned values.
     * @param SKU unique id for each product.
     * @param quantity number of products.
     * @param price cost of the product.
     * @param title name of the product.
     * @param weight weight of the product.
     */
	Toy(int SKU, int quantity, double price, String title, double weight)
	{
		super (SKU, quantity, price, title);
		this.weight = weight;	
   	}
 
	@Override
	public double getCommission(double totalPrice)
	{
		return totalPrice * this.commission;
   	}
   
   	@Override
   	public void displayProduct()
   	{
   		System.out.println(toString() + "Weight: " + this.weight);
   	}

	@Override
	public double getShipCredit(int quantity) 
	{
		
		int pounds = (int) Math.ceil(this.weight/16);
		return shipCre * (quantity) + 
				((quantity) * (pounds * varCost));
	}
	@Override
	public String getTypeName() {
		return "Toy";
	}
   
   
}