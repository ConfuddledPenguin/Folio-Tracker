package model;

import java.util.List;

/**
 * An interface for the Stock object
 *
 */
public interface Stock {

	public Shares addShares(int noShares, double initialValue);
	public boolean removeShares(Object o);
	
	/**
	 * Returns the stock ticker
	 * 
	 * @effect returns this.ticker
	 * 
	 * @return The ticker
	 */
	public String getTicker();
	
	/**
	 * Returns the name of the stock
	 * 
	 * @effect returns this.name
	 * 
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Returns the name of the exchange
	 * 
	 * @effects returns this.exchange
	 * 
	 * @return the exchange
	 */
	public String getExchange();
	
	/**
	 * Returns the shares.
	 * 
	 * @effects this.shares
	 * 
	 * @return the shares
	 */
	public List<Shares> getShares();
	
	/**
	 * Returns the current value
	 * 
	 * @effects returns thi.currentValue
	 * 
	 * @return the current value
	 */
	public double getCurrentValue();
	
	/**
	 * Sets the current value
	 * 
	 * @effects this.currentValue = currentValue
	 * @modifies this
	 * 
	 * @param currentValue The current value
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean setCurrentValue(double currentValue);
	
	/**
	 * Returns the holding value
	 * 
	 * @effects returns this.holdingValue
	 * 
	 * @return the holding value
	 */
	public double getHoldingValue();
	
	/**
	 * Sets the holding value
	 * 
	 * @effects this.holdingValue = holdingValue
	 * @modifies this
	 * 
	 * @param holdingValue
	 * @return true if successful, false otherwise
	 */
	public boolean setHoldingValue(double holdingValue);
	
	/**
	 * Returns the number of shares held
	 * 
	 * @effects returns this.noSahres
	 * 
	 * @return the number of shares held
	 */
	public int getNumberOfShares();
	
	/**
	 * Returns the net gain of the stock
	 * 
	 * @effects returns this.netGain
	 * 
	 * @return the net gain
	 */
	public double getNetGain();
	
	/**
	 * Sets the net gain of the stock
	 * 
	 * @effects this.netGain = netGain
	 * @modifies this
	 * 
	 * @param netGain the net gain
	 * @return true if successful, false otherwise
	 */
	public boolean setNetGain(double netGain);
	
	/**
	 * Returns the closing price
	 * 
	 * @effects returns this.closingPrice
	 * 
	 * @return the closing price
	 */
	public double getClosingPrice();
	
	/**
	 * Sets the closing price of the stock
	 * 
	 * @effects this.closingPrice = closingPrice
	 * @modifies this
	 * 
	 * @param closingPrice the closing price
	 * @return true if successful, false otherwise
	 */
	public boolean setClosingPrice(double closingPrice);
	
	/**
	 * Returns the opening price
	 * 
	 * @effects returns this.openingPrice
	 * 
	 * @return the opening price 
	 */
	public double getOpeningPrice();
	
	/**
	 * Sets the opening price
	 * 
	 * @effects this.openingPrice = openingPrice
	 * @modifies this
	 * 
	 * @param openingPrice the opening price
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean setOpeningPrice(double openingPrice);
	
	/**
	 * Returns the daily change
	 * 
	 * @effects returns this.dailyChange
	 * 
	 * @return the daily change 
	 */
	public double getDailyChange();
	
	/**
	 * Sets the daily change
	 * 
	 * @effects this.dailyChange = dailyChange
	 * @modifies this
	 * 
	 * @param dailyChnage the change
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean setDailyChange(double dailyChange);
	
	/**
	 * Returns the daily max
	 * 
	 * @effects returns this.dailyMax
	 * 
	 * @return the daily max
	 */
	public double getDailyMax();
	
	/**
	 * Sets the daily max
	 * 
	 * @effects this.dailyMax = dailyMax
	 * @modifies this
	 * 
	 * @param dailyMax the daily max
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean setDailyMax(double dailyMax);
	
	/**
	 * Returns the daily min
	 * 
	 * @effects returns this.dailyMin
	 * 
	 * @return the dailyMin
	 */
	public double getDailyMin();
	
	/**
	 * Sets the daily min
	 * 
	 * @effects this.dailyMin = dailyMin
	 * @modifies this
	 * 
	 * @param dailyMin the daily min
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean setDailyMin(double dailyMin);
	
	/**
	 * Returns the volume of available shares
	 * 
	 * @effects returns this.volume
	 * 
	 * @return the volume
	 */
	public double getVolume();
	
	/**
	 * Sets the volume of available shares
	 * 
	 * @effects this.volume = volume
	 * @modifies this
	 * 
	 * @param volume the volume
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean setVolume(double volume);
}
