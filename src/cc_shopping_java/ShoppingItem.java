package cc_shopping_java;

/**
 * A single item that a customer puts in their basket. E.g. a banana, or a
 * carton of eggs. Shopping items are identified by their PLU (price look-up
 * code).
 *
 * TODO: Add setters depending on requirements outside the scope of this
 * project.
 */
public class ShoppingItem {
	/**
	 * Unique retailer ID of the item. PLU = price look-up code.
	 */
	private String plu;

	/**
	 * Display name of the item.
	 */
	private String name;

	/**
	 * Unit price of the item.
	 */
	private double price;

	/**
	 * @param plu
	 *            Unique retailer ID of the item.
	 * @param name
	 *            Display name of the item.
	 * @param price
	 *            Unit price of the item.
	 */
	public ShoppingItem(String plu, String name, double price) {
		this.plu = plu;
		this.name = name;
		this.price = price;
	}

	/**
	 * Get the item's PLU.
	 */
	public String getPlu() {
		return this.plu;
	}

	/**
	 * Get the item's display name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the item's unit price.
	 */
	public double getPrice() {
		return this.price;
	}
}
