package cc_shopping_java;

/**
 * Calculate the total price for a basket of shopping items without discounting.
 */
public class UndiscountedPriceCalculator implements PriceCalculator {

	/**
	 * Calculate the total price for items in a basket without any discounting.
	 */
	@Override
	public double calculatePrice(Basket basket) {
		double total = 0.0;

		for (ShoppingItem item : basket) {
			total += item.getPrice();
		}

		return total;
	}

}
