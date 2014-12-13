package model;

import java.io.File;
import java.util.List;
import java.util.Observer;

/**
 * An interface for the Model.
 * 
 */
public interface Tracker {
	
	/**
	 * Creates a new portfolio in the model
	 * 
	 * @effects Creates a new portfolio in the model and
	 * 			returns it
	 * 
	 * @modifies this
	 * 
	 * @param name What to call the created portfolio
	 * 
	 * @return The portfolio created
	 */
	public Portfolio createPortfolio(String name);
	
	public Portfolio loadPortfolio(File inputFile);
	
	/**
	 * Deletes a given portfolio
	 * 
	 * @effects Deletes the given portfolio
	 * @modifies this
	 * 
	 * @param o The portfolio to be deleted
	 * 
	 * @return True if successful, otherwise false
	 */
	public boolean deletePortfolio(Object o);
	
	/**
	 * Returns a list of the portfolios
	 * 
	 * @effects returns List<Portfolio> portfolios
	 * 
	 * @return A List of portfolios
	 */
	public List<Portfolio> getPortfolios();
	
	/**
	 * Sets the rate at which the application checks
	 * for the latest stock information
	 * 
	 * @effects model.refreshRate = refreshRate
	 */
	public void setRefreshRate(long refreashRate) throws IllegalRefreashRate;
	
	/**
	 * Adds an observer to the set of observers for this object, 
	 * provided that it is not the same as some observer already
	 * in the set. The order in which notifications will be 
	 * delivered to multiple observers is not specified. See 
	 * the class comment.
	 * 
	 * @param o The observer to add
	 */
	public void addObserver(Observer o);
	
}
