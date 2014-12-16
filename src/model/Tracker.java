package model;

import java.io.File;
import java.util.List;
import java.util.Observer;

/**
 * An interface for the Model.
 * 
 * The traker keep track of all the portfolios in the model
 * 
 * @author Tom Maxwell
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
	
	/**
	 * Loads the given file
	 * 
	 * @modifies this
	 * 
	 * @param inputFile the file to load
	 * @return the loaded portfolio
	 * @throws FailedToLoadFileException 
	 */
	public Portfolio loadPortfolio(File inputFile) throws FailedToLoadFileException;
	
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
	public void setRefreshRate(long refreashRate) throws IllegalRefreashRateException;
	
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
