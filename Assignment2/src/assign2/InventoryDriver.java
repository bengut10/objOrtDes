package assign2;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class InventoryDriver {

    private static Scanner scan;

    public static void displayMenu()
    {
        System.out.println("Video Store Inventory Menu");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Find Product by SKU");
        System.out.println("4. Display inventory");
        System.out.println("5. Process a sale");
        System.out.println("6. Quit the program");
        System.out.println("Enter Your Choice:");
    }
    
    /** Deserializes an  ArrayList of Product objects.
     * @return List of product items.
     */
    @SuppressWarnings("unchecked")
    private static ArrayList <Product> readFromFile()
    {
        ArrayList <Product> list = new ArrayList <Product> ();
        try
        {
            FileInputStream fis = new FileInputStream("myfile.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Product>) ois.readObject();
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
    
 
    /** Serializes an ArrayList of Product objects
    * @param List of product objects. 
    */
    private static void writeToFile(ArrayList <Product> list)
    {
        try
        {
            FileOutputStream fos= new FileOutputStream("myfile.dat");
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
        int SKU, quantity, sellQuantity, isbn;
        char type;
        String title, upc, authorName;
        double costToShip, price, weight;
        ArrayList <Product> list = readFromFile();
        Inventory inv = new Inventory(list);
        scan = new Scanner(System.in);

        do
        {
        	displayMenu();
        	choice = scan.nextInt();
    
        	switch(choice)
        	{
        		case 1:
        			System.out.println("Enter the product type\n");
        			System.out.println(
        					"Enter M for movie, B for Book, or T for Toy:");
        			type = scan.next().charAt(0);
        			if(type == 'M')
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
        				System.out.println("Enter the UPC");
        				upc = scan.nextLine();
        				inv.addMovie(SKU, quantity, price, title, upc);
        			}
        			if(type == 'B')
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
        				System.out.println("Enter the Isbn");
        				isbn = scan.nextInt();
        				System.out.println("Enter the Author Name");
        				authorName = scan.nextLine();
        				authorName = scan.nextLine();
        				inv.addBook(SKU, quantity, price, 
        						title, isbn, authorName);
        			}
        			if(type == 'T')
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
        				System.out.println("Enter the weight");
        				weight = scan.nextDouble();
        				inv.addToy(SKU, quantity, price, title, weight);   
        			}
        			break;
        		case 2:
        			System.out.println("Enter the SKU: ");
    				SKU = scan.nextInt();
    				if(inv.removeProduct(SKU))
    				{
    					System.out.println("Removed product with SKU:" + SKU);
    				}
    				else
    				{
    					System.out.println("No product found with this SKU.");
    				}
    				break;
        		case 3:
        			System.out.println("Enter the SKU: ");
    				SKU = scan.nextInt();
    				if(!inv.displayProduct(SKU))
    				{
    					System.out.println("No product found with this SKU.");
    				}
    				break;
        		case 4:
        			if(!inv.displayInventory())
    				{
    					System.out.println("Inventory is empty");
    				}
        			break;
        		case 5:
        			System.out.println("Enter SKU of sold items: ");
                    SKU = scan.nextInt();
                    System.out.println("Enter quantity of sold items: ");
                    sellQuantity = scan.nextInt();
                    System.out.println("Enter cost to ship sold items: ");
                    costToShip = scan.nextDouble();
                    
                    Product calc = inv.findSku(SKU);
                    if(calc != null)
                    {
                    	if(calc.haveEnough(sellQuantity))
                    	{
                    		double totalPrice = calc.totalPrice(sellQuantity);
	                    	calc.processSale(totalPrice,
	                    			calc.getShipCredit(sellQuantity),
	                    			calc.getCommission(totalPrice), 
	                    			costToShip, sellQuantity);
                    	}
                    	else
                    	{
                    		System.out.println("Not enough quantity in stock");
                    	}
                    }
                    else
                    {
                    	System.out.println("The inventory does not have"
                    			+ " an item with SKU: " + SKU);
                    }
        			break;
        		case 6: 
        			writeToFile(list);
        			System.out.println("Exit Selected");
        			break;
        		default:
        			System.out.println("Invalid Selection");
        	}  		
        	
        }
        while(choice != 6);
	}
}
