package model;

import java.io.IOException;
import java.util.Observable;

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
 */
class StockImp extends Observable implements Stock {

	//The stock ticker
	private String ticker;
	//The stock name
	private String name;
	//The Stock exchange wheres its listed
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
	 */
	public StockImp(String ticker, String name, String exchange, double currentValue) {
		this.ticker = ticker;
		this.name = name;
		this.exchange = exchange;
		this.currentValue = currentValue;
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
	 */
	public synchronized boolean addShares(int noShares, double initialValue) {
		
		this.noShares += noShares;
		this.totalSpent += initialValue * noShares;
		
		setChanged();
		notifyObservers();
		
		return true;
	}
	
	/**
	 * Removes shares from a stock
	 * 
	 * @effects Removes o from this.shares
	 * @modifies this
	 * 
	 * @param noShares The shares to be removed
	 */
	public synchronized boolean removeShares(int noShares){
		
		double value = noShares * currentValue;
		
		totalSpent -= value;
		
		setChanged();
		notifyObservers();
		
		return true;
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

	/**
	 * Update the stock with information from the interwebs
	 * 
	 * @effects updates this
	 * @modifies this
	 */
	synchronized void update(){
		
		IQuote quoter = new Quote(TrackerImp.USE_PROXY);
		
		try {
			quoter.setValues(ticker);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebsiteDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchTickerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//update the stock
		try {
			currentValue = quoter.getLatest();  //Update latest price
			openingPrice = quoter.getOpen();	//update opening price
			closingPrice = quoter.getClose();	//update close price
			dailyChange = quoter.getChange();	//update Daily change
			volume = quoter.getVolume();		//update volume
			dailyMax = quoter.getRangeMax();	//update daily max
			dailyMin = quoter.getRangeMin();	//update daily min
		} catch (MethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
