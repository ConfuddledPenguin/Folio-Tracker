package model;

/**
 * The exception is used to represent the fact that the stock
 * already exists within a portfolio
 * 
 * @author Tom
 *
 */
public class AlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5849225184044552111L;

	/**
	 * The constructor
	 * 	
	 * @param msg A message about the issue
	 */
	public AlreadyExistsException(String msg) {
		super(msg);
	}
}
