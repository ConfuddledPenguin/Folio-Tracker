package quoteServer;

///: NoSuchTickerException.java

public class NoSuchTickerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 * 
	 * @param s the exception to be thrown.
	 */
	public NoSuchTickerException( String s ) {
		
		super(s);
		
	}//end of default Constructor.

}///:~