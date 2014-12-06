package model;

import java.util.List;

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
	 * Updates the model
	 * 
	 * @effects updates the information in the model
	 */
	public void update();
	
	/**
	 * Sets the rate at which the application checks
	 * for the latest stock information
	 * 
	 * @effects model.refreshRate = refreshRate
	 */
	public void setRefreshRate(long refreashRate);
}
