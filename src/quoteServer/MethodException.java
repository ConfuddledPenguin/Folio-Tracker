package quoteServer;


///:MethodException.java

public class MethodException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default Constructor
	 * 
	 * @param s: error message
	 */
	public MethodException( String s ) {

		super(s);

	}//default constructor

}///:~