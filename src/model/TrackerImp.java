package model;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the Model interface
 * 
 */
public class TrackerImp implements Tracker {

	/**
	 * This controls whether the uni proxy is used when accessing 
	 * the stock info
	 */
	public static final Boolean USE_PROXY = false;
	
	/**
	 * The default refresh rate of the stock information. This is
	 * the time between updates of the model.
	 * 
	 * By default this is set to 30 seconds.
	 */
	public static final Long DEFUALT_REFREASH_RATE = (long) 30000;
	
	/**
	 * The minimum refresh rate of the stock information.
	 * 
	 * The yahoo API states that one IP can not access 
	 * the API more than 2000 an hour. Assuming we have
	 * 10 stocks (reasonable  base value) thats 200 updates
	 * an hour, or once every 18 seconds.
	 */
	public static final long MIN_REFRESH_RATE = (long) 18000;
	
	//The portfolios in the model
	private List<PortfolioImp> portfolios;

	private long refreshRate = DEFUALT_REFREASH_RATE;
	
	
	/**
	 * The constructor for this object
	 * 
	 * @effects Initialises the ModelImp object
	 * @modifies this
	 */
	public TrackerImp() {
	
		portfolios = new ArrayList<PortfolioImp>();
		
		Thread updater = new Thread(new ModelUpdater(this));
		updater.start();
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
		
		PortfolioImp p = new PortfolioImp(name);
		
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
	
	/**
	 * This updates the model, including all portfolios
	 * and stock within it with the latest information
	 * from the web.
	 * 
	 * @effects for all portfolio in this.portfolios call
	 * portfolio.update
	 */
	public void updateTracker(){
		
		for(PortfolioImp p: portfolios){
			
			p.update();
		}
	}

	/**
	 * Sets the rate at which the application checks
	 * for the latest stock information
	 * 
	 * @effects model.refreshRate = refreshRate
	 * @modifies this
	 */
	@Override
	public void setRefreshRate(long refreashRate) {
		
		if(refreashRate < MIN_REFRESH_RATE){
			//TODO handle case - refreash is to low
		}
		
		//Calculate how much time is needed between refreshes in mins
		double legalRefreashRateInMins = 60 / (2000 / noStocks());
		long legalRefreashRate = (long) (legalRefreashRateInMins * 60 * 1000);
		
		if(refreashRate < legalRefreashRate){
			//TODO handle case - refresh rate could get IP banned
		}
		
		this.refreshRate = refreashRate;
	}
	
	/*-----------------------------------------------------------------------
	 * Package methods
	 */
	
	/**
	 * Returns the refresh rate of the application
	 * 
	 * @effects returns this.refreashRate
	 * 
	 * @return the refreash rate
	 */
	long getRefreshRate(){
		return refreshRate;
	}
	
	/**
	 * Returns the number of stocks in the model
	 * 
	 * @effects count the number of stocks held
	 * within this
	 * 
	 * @return the number of stocks
	 */
	int noStocks(){
		
		int total =0;
		
		for(PortfolioImp p : portfolios){
			total =+ p.noStocks();
		}
		
		return total;
	}

}
