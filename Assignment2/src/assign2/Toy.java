package assign2;

/**
*
* @author Ryan Jalufka
*/

public class Toy extends Product{

	private static final long serialVersionUID = 1L;
	private double weight;
	private final double shipCre = 4.49;
	private final double commission = .15;
	private final double varCost = .50;
   
	Toy(int SKU, int quantity, double price, String title, double weight)
	{
		super (SKU, quantity, price, title);
		this.weight = weight;	
   	}
 
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