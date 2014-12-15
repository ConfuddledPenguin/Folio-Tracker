package model;

public class CantPurchaseMoreThanAvailableException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1674626146188659619L;

	public CantPurchaseMoreThanAvailableException(String msg) {
		super(msg);
	}

}
