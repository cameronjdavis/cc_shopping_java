package cc_shopping_java;

/**
 * Rounds (read truncate) prices in the customer's favour.
 */
public class TruncationRounding implements Rounding {

	/**
	 * Round a price to two decimal places. It's not true rounding, it's
	 * truncating in the customer's favour.
	 */
	@Override
	public double roundPrice(double price) {
		return Math.floor(price * 100) / 100;
	}

}
