package model;

import java.util.ArrayList;
import java.util.List;

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
	 * The land of the getters and setters
	 */
	

	public List<Shares> getShares(){
		
		return new ArrayList<Shares>(shares);
		
	}

	@Override
	public String getTicker() {
		
		return ticker;
	}


	@Override
	public String getName() {

		return name;
	}

	@Override
	public String getExchange() {
		
		return exchange;
	}

	@Override
	public double getCurrentValue() {
		
		return currentValue;
	}


	@Override
	public boolean setCurrentValue(double currentValue) {
		
		this.currentValue = currentValue;
		
		return true;
	}


	@Override
	public double getHoldingValue() {
		
		return holdingValue;
	}


	@Override
	public boolean setHoldingValue(double holdingValue) {
		
		this.holdingValue = holdingValue;
		
		return true;
	}


	@Override
	public int getNumberOfShares() {
		
		return noShares;
	}


	@Override
	public double getNetGain() {

		return netGain;
	}


	@Override
	public boolean setNetGain(double netGain) {
		
		this.netGain = netGain;
		
		return true;
	}


	@Override
	public double getClosingPrice() {
		
		return closingPrice;
	}


	@Override
	public boolean setClosingPrice(double closingPrice) {
		
		this.closingPrice = closingPrice;
		
		return true;
	}


	@Override
	public double getOpeningPrice() {
		
		return openingPrice;
	}


	@Override
	public boolean setOpeningPrice(double openingPrice) {
		
		this.openingPrice = openingPrice;
		
		return true;
	}


	@Override
	public double getDailyChange() {
		
		return dailyChange;
	}


	@Override
	public boolean setDailyChange(double dailyChange) {
		
		this.dailyChange = dailyChange;
		
		return true;
	}

	@Override
	public double getDailyMax() {

		return dailyMax;
	}

	@Override
	public boolean setDailyMax(double dailyMax) {
		
		this.dailyMax = dailyMax;
		
		return true;
	}

	@Override
	public double getDailyMin() {

		return dailyMin;
	}

	@Override
	public boolean setDailyMin(double dailyMin) {

		this.dailyMin = dailyMin;
		
		return true;
	}

	@Override
	public double getVolume() {
		
		return volume;
	}

	@Override
	public boolean setVolume(double volume) {
		
		this.volume = volume;
		
		return true;
	}
}
