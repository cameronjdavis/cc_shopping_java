package cc_shopping_java.tests.discounts;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import cc_shopping_java.discounts.*;
import org.junit.Before;
import org.junit.Test;

public class LoayltyDiscountTest {

	private LoyaltyDiscount subject;

    private Discount discount;
	
	@Before
	public void setUp() throws Exception {
		this.discount = mock(Discount.class);
	}

	@Test
    public void test_applyDiscount_isLoyal()
    {
        this.subject = new LoyaltyDiscount(true, this.discount);
        double total = 987.6;

        when(this.discount.applyDiscount(total)).thenReturn(123.4);

        double actual = this.subject.applyDiscount(total);

        assertEquals(123.4, actual, 0.01);
    }

	@Test
    public void test_applyDiscount_isNotLoyal()
    {
        this.subject = new LoyaltyDiscount(false, this.discount);
        double total = 987.6;

        double actual = this.subject.applyDiscount(total);
        
        verify(this.discount, never()).applyDiscount(anyDouble());

        assertEquals(total, actual, 0.0);
    }

}