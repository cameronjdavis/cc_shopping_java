package cc_shopping_java.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cc_shopping_java.TruncationRounding;

public class TruncationRoundingTest {

	private TruncationRounding subject;

	@Before
	public void setUp() throws Exception {
		this.subject = new TruncationRounding();
	}

	@Test
	public void test_roundPrice_zeroRoundsToZero() {
		double price = 0;
		double expected = 0;

		double actual = this.subject.roundPrice(price);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_roundPrice_noRoundingNeeded() {
		double price = 0.02;
		double expected = 0.02;

		double actual = this.subject.roundPrice(price);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_roundPrice_toTwoDecimalPlaces() {
		double price = 0.023;
		double expected = 0.02;

		double actual = this.subject.roundPrice(price);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_roundPrice_midPointRoundedDown() {
		double price = 0.025;
		double expected = 0.02;

		double actual = this.subject.roundPrice(price);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_roundPrice_aboveMidPointRoundedDown() {
		double price = 0.026;
		double expected = 0.02;

		double actual = this.subject.roundPrice(price);

		assertEquals(expected, actual, 0);
	}

	@Test
	public void test_roundPrice_wholeNumberLeftUntouched() {
		double price = 1.026;
		double expected = 1.02;

		double actual = this.subject.roundPrice(price);

		assertEquals(expected, actual, 0);
	}

}
