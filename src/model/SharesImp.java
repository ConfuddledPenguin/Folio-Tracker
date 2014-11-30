package model;

/**
 * An implementation for the Shares.
 *
 * A shares objects represents a number of shares of a
 * stock. Shares objects belong to stock objects.
 *
 */
class SharesImp implements Shares{

	//The number of shares
	private int noShares;
	//The initial value of the shares
	private double initialValue;
	
	/**
	 * The constructor for the SharesImp object
	 * 
	 * @effects Initialises the object
	 * 
	 * @modifies this
	 * 
	 * @param noShares The number of shares
	 * @param initialValue The initial value of the shares
	 */
	public SharesImp(int noShares,double initialValue){
		
		this.noShares = noShares;
		this.initialValue = initialValue;	
	}
	
	/*-----------------------------------------------------------------------
	 * Below lies the land of the getters and setters. It is better not to
	 * voyage very deep into this land
	 */
	
	/**
	 * Returns the initial value of the shares
	 * 
	 * @effects Returns the initial value of the shares
	 * 
	 * @return The initial value
	 */
	@Override
	public double getInitialValue(){
		
		return initialValue;
	}
	
	/**
	 * Returns the Number of shares held
	 * 
	 * @effects Returns the Number of shares held
	 * 
	 * @return The number of shares
	 */
	@Override
	public int getNoShares(){
		
		return noShares;
	}

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
	@Override
	public boolean setNoShares(int noShares) {
		
		this.noShares = noShares;
		
		return true;
	}
}
