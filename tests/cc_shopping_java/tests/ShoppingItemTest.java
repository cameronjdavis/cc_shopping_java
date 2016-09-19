package cc_shopping_java.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cc_shopping_java.ShoppingItem;

public class ShoppingItemTest {

	private ShoppingItem subject;

	@Test
	public void test_setInstanceVariables() {
		this.subject = new ShoppingItem("PLU 1", "Name 1", 1.23);

		assertEquals("PLU 1", this.subject.getPlu());
		assertEquals("Name 1", this.subject.getName());
		assertEquals(1.23, this.subject.getPrice(), 0);
	}
}