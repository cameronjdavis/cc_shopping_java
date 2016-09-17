package cc_shopping_java;

/**
 * A Rounding class defines a method for rounding prices.
 */
public interface Rounding {
	/**
	 * Round and return a price.
	 * 
	 * @param price
	 *            Price to be rounded.
	 */
	public double roundPrice(double price);
}
