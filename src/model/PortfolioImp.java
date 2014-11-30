package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A implementation of the portfolio interface
 *
 */
class PortfolioImp implements Portfolio {
	
	//The name of the portfolio
	private String name;
	//The total value of the portfolio
	private double totalValue = 0;
	//The net gain of this portfolio
	private double netGain = 0;
	//The stocks held in this portfolio
	List<Stock> stocks;
	
	/**
	 * The constructor for the PortfolioImp
	 * 
	 * @effects creates a portfolio object
	 * @modifies this
	 * 
	 * @param name The name for the portfolio
	 */
	public PortfolioImp(String name) {
		  this.name = name;
		  
		  stocks = new ArrayList<Stock>();
	}


	/**
	 * Creates and add a new stock to this portfolio
	 * 
	 * @effects Creates a Stock object
	 * @modifies this
	 * 
	 * @param ticker The ticker of the stock
	 * @param name The name of the stock
	 * @param exchange The name of the exchange
	 * @param currentValue The currentValue of the stock
	 * 
	 * @return The new stock object
	 */
	@Override
	public Stock newStock(String ticker, String name, String exchange, double currentValue) {
		
		Stock s = new StockImp(ticker, name, exchange, currentValue);
		
		stocks.add(s);
		
		return s;
	}

	/**
	 * Deletes the given stock from the portfolio
	 * 
	 * @effects Deletes the given stock from the portfolio
	 * @modifies this
	 * 
	 * @param o The Stock to be deleted
	 * 
	 * @return true if successful, false otherwise
	 */
	@Override
	public boolean deleteStock(Object o) {
		
		if ( o instanceof Stock){
			
			return stocks.remove( (Stock) o); 
		}
		
		return false;
	}
	
	/*-----------------------------------------------------------------------
	 * Below lies the land of the getters and setters. It is better not to
	 * voyage very deep into this land
	 */

	/**
	 * Returns the name of the portfolio
	 * 
	 * @effects returns this.name
	 * 
	 * @return The portfolios name
	 */
	@Override
	public List<Stock> getStocks() {
		
		return new ArrayList<Stock>(stocks);
	}

	/**
	 * Returns the total value of the portfolio
	 * 
	 * @effects returns this.totalValue
	 * 
	 * @return The total Value of the stock
	 */
	@Override
	public double getTotalValue() {
		
		return totalValue;
	}

	/**
	 * Set the total Value of the stock
	 * 
	 * @effects this.totalValue = totalValue
	 * @modifies this
	 * 
	 * @param totalValue the totalValue of the portfolio
	 * 
	 * @return true if successful, otherwise false
	 */
	@Override
	public boolean setTotalValue(double totalValue) {
		
		this.totalValue = totalValue;
		
		return true;
	}

	/**
	 * returns the Net gain in this portfolio
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
	 * Sets the net gain of this portfolio
	 * 
	 * @effects this.netGain = netGain
	 * @modifes this
	 * 
	 * @param netGain The net gain of the portfolio
	 * 
	 * @return true if successful, otherwise false
	 */
	@Override
	public boolean setNetGain(double netGain) {
		
		this.netGain = netGain;
		
		return true;
	}

	/**
	 * Returns the name of the portfolio
	 * 
	 * @effects returns this.name
	 * 
	 * @return The portfolios name
	 */
	@Override
	public String GetName() {

		return name;
	}
}
