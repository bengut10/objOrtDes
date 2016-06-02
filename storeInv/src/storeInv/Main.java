
package storeInv;
import java.io.*;
import java.util.Scanner;

public class Main {
	
	private static Scanner scan;

	public static void displayMenu(){
		System.out.println("Video Store Inventory Menu");
		System.out.println("1. Add Movie");
		System.out.println("2. Remove Movie");
		System.out.println("3. Find Movie by SKU");
		System.out.println("4. Display inventory");
		System.out.println("5. Quit the Program");
		System.out.println("Enter Your Choice:");
	}
	
	public static void main(String[] args) {
		int choice = 0;
		int SKU, quantity;
		float price;
		String title;
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
				title = scan.next();
				
				InvMgmt movieObj = new InvMgmt();
				
				if (movieObj.addMovie(SKU, quantity, price, title))
				{	
					try
					{
						FileOutputStream fos = new FileOutputStream("storeInvFile.txt");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(movieObj);
						fos.close();
					}
					catch (IOException ex) 
					{
						System.out.println(ex.getMessage());
						System.out.println("Problem with the file output");
						break;
			        }
					
					System.out.println("Success: Movie added");
				}
			}
			else if(choice == 2)
			{
				
			}
			else if(choice == 3)
			{
				
				
			}
			else if(choice == 4)
			{
				
			}
			else if(choice == 5)
			{
				System.out.println("Exit Selected");
			}
			else 
			{
				System.out.println("Invalid Option");
			}
		}
		
	}

}
