package model;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the Stock interface
 *
 */
class StockImp implements Stock {

	//The stock ticker
	private String ticker;
	//The stock name
	private String name;
	//The Stock exchange wheres its listed
	private String exchange;
	//The current value of the stock
	private double currentValue;
	//The number of stocks held
	private int noShares = 0;
	//The total value of the shares held
	private double holdingValue =0;
	//The net gain
	private double netGain = 0;
	//The closing price of the stock
	private double closingPrice = 0;
	//The opening price of the stock
	private double openingPrice = 0;
	//The daily change of the sock
	private double dailyChange = 0;
	//The daily max
	private double dailyMax = 0;
	//The daily min
	private double dailyMin = 0;
	//The volume of shares available
	private double volume = 0;
	//The shares objects
	private List<SharesImp> shares;
	
	
	public StockImp(String ticker, String name, String exchange, double currentValue) {
		this.ticker = ticker;
		this.name = name;
		this.exchange = exchange;
		this.currentValue = currentValue;
		
		shares = new ArrayList<SharesImp>();
	}
	
	public Shares addShares(int noShares, double initialValue) {
		
		SharesImp s = new SharesImp(noShares, initialValue);
		shares.add(s);
		
		return s;
	}
	
	public boolean removeShares(Object o){
		
		if ( o instanceof Shares){
			
			shares.remove( (Shares) o);
			return true;
		}
		
		return false;
	}
	
	/*-----------------------------------------------------------------------
	 * Below lies the land of the getters and setters. It is better not to
	 * voyage very deep into this land
	 */
	

	public List<Shares> getShares(){
		
		return new ArrayList<Shares>(shares);
		
	}

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
	public double getCurrentValue() {
		
		return currentValue;
	}

	/**
	 * Returns the current value
	 * 
	 * @effects returns thi.currentValue
	 * 
	 * @return the current value
	 */
	@Override
	public boolean setCurrentValue(double currentValue) {
		
		this.currentValue = currentValue;
		
		return true;
	}

	/**
	 * Returns the holding value
	 * 
	 * @effects returns this.holdingValue
	 * 
	 * @return the holding value
	 */
	@Override
	public double getHoldingValue() {
		
		return holdingValue;
	}

	/**
	 * Sets the holding value
	 * 
	 * @effects this.holdingValue = holdingValue
	 * @modifies this
	 * 
	 * @param holdingValue
	 * @return true if successful, false otherwise
	 */
	@Override
	public boolean setHoldingValue(double holdingValue) {
		
		this.holdingValue = holdingValue;
		
		return true;
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
	public double getNetGain() {

		return netGain;
	}

	/**
	 * Sets the net gain of the stock
	 * 
	 * @effects this.netGain = netGain
	 * @modifies this
	 * 
	 * @param netGain the net gain
	 * @return true if successful, false otherwise
	 *//**
	 * Returns the closing price
	 * 
	 * @effects returns this.closingPrice
	 * 
	 * @return the closing price
	 */
	@Override
	public boolean setNetGain(double netGain) {
		
		this.netGain = netGain;
		
		return true;
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
	public double getClosingPrice() {
		
		return closingPrice;
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
	public boolean setClosingPrice(double closingPrice) {
		
		this.closingPrice = closingPrice;
		
		return true;
	}

	/**
	 * Returns the opening price
	 * 
	 * @effects returns this.openingPrice
	 * 
	 * @return the opening price 
	 */
	@Override
	public double getOpeningPrice() {
		
		return openingPrice;
	}

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
	@Override
	public boolean setOpeningPrice(double openingPrice) {
		
		this.openingPrice = openingPrice;
		
		return true;
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
	 * Sets the daily change
	 * 
	 * @effects this.dailyChange = dailyChange
	 * @modifies this
	 * 
	 * @param dailyChnage the change
	 * 
	 * @return true if successful, otherwise false
	 */
	@Override
	public boolean setDailyChange(double dailyChange) {
		
		this.dailyChange = dailyChange;
		
		return true;
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
	 * Sets the daily max
	 * 
	 * @effects this.dailyMax = dailyMax
	 * @modifies this
	 * 
	 * @param dailyMax the daily max
	 * 
	 * @return true if successful, otherwise false
	 */
	@Override
	public boolean setDailyMax(double dailyMax) {
		
		this.dailyMax = dailyMax;
		
		return true;
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
	 * Sets the daily min
	 * 
	 * @effects this.dailyMin = dailyMin
	 * @modifies this
	 * 
	 * @param dailyMin the daily min
	 * 
	 * @return true if successful, otherwise false
	 */
	@Override
	public boolean setDailyMin(double dailyMin) {

		this.dailyMin = dailyMin;
		
		return true;
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
	 * Sets the volume of available shares
	 * 
	 * @effects this.volume = volume
	 * @modifies this
	 * 
	 * @param volume the volume
	 * 
	 * @return true if successful, otherwise false
	 */
	@Override
	public boolean setVolume(double volume) {
		
		this.volume = volume;
		
		return true;
	}
}
