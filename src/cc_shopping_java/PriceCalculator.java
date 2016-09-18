package cc_shopping_java;

/**
 * A PriceCalculator can calculate a price for a collection of shopping items.
 */
public interface PriceCalculator {
	/**
	 * Calculate the price for a collection of items.
	 * 
	 * @param basket
	 *            Items to calculate a price for.
	 * @return Price for collection of items.
	 */
	public double calculatePrice(Basket basket);
}
