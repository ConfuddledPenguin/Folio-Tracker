package model;

import java.io.IOException;

import quoteServer.IQuote;
import quoteServer.MethodException;
import quoteServer.NoSuchTickerException;
import quoteServer.Quote;
import quoteServer.WebsiteDataException;


/**
 * An implementation of the stock interface
 * 
 * A stock represents all of the information associated with a
 * Publicly traded stock that this application is interested
 * in.
 * 
 * This is mainly:
 * <ul>
 * 	<li>The stock ticker</li>
 * 	<li>The stocks name</li>
 * 	<li>The stocks value</li>
 * 	<li>The shares of the stock held</li>
 *  <li>The holding value</li>
 *  <li>etc...</li>
 * </ul>
 * 
 * @author Tom Maxwell
 */
class StockImp implements Stock {

	private IQuote quoter;
	private TrackerImp tracker;
	
	//The stock ticker
	private String ticker;
	//The stock name
	private String name;
	//The Stock exchange where its listed
	private String exchange;
	//The current value of the stock
	private volatile double currentValue;
	//The number of stocks held
	private int noShares = 0;
	//The total spend
	private volatile double totalSpent = 0;
	//The closing price of the stock
	private volatile double closingPrice = 0;
	//The opening price of the stock
	private volatile double openingPrice = 0;
	//The daily change of the sock
	private volatile double dailyChange = 0;
	//The daily max
	private volatile double dailyMax = 0;
	//The daily min
	private volatile double dailyMin = 0;
	//The volume of shares available
	private volatile double volume = 0;
	
	/**
	 * Constructor for the StockImp object
	 * 
	 * @effects initialises the object
	 * @modifies this
	 * 
	 * @param ticker The stock ticker
	 * @param name The stocks name
	 * @param exchange The stocks exchange
	 * @param currentValue The stocks current value
	 * 
	 * @throws NoSuchTickerException 
	 * @throws IOException 
	 */
	public StockImp(String ticker, TrackerImp tracker) throws NoSuchTickerException, IOException {
		this.ticker = ticker;
		this.tracker = tracker;
		
		assert ticker!=null;
		assert tracker!=null;
		
		quoter  = new Quote(TrackerImp.USE_PROXY);
		try {
			quoter.setValues(ticker);
			name = quoter.getName();
			exchange = quoter.getExchange();
		} catch (IOException e){
			throw e;
		} catch (WebsiteDataException e){
			//TODO
		} catch (MethodException e) {
			//TODO
		} catch(NoSuchTickerException e){
			throw new NoSuchTickerException("Ticker " + ticker + " doesnt exist");
		}
		update();
	}
	
	/**
	 * Adds shares to the stock
	 * 
	 * @effects Adds the shares to this.shares
	 * @modifies this
	 * 
	 * @param noShares The number of shares
	 * @param initialValue The value the shares where purchased at
	 * 
	 * @return true if successful, false otherwise
	 * @throws CantPurchaseMoreThanAvailableException 
	 */
	public synchronized boolean addShares(int noShares) throws CantPurchaseMoreThanAvailableException {

		
		if(noShares > volume){
			throw new CantPurchaseMoreThanAvailableException("Can't purchase " + noShares + " as only " + volume + " are available");
		}
		
		this.noShares += noShares;
		this.totalSpent += currentValue * noShares;
		
		assert (totalSpent > (currentValue)): "the total spent is less than the current value";
		tracker.modelChanged();
		
		return true;
	}
	
	/**
	 * Removes shares from a stock
	 * 
	 * @effects Removes o from this.shares
	 * @modifies this
	 * 
	 * @param noShares The shares to be removed
	 * @throws CantRemoveMoreThanOwnedException 
	 */
	public synchronized boolean removeShares(int noShares) throws CantRemoveMoreThanOwnedException{
		
		if(noShares > this.noShares){
			throw new CantRemoveMoreThanOwnedException("Can't sell " + noShares + " as only " + this.noShares + " are held");
		}
		
		this.noShares -= noShares;
		double value = noShares * currentValue;
		
		totalSpent -= value;
		assert(totalSpent == (totalSpent)): "total spent does not equal itself";
		
		tracker.modelChanged();
		
		return true;
	}
	
	/**
	 * Update the stock with information from the interwebs
	 * 
	 * @effects updates this
	 * @modifies this
	 */
	synchronized void update(){
		
		//update the stock
		try {
			currentValue = quoter.getLatest();  //Update latest price
			openingPrice = quoter.getOpen();	//update opening price
			closingPrice = quoter.getClose();	//update close price
			dailyChange = quoter.getChange();	//update Daily change
			volume = quoter.getVolume();		//update volume
			dailyMax = quoter.getRangeMax();	//update daily max
			dailyMin = quoter.getRangeMin();	//update daily min
			assert (dailyMax > (dailyMin)): "the daily max is lower than the daily min!";
			
		} catch (MethodException e) {
			/*
			 * Do nothing
			 * 
			 * This is called every so often, if we fail we can
			 * ignore it as it will be updated next time round
			 */
		}	
	}
	
	/*----------------------------------------------------------------------
	 * Package methods
	 */
	
	/**
	 * Set the totalSpent on this stock
	 * 
	 * @effects this.totalSpent = totalSpent
	 * @modifies this
	 * 
	 * @param totalSpent the amount spent
	 */
	void setTotalSpent(double totalSpent) {
		this.totalSpent = totalSpent;
		assert (totalSpent ==(totalSpent)): "Total spent does not equal itself";
	}
	
	/**
	 * Set the noShares on this stock
	 * 
	 * @effects this.noShares = noShares
	 * @modifies this
	 * 
	 * @param noShares the number of shares
	 */
	void setNoShares(int noShares) {
		this.noShares = noShares;
	}
	
	/*-----------------------------------------------------------------------
	 * Below lies the land of the getters and setters. It is better not to
	 * voyage very deep into this land
	 */

	/**
	 * Returns the stock ticker
	 * 
	 * @effect returns this.ticker
	 * 
	 * @return The ticker
	 */
	@Override
	public String getTicker() {
		
		assert ticker!=null;
		return ticker;
		
	}

	/**
	 * Returns the name of the stock
	 * 
	 * @effect returns this.name
	 * 
	 * @return the name
	 */
	@Override
	public String getName() {

		assert name!=null;
		return name;
	}

	/**
	 * Returns the total spent
	 * 
	 * @return the total
	 */
	public double getTotalSpent(){
		
		return totalSpent;
	}
	
	/**
	 * Returns the name of the exchange
	 * 
	 * @effects returns this.exchange
	 * 
	 * @return the exchange
	 */
	@Override
	public String getExchange() {
		
		assert exchange!=null;
		return exchange;
	}

	/**
	 * Returns the shares.
	 * 
	 * @effects this.shares
	 * 
	 * @return the shares
	 */
	@Override
	public synchronized double getCurrentValue() {
		
		
		return currentValue;
	}

	/**
	 * Returns the holding value
	 * 
	 * @effects returns this.holdingValue
	 * 
	 * @return the holding value
	 */
	@Override
	public synchronized double getHoldingValue() {
		
		return noShares * currentValue;
	}

	/**
	 * Returns the number of shares held
	 * 
	 * @effects returns this.noSahres
	 * 
	 * @return the number of shares held
	 */
	@Override
	public int getNumberOfShares() {
		
		return noShares;
	}

	/**
	 * Returns the net gain of the stock
	 * 
	 * @effects returns this.netGain
	 * 
	 * @return the net gain
	 */
	@Override
	public synchronized double getNetGain() {

		return currentValue * noShares - totalSpent;
	}

	/**
	 * Sets the closing price of the stock
	 * 
	 * @effects this.closingPrice = closingPrice
	 * @modifies this
	 * 
	 * @param closingPrice the closing price
	 * @return true if successful, false otherwise
	 */
	@Override
	public synchronized double getClosingPrice() {
		
		
		return closingPrice;
	}


	/**
	 * Returns the opening price
	 * 
	 * @effects returns this.openingPrice
	 * 
	 * @return the opening price 
	 */
	@Override
	public synchronized double getOpeningPrice() {
		
		return openingPrice;
	}


	/**
	 * Returns the daily change
	 * 
	 * @effects returns this.dailyChange
	 * 
	 * @return the daily change 
	 */
	@Override
	public double getDailyChange() {
		
		
		return dailyChange;
	}


	/**
	 * Returns the daily max
	 * 
	 * @effects returns this.dailyMax
	 * 
	 * @return the daily max
	 */
	@Override
	public double getDailyMax() {

		
		return dailyMax;
	}


	/**
	 * Returns the daily min
	 * 
	 * @effects returns this.dailyMin
	 * 
	 * @return the dailyMin
	 */
	@Override
	public double getDailyMin() {

		return dailyMin;
	}

	/**
	 * Returns the volume of available shares
	 * 
	 * @effects returns this.volume
	 * 
	 * @return the volume
	 */
	@Override
	public double getVolume() {
		
		
		return volume;
	}
}
