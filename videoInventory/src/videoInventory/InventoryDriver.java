package videoInventory;
import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class InventoryDriver {
	
	private static Scanner scan;
	public static void displayMenu()
	{
		System.out.println("Video Store Inventory Menu");
		System.out.println("1. Add Movie");
		System.out.println("2. Remove Movie");
		System.out.println("3. Find Movie by SKU");
		System.out.println("4. Display inventory");
		System.out.println("5. Quit the Program");
		System.out.println("Enter Your Choice:");
	}
	
	@SuppressWarnings("unchecked")
	private static ArrayList <Movie> readFromFile()
	{
		ArrayList <Movie> list = new ArrayList <Movie> ();
		try
        {
            FileInputStream fis = new FileInputStream("myfile.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Movie>) ois.readObject();
            ois.close();
            fis.close();
         }
		catch(FileNotFoundException FNF)
		{
			 writeToFile(list);
			 return null;
		}
		catch(IOException ioe)
		{
             ioe.printStackTrace(); 
             return null;
         }
		catch(ClassNotFoundException c)
		{
             System.out.println("Class not found");
             c.printStackTrace();
             return null;
        }
		return list;
	}
	
	private static void writeToFile(ArrayList <Movie> list)
	{
		try
		{
	         FileOutputStream fos= new FileOutputStream("myfile.txt");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(list);
	         oos.close();
	         fos.close();
	     }

		catch(IOException ioe)
		{ 
			ioe.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{		
		int choice = 0;
		int SKU, quantity;
		float price;
		String title;
		ArrayList <Movie> list = readFromFile();
		Inventory inv = new Inventory(list);
		scan = new Scanner (System.in);

		while(choice != 5)
		{
			displayMenu();
			choice = scan.nextInt();
			
			if(choice == 1)
			{
				System.out.println("Enter the SKU: ");
				SKU = scan.nextInt();
				System.out.println("Enter the Quantity: ");
				quantity = scan.nextInt();
				System.out.println("Enter the Price: ");
				price = scan.nextFloat();
				System.out.println("Enter the title: ");
				title = scan.nextLine();
				title = scan.nextLine();
				if(inv.addMovie(SKU, quantity, price, title))
				{
					System.out.println("Success: Movie added");
				}
				else
				{
					System.out.println("Error: Movie not added");
				}
			}
			else if(choice == 2)
			{
				System.out.println("Enter the SKU: ");
				SKU = scan.nextInt();
				if(inv.removeMovie(SKU))
				{
					System.out.println("Removed movie with SKU:" + SKU);
				}
				else
				{
					System.out.println("No movie found with this SKU.");
				}
			}
			else if(choice == 3)
			{
				System.out.println("Enter the SKU: ");
				SKU = scan.nextInt();
				if(!inv.displayMovie(SKU))
				{
					System.out.println("No movie found with this SKU.");
				}
			}
			else if(choice == 4)
			{
				Formatter fmt = new Formatter();
				fmt.format("%1s %4s %6s %8s\n", "SKU", "Quantity", "Price", "Title");
				System.out.println(fmt);
				inv.displayInventory();
			}
			else if(choice == 5)
			{
				writeToFile(list);
				System.out.println("Exit Selected");
			}
			else 
			{
				System.out.println("Invalid Option");
			}
		}	
	}
}
