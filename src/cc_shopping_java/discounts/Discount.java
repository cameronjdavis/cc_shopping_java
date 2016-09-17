package cc_shopping_java.discounts;

/**
 * A Discount can calculate and apply a discount to a total price.
 */
public interface Discount {
	/**
	 * Apply a discount to a total price.
	 */
	public float applyDiscount(float total);
}
