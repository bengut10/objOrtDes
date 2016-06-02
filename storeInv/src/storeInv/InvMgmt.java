package storeInv;
import java.io.*;

class InvMgmt implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int SKU, quantity;
	float price;
	String title;
	SKUkeeper SKUloc = new SKUkeeper();
	
	InvMgmt(){}//Default Constuctor
	
	public boolean addMovie(int SKU, int quantity, float price, String title)
	{
		//make sure that this SKU does not exist already
		assert SKUloc.SKUexists(SKU) == false;	
	
		//now store value in the hashtable
		if (SKUloc.storeSKU(SKU))
		{
			//set object's attributes
			this.SKU = SKU;
			this.quantity = quantity;
			this.price = price;
			this.title = title;
			return true;	
		}
		return false;
	}
	
	public boolean deleteMovie(int SKU)
	{
		assert SKUloc.SKUexists(SKU);
		if(SKUloc.delete(SKU))
		{
			return true;
		}
		return false;
	}
	
	public String displayMovie(int SKU)
	{
		return (SKU + " " + title + " " + quantity + " " + price);
	}
}
