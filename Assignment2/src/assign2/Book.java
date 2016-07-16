package assign2;

public class Book extends Product implements DisplayProduct
{
	private static final long serialVersionUID = 1L;
	private int isbn;
	private String AuthorName;
	
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
		// TODO Auto-generated method stub
		System.out.println(toString() + "ISBN: " + this.isbn + "\n" +
				"Author Name: " + this.AuthorName);
	}
}
	