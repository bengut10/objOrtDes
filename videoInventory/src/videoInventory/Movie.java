package videoInventory;
import java.io.*;
import java.text.*;


 public class Movie implements Serializable
 {
	private static final long serialVersionUID = 1L;
	
	private int SKU;
	private double price;
	private String title;
	private int quantity;

	Movie() {}
	
	Movie(int SKU, int quantity, double price, String title)
	{
		this.SKU = SKU;
		this.price = price;
		this.quantity = quantity;
		this.title = title;
	}
	
	public int getSKU()
	{
		return SKU;
	}
	
	public void display()
	{
		String pattern = "###.##";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(this.price);
		System.out.println ("SKU: " + this.SKU);
		System.out.println ("Title: " + this.quantity);
		System.out.println ("Price: " + output);
		System.out.println ("Quantity: " + this.title);
	}
	
	public void displayInventory()
	{
		String pattern = "###.##";
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(this.price);
		System.out.println (this.SKU + " " + this.quantity + " $" + output + " " + this.title);
	}
}