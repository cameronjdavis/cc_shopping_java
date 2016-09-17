package cc_shopping_java.discounts;

/**
 * A discount that is only applied if the customer is a loyalty card holder.
 */
public class LoyaltyDiscount {
	/**
	 * True if the customer has a loyalty card, otherwise false.
	 */
	private boolean isLoyal;

	/**
	 * Discount to apply if customer is loyal.
	 */
	private Discount discount;

	public LoyaltyDiscount(boolean isLoyal, Discount discount) {
		this.isLoyal = isLoyal;
		this.discount = discount;
	}

	/**
	 * If customer is loyal then apply a discount. If customer is not loyal then
	 * do not apply discount.
	 */
	public double applyDiscount(double total) {
		// if customer is loyal then apply the discount
		if (this.isLoyal) {
			return this.discount.applyDiscount(total);
		}

		// customer is not loyal so do not apply discount
		return total;
	}
}
