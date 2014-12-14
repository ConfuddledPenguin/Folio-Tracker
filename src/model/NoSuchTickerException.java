package model;

/**
 * Used if there is no such ticker in the world
 * 
 * @author Tom Maxwell
 *
 */
public class NoSuchTickerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1837133203233735242L;

	/**
	 * Default constructor
	 * 
	 * @param s the exception to be thrown.
	 */
	public NoSuchTickerException( String s ) {
		
		super(s);
		
	}
}
