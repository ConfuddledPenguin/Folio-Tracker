package model;

import java.util.List;

/**
 * An interface for the Portfolio.
 *
 */
public interface Portfolio {

	
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
	public Stock newStock(String ticker, String name, String exchange, double currentValue);
	
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
	public boolean deleteStock(Object o);

	/**
	 * Returns the stocks held in this portfolio
	 * 
	 * @effects Returns this.stocks
	 * 
	 * @return A List<Stock> of the stocks
	 */
	public List<Stock> getStocks();
	
	/**
	 * Returns the total value of the portfolio
	 * 
	 * @effects returns this.totalValue
	 * 
	 * @return The total Value of the stock
	 */
	public double getTotalValue();
	
	/**
	 * returns the Net gain in this portfolio
	 * 
	 * @effects returns this.netGain
	 * 
	 * @return the net gain
	 */
	public double getNetGain();
	
	/**
	 * Returns the name of the portfolio
	 * 
	 * @effects returns this.name
	 * 
	 * @return The portfolios name
	 */
	public String GetName();
}
