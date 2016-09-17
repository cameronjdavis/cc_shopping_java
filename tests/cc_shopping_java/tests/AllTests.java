package cc_shopping_java.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import cc_shopping_java.tests.discounts.*;

@RunWith(Suite.class)
@SuiteClasses({ DiscountedPriceCalculatorTest.class, RealWorldTest.class, TruncationRoundingTest.class,
		UndiscountedPriceCalculatorTest.class, DiscountCollectionTest.class, LoayltyDiscountTest.class,
		PercentageDiscountTest.class, TotalThresholdDiscountTest.class, TwoForOneDiscountTest.class })
public class AllTests {

}
