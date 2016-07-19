package assign2;

public class Book extends Product
{
	private static final long serialVersionUID = 1L;
	private int isbn;
	private String AuthorName;
	private final double commission = .15;
	private final double shipping = 3.99;
	
	Book(){}
	
	Book(int isbn, String AuthorName,
			int SKU, int quantity, double price, String title)
	{
		super (SKU, quantity, price, title);
		this.isbn = isbn;
		this.AuthorName = AuthorName;	
	}
	
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
	