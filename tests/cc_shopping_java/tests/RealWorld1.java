package cc_shopping_java.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import cc_shopping_java.DiscountedPriceCalculator;
import cc_shopping_java.PriceCalculator;
import cc_shopping_java.Rounding;
import cc_shopping_java.ShoppingItem;
import cc_shopping_java.TruncationRounding;
import cc_shopping_java.UndiscountedPriceCalculator;
import cc_shopping_java.discounts.Discount;
import cc_shopping_java.discounts.DiscountCollection;
import cc_shopping_java.discounts.LoyaltyDiscount;
import cc_shopping_java.discounts.PercentageDiscount;
import cc_shopping_java.discounts.TotalThresholdDiscount;
import cc_shopping_java.discounts.TwoForOneDiscount;

/**
 * This is not a unit test, rather it demonstrates the classes as they could be
 * used in production.
 */
public class RealWorld1 {

	/**
	 * An empty basket and using DiscountCollection and
	 * DiscountedPriceCalculator.
	 */
	@Test
	public void test_usingDiscountList() {
		// simulated input for loyalty card
		boolean isLoyal = true;

		// create a new basket
		Collection<ShoppingItem> basket = new ArrayList<ShoppingItem>();

		// create an item for discounting
		ShoppingItem item3 = new ShoppingItem("PLU 3", "Name 3", 3.12);

		// create a list of discounts and use them to make a discount collection
		Set<Discount> discounts = new HashSet<Discount>();
		Discount discount = new DiscountCollection(discounts);

		// add a two-for-one discount which is first in line
		Set<ShoppingItem> twoForOneItems = new HashSet<ShoppingItem>();
		twoForOneItems.add(item3);
		discounts.add(new TwoForOneDiscount(twoForOneItems, basket));

		// add a total threshold discount for 10% after £20 total
		PercentageDiscount percentageDiscount1 = new PercentageDiscount(0.1);
		discounts.add(new TotalThresholdDiscount(20.0, percentageDiscount1));

		// add a loyalty card discount of 2%
		PercentageDiscount percentageDiscount2 = new PercentageDiscount(0.02);
		discounts.add(new LoyaltyDiscount(isLoyal, percentageDiscount2));

		// calculate the total with discounting
		UndiscountedPriceCalculator undiscountedCalculator = new UndiscountedPriceCalculator();
		PriceCalculator discountedCalculator = new DiscountedPriceCalculator(undiscountedCalculator, discount);

		// calculate the total and apply discounts
		double discountedTotal = discountedCalculator.calculatePrice(basket);

		// round (read truncate) the final discounted price
		Rounding rounding = new TruncationRounding();
		double roundedTotal = rounding.roundPrice(discountedTotal);

		assertEquals(0.0, roundedTotal, 0);
	}

}
