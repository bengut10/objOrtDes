package assign2;

public class InventoryDriver {

	public static void main(String[] args) {
	
		Inventory inv = new Inventory();
		inv.addBook(10, 45, 34.23, "fefef", 9, "ben GutierreZ");
		inv.displayInventory();
		inv.displayProduct(10);
		inv.removeProduct(10);
		inv.displayInventory();
		inv.displayProduct(10);
	}

}
