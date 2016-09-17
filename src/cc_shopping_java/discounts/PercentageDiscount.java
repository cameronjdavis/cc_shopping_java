package cc_shopping_java.discounts;

/**
 * A percentage discount. E.g. Discount total by 15%.
 */
public class PercentageDiscount implements Discount {

	/**
	 * Percentage amount, e.g. 0.15 = 15%.
	 */
	private double percentage;

	/**
	 * @param percentage
	 *            E.g. 0.15 = 15% discount.
	 */
	public PercentageDiscount(double percentage) {
		this.percentage = percentage;
	}

	/**
	 * Apply a percentage discount to a total.
	 */
	@Override
	public double applyDiscount(double total) {
		double discountedTotal = total * (1.0 - this.percentage);

		return discountedTotal >= 0 ? discountedTotal : 0;
	}

}
