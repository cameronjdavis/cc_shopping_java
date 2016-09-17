package cc_shopping_java.tests.discounts;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import cc_shopping_java.discounts.Discount;
import cc_shopping_java.discounts.DiscountCollection;

public class DiscountCollectionTest {

	private DiscountCollection subject;

	private Collection<Discount> discounts;

	@Before
	public void setUp() throws Exception {
		this.discounts = new ArrayList<Discount>();
		this.subject = new DiscountCollection(this.discounts);
	}

	@Test
	public void test_applyDiscount_noDiscounts() {
		double actual = this.subject.applyDiscount(123.4);

		assertEquals(123.4, actual, 0);
	}

	@Test
	public void test_applyDiscount_appliesDiscounts() {
		// arrange
		double total = 987.6;

		Discount discount1 = mock(Discount.class);
		when(discount1.applyDiscount(total)).thenReturn(765.4);

		Discount discount2 = mock(Discount.class);
		when(discount2.applyDiscount(765.4)).thenReturn(543.2);

		this.discounts.add(discount1);
		this.discounts.add(discount2);

		// act
		double actual = this.subject.applyDiscount(total);

		// assert
		assertEquals(543.2, actual, 0);
	}

}
