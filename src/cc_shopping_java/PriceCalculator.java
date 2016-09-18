package cc_shopping_java;

/**
 * A PriceCalculator can calculate a price for a basket of shopping items.
 */
public interface PriceCalculator {
	/**
	 * Calculate the price for a basket of items.
	 * 
	 * @param basket
	 *            Items to calculate a price for.
	 * @return Price for the basket of items.
	 */
	public double calculatePrice(Basket basket);
}
