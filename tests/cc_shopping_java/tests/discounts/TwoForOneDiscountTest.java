package cc_shopping_java.tests.discounts;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import cc_shopping_java.ShoppingItem;
import cc_shopping_java.discounts.TwoForOneDiscount;

public class TwoForOneDiscountTest {

	private TwoForOneDiscount subject;

	private Set<ShoppingItem> discountedItems;

	private Collection<ShoppingItem> basket;

	@Before
	public void setUp() throws Exception {
		this.discountedItems = new HashSet<ShoppingItem>();
		this.basket = new ArrayList<ShoppingItem>();

		this.subject = new TwoForOneDiscount(this.discountedItems, this.basket);
	}

	@Test
	public void test_calculateDiscount_noItemsNoDiscount() {
		int numItems = 0;
		double unitPrice = 1.43;
		double expected = 0;

		double actual = this.subject.calculateDiscount(numItems, unitPrice);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_calculateDiscount_oneItemNoDiscount() {
		int numItems = 1;
		double unitPrice = 1.43;
		double expected = 0;

		double actual = this.subject.calculateDiscount(numItems, unitPrice);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_calculateDiscount_twoItemsOneDiscount() {
		int numItems = 2;
		double unitPrice = 1.43;
		double expected = 1.43;

		double actual = this.subject.calculateDiscount(numItems, unitPrice);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_calculateDiscount_threeItemsOneDiscount() {
		int numItems = 3;
		double unitPrice = 1.43;
		double expected = 1.43;

		double actual = this.subject.calculateDiscount(numItems, unitPrice);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_calculateDiscount_fourItemsTwoDiscounts() {
		int numItems = 4;
		double unitPrice = 1.43;
		double expected = 2 * 1.43;

		double actual = this.subject.calculateDiscount(numItems, unitPrice);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_calculateDiscount_fiveItemsTwoDiscounts() {
		int numItems = 5;
		double unitPrice = 1.43;
		double expected = 2 * 1.43;

		double actual = this.subject.calculateDiscount(numItems, unitPrice);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_calculateDiscount_sixItemsThreeDiscounts() {
		int numItems = 6;
		double unitPrice = 1.43;
		double expected = 3 * 1.43;

		double actual = this.subject.calculateDiscount(numItems, unitPrice);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_applyDiscount_noDiscounts() {
		double total = 123.4;

		double actual = this.subject.applyDiscount(total);

		assertEquals(total, actual, 0);
	}

	@Test
	public void test_applyDiscount_discountForItemNotInBasket() {
		ShoppingItem item1 = new ShoppingItem("PLU 1", "", 1.99);
		this.basket.add(item1);

		double total = 123.4;
		this.discountedItems.add(new ShoppingItem("PLU 2", "", 2.99));

		double actual = this.subject.applyDiscount(total);

		assertEquals(total, actual, 0);
	}

	@Test
	public void test_applyDiscount_onlyOneItemSoNoDiscount() {
		ShoppingItem item1 = new ShoppingItem("PLU 1", "", 1.99);
		this.basket.add(item1);

		double total = 123.4;
		this.discountedItems.add(item1);

		double actual = this.subject.applyDiscount(total);

		assertEquals(total, actual, 0);
	}

	@Test
	public void test_applyDiscount_twoItemsSoOneDiscount() {
		ShoppingItem item1 = new ShoppingItem("PLU 1", "", 1.99);
		this.basket.add(item1);
		this.basket.add(item1);

		double total = 123.4;
		this.discountedItems.add(item1);

		double actual = this.subject.applyDiscount(total);

		assertEquals(total - 1.99, actual, 0);
	}

	@Test
	public void test_applyDiscount_differentItemsEachWithDiscount() {
		ShoppingItem item1 = new ShoppingItem("PLU 1", "", 1.99);
		this.basket.add(item1);
		this.basket.add(item1);

		ShoppingItem item2 = new ShoppingItem("PLU 2", "", 2.76);
		this.basket.add(item2);
		this.basket.add(item2);

		double total = 123.4;
		this.discountedItems.add(item1);
		this.discountedItems.add(item2);

		double actual = this.subject.applyDiscount(total);

		assertEquals(total - 1.99 - 2.76, actual, 0);
	}
}
