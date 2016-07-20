package assign2;

/** Class Book holds the attributes and operations of a book.
 * @author Jose G.
 * @author Ryan J.
 * @version 1.0
 */
public class Book extends Product
{
	private static final long serialVersionUID = 1L;
	private int isbn;
	private String AuthorName;
	private final double commission = .15;
	private final double shipping = 3.99;
	
	 /**
     * Initializes a Book with no assigned values.
     */
	Book(){}
	
	 /**
     * 
     * @param isbn the unique isbn for each book.
     * @param AuthorName name of the author.
     * @param SKU unique id for each Book.
     * @param quantity number of Book copies.
     * @param price cost of the Book.
     * @param title name of the Book.
     */
	Book(int isbn, String AuthorName,
			int SKU, int quantity, double price, String title)
	{
		super (SKU, quantity, price, title);
		this.isbn = isbn;
		this.AuthorName = AuthorName;	
	}
	
	@Override
	public void displayProduct() 
	{
		System.out.println(toString() + "ISBN: " + this.isbn + "\n" +
				"Author Name: " + this.AuthorName);
	}
	@Override
	 public double getCommission(double totalPrice)
    {
            return  totalPrice * this.commission;
            
    }

	@Override
	public double getShipCredit(int quantity) 
	{
		return this.shipping * quantity;
	}

	@Override
	public String getTypeName() {
		return "Book";
	}
}
	