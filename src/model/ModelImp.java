package model;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the Model interface
 * 
 */
public class ModelImp implements Model {

	
	private List<Portfolio> portfolios;
	
	/**
	 * The constructor for this object
	 * 
	 * @effects Initialises the ModelImp object
	 * @modifies this
	 */
	public ModelImp() {
	
		portfolios = new ArrayList<Portfolio>();
	}

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
	@Override
	public Portfolio createPortfolio(String name) {
		
		Portfolio p = new PortfolioImp(name);
		
		portfolios.add(p);
		
		return p;
	}

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
	@Override
	public boolean deletePortfolio(Object o) {
		
		if ( o instanceof Portfolio){
		
			portfolios.remove( (Portfolio) o);
			return true;
		}
		
		return false;
	}
	
	/*-----------------------------------------------------------------------
	 * Below lies the land of the getters and setters. It is better not to
	 * voyage very deep into this land
	 */

	/**
	 * Returns a list of the portfolios
	 * 
	 * @effects returns List<Portfolio> portfolios
	 * 
	 * @return A List of portfolios
	 */
	@Override
	public List<Portfolio> getPortfolios() {
		
		return new ArrayList<Portfolio>(portfolios);
	}
	
}
