package assignment1;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/** Class InventoryDriver deals with I/O operations 
 * and displays a menu.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public class InventoryDriver {
	
	private static Scanner scan;
	
	/** Displays a menu with operations on the inventory 
	 * as menu items. 
	 */
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
	
	/** Deserializes an  ArrayList of movie objects.
	 * @return List of movie items.
	 */
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
			 return list;
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
	
	/** Serializes an ArraList of Movie objects
	 * @param List of movie objects. 
	 */
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

	/** Program Driver 
	 */
	public static void main(String[] args) 
	{		
		int choice = 0;
		int SKU, quantity = 0;
		float price = 0;
		String title;
		ArrayList <Movie> list = readFromFile();
		Inventory inv = new Inventory(list);
		scan = new Scanner (System.in);

		while(choice != 5)
		{
			displayMenu();
			if(scan.hasNextInt())
			{
				choice = scan.nextInt();
			}
			else
			{
				System.out.println("Invalid Input");
				break;
			}
			if(choice == 1)
			{
				System.out.println("Enter the SKU: ");
				if(!scan.hasNextInt())
				{
					System.out.println("Invalid Input");
					break;
				}
				else
				{
					SKU = scan.nextInt();
				}
				System.out.println("Enter the Quantity: ");
				if(!scan.hasNextInt())
				{
					System.out.println("Invalid Input");
					break;
				}
				else
				{
					quantity = scan.nextInt();
				}
				System.out.println("Enter the Price: ");
				if(!scan.hasNextFloat())
				{
					System.out.println("Invalid Input");
					break;
				}
				else
				{
					price = scan.nextFloat();
				}
				
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
				if(!inv.displayInventory())
				{
					System.out.println("Inventory is empty");
				}
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
