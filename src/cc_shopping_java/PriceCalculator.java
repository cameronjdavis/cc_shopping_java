package cc_shopping_java;

import java.util.Collection;

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
	public double calculatePrice(Collection<ShoppingItem> basket);
}
