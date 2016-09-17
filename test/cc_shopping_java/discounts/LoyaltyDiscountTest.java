package cc_shopping_java.discounts;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoyaltyDiscountTest {

    private LoyaltyDiscount subject;

    private discount;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
    public void test_applyDiscount_isLoyal()
    {
        this.subject = new Subject(true, this.discount);
        total = 987.6;

        this.discount.expects(this.once())
                .method('applyDiscount')
                .with(total)
                .willReturn(123.4);

        actual = this.subject.applyDiscount(total);

        this.assertEquals(123.4, actual);
    }

	@Test
    public void test_applyDiscount_isNotLoyal()
    {
        this.subject = new Subject(false, this.discount);
        total = 987.6;

        this.discount.expects(this.never())
                .method('applyDiscount');

        actual = this.subject.applyDiscount(total);

        this.assertEquals(total, actual);
    }

}
