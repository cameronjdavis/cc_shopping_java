package cc_shopping_java.discounts;

import java.util.Collection;
import java.util.Set;

import cc_shopping_java.ShoppingItem;

/**
 * This discount searches a basket for items that are offered two-for-one. If it
 * finds those items, it will calculate and apply the discounted value.
 */
public class TwoForOneDiscount {

	/**
	 * Set of shopping items that have two-for-one discounts.
	 */
	private Set<ShoppingItem> discountedItems;

	/**
	 * Shopping item collection the discount will be applied to.
	 */
	private Collection<ShoppingItem> basket;

	/**
	 * @param discountedItems
	 *            Set of shopping items that have two-for-one discounts.
	 * @param basket
	 *            Shopping item collection the discount will be applied to.
	 */
	public TwoForOneDiscount(Set<ShoppingItem> discountedItems, Collection<ShoppingItem> basket) {
		this.discountedItems = discountedItems;
		this.basket = basket;
	}

	/**
	 * Look for items in this.basket that have a two-for-one discount, then
	 * calculate and deduct the discount from the total basket price.
	 * 
	 * @param total
	 *            Total before discounting.
	 */
	public double applyDiscount(double total) {
		// for each PLU that has a two-for-one offer
		for (ShoppingItem discountedItem : this.discountedItems) {
			int numItems = 0;

			// count the items in the basket with this PLU
			for (ShoppingItem item : this.basket) {
				if (item.getPlu() == discountedItem.getPlu()) {
					numItems++;
				}
			}

			// if enough items for a discount were found
			if (numItems > 1) {
				// calculate the discount for the items that have this PLU
				double discount = this.calculateDiscount(numItems, discountedItem.getPrice());
				// subtract the discount for this PLU
				total = total - discount;
			}
		}

		return total;
	}

	/**
	 * Calculate the dollar value of a two-for-one discount for an arbitrary
	 * number of items and given their unit price. The two-for-one discount
	 * value is equal to the number of items divided by 2, floored to the next
	 * integer down, and multiplied by the unit price.
	 * 
	 * @param $numItems
	 *            Number of items subject to the discount.
	 * @param $unitPrice
	 *            Unit price of one item.
	 */
	public double calculateDiscount(int numItems, double unitPrice) {
		return Math.floor(numItems / 2) * unitPrice;
	}
}
