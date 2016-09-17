package cc_shopping_java.discounts;

import java.util.Collection;

/**
 * An collection of discounts that are applied to a total price. This class
 * implements Discount so it can be used wherever a single Discount is used.
 * Interfaces for the win!
 */
public class DiscountCollection implements Discount {

	private Collection<Discount> discounts;

	public DiscountCollection(Collection<Discount> discounts) {
		this.discounts = discounts;
	}

	@Override
	public double applyDiscount(double total) {
		// apply each discount in order
		for (Discount discount : this.discounts) {
			total = discount.applyDiscount(total);
		}

		return total;
	}

}
