package model;

import java.util.List;


public interface Stock {

	public boolean addShares(int noShares, double initialValue);
	public boolean removeShares(Object o);
	
	public String getTicker();
	
	public String getName();
	
	public List<Shares> getShares();
	
	public double getCurrentValue();
	public boolean setCurrentValue(double currentValue);
	
	public double getHoldingValue();
	public boolean setHoldingValue(double holdingValue);
	
	public int getNumberOfShares();
	
	public double getNetGain();
	public boolean setNetGain(double netGain);
	
	public double getClosingPrice();
	public boolean setClosingPrice(double closingPrice);
	
	public double getOpeningPrice();
	public boolean setOpeningPrice(double openingPrice);
	
	public double getDailyChange();
	public boolean setDailyChange(double dailyChange);
}
