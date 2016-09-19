package cc_shopping_java.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cc_shopping_java.Basket;
import cc_shopping_java.ShoppingItem;

/**
 * These tests are strictly required because they are testing ArrayList methods.
 * They are included to show the code meets the requirements to be able to add,
 * remove and empty the basket.
 */
public class BasketTest {

	private Basket subject;

	@Before
	public void setUp() throws Exception {
		this.subject = new Basket();
	}

	@Test
	public void test_add_addsItem() {
		ShoppingItem item = new ShoppingItem("", "", 1.23);

		this.subject.add(item);

		assertTrue(this.subject.contains(item));
	}

	@Test
	public void test_remove_removesItem() {
		// arrange
		ShoppingItem item = new ShoppingItem("", "", 1.23);
		this.subject.add(item);

		// act
		this.subject.remove(item);

		// assert
		assertFalse(this.subject.contains(item));
	}

	@Test
	public void test_clear_emptiesList() {
		// arrange
		ShoppingItem item = new ShoppingItem("", "", 1.23);
		this.subject.add(item);

		// act
		this.subject.clear();

		// assert
		assertEquals(0, this.subject.size());
	}

}
