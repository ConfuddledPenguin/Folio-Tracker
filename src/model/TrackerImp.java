package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * An implementation of the Model interface
 * 
 */
public class TrackerImp extends Observable implements Tracker {

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
		
		PortfolioImp p = new PortfolioImp(name, this);
		
		portfolios.add(p);
		
		modelChanged();
		
		return p;
	}
	
	public Portfolio loadPortfolio(File inputFile){
		
		PortfolioLoader pl = new PortfolioLoader(this);
		
		modelChanged();
		
		return pl.loadPortfolio(inputFile);
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
		
		if ( o instanceof Portfolio && o != null){
		
			portfolios.remove( (Portfolio) o);
			modelChanged();
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
	 * Sets the rate at which the application checks
	 * for the latest stock information
	 * @throws IllegalRefreashRate 
	 * 
	 * @effects model.refreshRate = refreshRate
	 * @modifies this
	 */
	@Override
	public void setRefreshRate(long refreashRate) throws IllegalRefreashRate {
		
		if(refreashRate < MIN_REFRESH_RATE){
			throw new IllegalRefreashRate("Refreash rate must be greater than minimum refreash rate", MIN_REFRESH_RATE);
		}
		
		if(noStocks() != 0){
				
			//Calculate how much time is needed between refreshes in mins
			//it is plus 100 to ensure room to grow in the future.
			double legalRefreashRateInMins = 60 / (2000 / (noStocks()));
			long legalRefreashRate = (long) (legalRefreashRateInMins * 60 * 1000);
			
			if(refreashRate < legalRefreashRate){
				throw new IllegalRefreashRate("Rate must be greater than " + MIN_REFRESH_RATE + "to avoid the API banhammer", MIN_REFRESH_RATE);
			}
		}
		
		this.refreshRate = refreashRate;
	}
	
	/**
	 * Adds an observer to the set of observers for this object, 
	 * provided that it is not the same as some observer already
	 * in the set. The order in which notifications will be 
	 * delivered to multiple observers is not specified. See 
	 * the class comment.
	 * 
	 * @param o The observer to add
	 */
	@Override
	public void addObserver(Observer o) {
		
		super.addObserver(o);
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
			total += p.noStocks();
		}
		
		return total;
	}
	
	/**
	 * Lets the observers know if the model has changed
	 * 
	 * @effects notifies observers
	 */
	void modelChanged(){
		
		setChanged();
		notifyObservers();
	}
	
	/**
	 * This updates the model, including all portfolios
	 * and stock within it with the latest information
	 * from the web.
	 * 
	 * @effects for all portfolio in this.portfolios call
	 * portfolio.update
	 */
	void updateTracker(){
		
		for(PortfolioImp p: portfolios){
			
			p.update();
		}
	}
}
