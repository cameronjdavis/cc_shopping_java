package cc_shopping_java.tests.discounts;

import static org.junit.Assert.*;
import cc_shopping_java.discounts.*;
import org.junit.Test;

public class PercentageDiscountTest {

	private PercentageDiscount subject;

	@Test
	public void test_applyDiscount_noDiscount() {
		double total = 100;
		double percentage = 0;
		double expected = 100;

		this.subject = new PercentageDiscount(percentage);

		double actual = this.subject.applyDiscount(total);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_applyDiscount_100PercentDiscount() {
		double total = 100;
		double percentage = 1;
		double expected = 0;

		this.subject = new PercentageDiscount(percentage);

		double actual = this.subject.applyDiscount(total);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_applyDiscount_partialDiscount() {
		double total = 100;
		double percentage = 0.15;
		double expected = 85;

		this.subject = new PercentageDiscount(percentage);

		double actual = this.subject.applyDiscount(total);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_applyDiscount_zeroTotal() {
		double total = 0;
		double percentage = 0.15;
		double expected = 0;

		this.subject = new PercentageDiscount(percentage);

		double actual = this.subject.applyDiscount(total);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_applyDiscount_totalNeverNegative() {
		double total = 20;
		double percentage = 1.15;
		double expected = 0;

		this.subject = new PercentageDiscount(percentage);

		double actual = this.subject.applyDiscount(total);

		assertEquals(expected, actual, 0);
	}
}