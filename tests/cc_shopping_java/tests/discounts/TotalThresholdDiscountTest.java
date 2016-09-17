package cc_shopping_java.tests.discounts;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import cc_shopping_java.discounts.*;
import org.junit.Before;
import org.junit.Test;

public class TotalThresholdDiscountTest {

	private TotalThresholdDiscount subject;

	private Discount discount;

	@Before
	public void setUp() throws Exception {
		this.discount = mock(Discount.class);
	}

	@Test
	public void test_applyDiscount_totalAboveThreshold() {
		double total = 987.6;
		this.subject = new TotalThresholdDiscount(10.0, this.discount);

		when(this.discount.applyDiscount(total)).thenReturn(123.4);

		double actual = this.subject.applyDiscount(total);

		assertEquals(123.4, actual, 0);
	}

	@Test
	public void test_applyDiscount_totalEqualsThreshold() {
		double total = 987.6;
		this.subject = new TotalThresholdDiscount(total, this.discount);

		when(this.discount.applyDiscount(total)).thenReturn(123.4);

		double actual = this.subject.applyDiscount(total);

		assertEquals(123.4, actual, 0);
	}

	@Test
	public void test_applyDiscount_totalBelowThreshold() {
		double total = 987.6;
		this.subject = new TotalThresholdDiscount(1000, this.discount);

		verify(this.discount, never()).applyDiscount(anyDouble());

		double actual = this.subject.applyDiscount(total);

		assertEquals(total, actual, 0);
	}
}
