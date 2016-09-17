package cc_shopping_java.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;

import cc_shopping_java.ShoppingItem;
import cc_shopping_java.UndiscountedPriceCalculator;
import cc_shopping_java.discounts.Discount;
import cc_shopping_java.DiscountedPriceCalculator;

import org.junit.Before;
import org.junit.Test;

public class DiscountedPriceCalculatorTest {

	private DiscountedPriceCalculator subject;
	
	private UndiscountedPriceCalculator totalCalculator;
	
	private Discount discount;
	
	private Collection<ShoppingItem> basket;
	
	@Before
	public void setUp() throws Exception {
		this.totalCalculator = mock(UndiscountedPriceCalculator.class);
		this.discount = mock(Discount.class);
		this.subject = new DiscountedPriceCalculator(this.totalCalculator, this.discount);
		this.basket = new ArrayList<ShoppingItem>();
	}

	@Test
	public void test_calculatePrice_noItems()
    {
		when(this.totalCalculator.calculatePrice(this.basket)).thenReturn(456.7);
		when(this.discount.applyDiscount(456.7)).thenReturn(123.4);
		
		double actual = this.subject.calculatePrice(this.basket);
		
		assertEquals(123.4, actual, 0);
    }
}
