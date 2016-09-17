package cc_shopping_java;

import java.util.Collection;

/**
 * Calculate the total price for a basket of shopping items without discounting.
 */
public class UndiscountedPriceCalculator implements PriceCalculator {

	/**
	 * Calculate the total price for items in a basket without any discounting.
	 */
	@Override
	public double calculatePrice(Collection<ShoppingItem> basket) {
		double total = 0.0;

		for (ShoppingItem item : basket) {
			total += item.getPrice();
		}

		return total;
	}

}
