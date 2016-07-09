package videoInventory;
import java.util.Scanner;

public class main {
	
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
	public static void main(String[] args) 
	{		
		int choice = 0;
		int SKU, quantity;
		float price;
		String title;
		scan = new Scanner (System.in);
		Inventory inv = new Inventory();
		
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
				title = scan.next();
				
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
					System.out.println("Success: Movie added");
				}
				else
				{
					System.out.println("Error: Movie not deleted");
				}
			}
			else if(choice == 3)
			{
				System.out.println("Enter the SKU: ");
				SKU = scan.nextInt();
				inv.displayMovie(SKU);
			}
			else if(choice == 4)
			{
				inv.displayInventory();
			}
			else if(choice == 5)
			{
				inv.writeToFile();
				System.out.println("Exit Selected");
			}
			else 
			{
				System.out.println("Invalid Option");
			}
		}	
	}
}
