package cc_shopping_java.discounts;

/**
 * A discount that is applied if the total meets a threshold amount.
 */
public class TotalThresholdDiscount implements Discount {
	/**
	 * Minimum threshold for total to be greater-than or equal to.
	 */
	private double threshold;

	/**
	 * Discount to apply if total price meets threshold.
	 */
	private Discount discount;

	/**
	 * @param threshold
	 *            Threshold to be met for discount. E.g. $20.00.
	 * @param discount
	 *            Discount to be applied if threshold is met.
	 */
	public TotalThresholdDiscount(double threshold, Discount discount) {
		this.threshold = threshold;
		this.discount = discount;
	}

	/**
	 * Apply the discount if the total meets the threshold.
	 */
	public double applyDiscount(double total) {
		// if the total meets the minimum threshold
		if (total >= this.threshold) {
			return this.discount.applyDiscount(total);
		}

		// total is not above threshold so do not apply discount
		return total;
	}
}
