package model;

/**
 * An interface for the Shares.
 *
 * A shares objects represents a number of shares of a
 * stock. Shares objects belong to stock objects.
 *
 */
public interface Shares {
	
	/**
	 * Returns the initial value of the shares
	 * 
	 * @effects Returns the initial value of the shares
	 * 
	 * @return The initial value
	 */
	public double getInitialValue();
	
	/**
	 * Returns the Number of shares held
	 * 
	 * @effects Returns the Number of shares held
	 * 
	 * @return The number of shares
	 */
	public int getNoShares();
	
	/**
	 * Sets the number of shares. Callers should
	 * ensure that if changing the number of shares
	 * that the initial purchase price remains the
	 * same. Otherwise creating a new shares object is
	 * Recommended.
	 * 
	 * @effects Sets the number of shares.
	 * 
	 * @modifies this
	 * 
	 * @param noShares The new number of shares
	 * 
	 * @return True if successful, false otherwise
	 */
	public boolean setNoShares(int noShares);
}
