package model;

public class CantRemoveMoreThanOwnedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2942281516971324354L;

	public CantRemoveMoreThanOwnedException(String msg) {
		super(msg);
	}
}
