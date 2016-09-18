package cc_shopping_java;

import cc_shopping_java.discounts.Discount;

/**
 * Calculate the total price for a basket of shopping items with discounting.
 */
public class DiscountedPriceCalculator implements PriceCalculator {

	private UndiscountedPriceCalculator totalCalculator;

	private Discount discount;

	/**
	 * @param totalCalculator
	 *            Calculator to calculate the undiscounted total.
	 * @param discount
	 *            Discount to be applied to the undiscounted total.
	 */
	public DiscountedPriceCalculator(UndiscountedPriceCalculator totalCalculator, Discount discount) {
		this.totalCalculator = totalCalculator;
		this.discount = discount;
	}

	/**
	 * Calculate the total price with discounting.
	 */
	@Override
	public double calculatePrice(Basket basket) {
		double total = this.totalCalculator.calculatePrice(basket);

		return this.discount.applyDiscount(total);
	}

}
