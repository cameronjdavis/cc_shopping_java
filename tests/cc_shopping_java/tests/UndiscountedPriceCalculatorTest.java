package cc_shopping_java.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import cc_shopping_java.ShoppingItem;
import cc_shopping_java.UndiscountedPriceCalculator;

import org.junit.Before;
import org.junit.Test;

public class UndiscountedPriceCalculatorTest {

	private UndiscountedPriceCalculator subject;

	private Collection<ShoppingItem> basket;

	@Before
	public void setUp() throws Exception {
		this.subject = new UndiscountedPriceCalculator();
		this.basket = new ArrayList<ShoppingItem>();
	}

	@Test
	public void test_calculatePrice_noItems() {
		double actual = this.subject.calculatePrice(this.basket);

		assertEquals(0.0, actual, 0);
	}

	@Test
	public void test_calculatePrice_oneItem() {
		ShoppingItem item1 = new ShoppingItem("", "", 1.99);
		this.basket.add(item1);

		double actual = this.subject.calculatePrice(this.basket);

		assertEquals(1.99, actual, 0);
	}

	@Test
	public void test_calculatePrice_twoItems() {
		// arrange
		ShoppingItem item1 = new ShoppingItem("", "", 1.99);
		this.basket.add(item1);
		this.basket.add(item1);

		// act
		double actual = this.subject.calculatePrice(this.basket);

		// assert
		assertEquals(1.99 + 1.99, actual, 0);
	}

}
