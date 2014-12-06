package model;

/**
 * An interface for the Stock object.
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
public interface Stock {

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
	public boolean addShares(int noShares, double initialValue);
	
	/**
	 * Removes shares from a stock
	 * 
	 * @effects Removes o from this.shares
	 * @modifies this
	 * 
	 * @param noShares The shares to be removed
	 */
	public boolean removeShares(int noShares);
	
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
	 * Returns the total spent
	 * 
	 * @return the total
	 */
	public double getTotalSpent();
	
	/**
	 * Returns the name of the exchange
	 * 
	 * @effects returns this.exchange
	 * 
	 * @return the exchange
	 */
	public String getExchange();
	
	/**
	 * Returns the current value
	 * 
	 * @effects returns thi.currentValue
	 * 
	 * @return the current value
	 */
	public double getCurrentValue();
	
	/**
	 * Returns the holding value
	 * 
	 * @effects returns this.holdingValue
	 * 
	 * @return the holding value
	 */
	public double getHoldingValue();
	
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
	 * Returns the closing price
	 * 
	 * @effects returns this.closingPrice
	 * 
	 * @return the closing price
	 */
	public double getClosingPrice();
	
	/**
	 * Returns the opening price
	 * 
	 * @effects returns this.openingPrice
	 * 
	 * @return the opening price 
	 */
	public double getOpeningPrice();
	
	/**
	 * Returns the daily change
	 * 
	 * @effects returns this.dailyChange
	 * 
	 * @return the daily change 
	 */
	public double getDailyChange();
	
	/**
	 * Returns the daily max
	 * 
	 * @effects returns this.dailyMax
	 * 
	 * @return the daily max
	 */
	public double getDailyMax();
	
	
	/**
	 * Returns the daily min
	 * 
	 * @effects returns this.dailyMin
	 * 
	 * @return the dailyMin
	 */
	public double getDailyMin();

	
	/**
	 * Returns the volume of available shares
	 * 
	 * @effects returns this.volume
	 * 
	 * @return the volume
	 */
	public double getVolume();

}
