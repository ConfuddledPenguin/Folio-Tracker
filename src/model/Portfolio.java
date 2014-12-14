package model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import quoteServer.NoSuchTickerException;

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
	 * @throws IOException Error communicating with server
	 * @throws NoSuchTickerException Ticker does not exist
	 */
	public Stock newStock(String ticker) throws NoSuchTickerException, IOException;
	
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
	public String getName();
	
	/**
	 * Saves the portfolio
	 * 
	 * @effects saves the portfolio to the file given
	 * 
	 * @param outputFile the file to save to
	 */
	public void savePortfolio(File outputFile);
	
	/**
	 * Returns whether the portfolio is saved or not
	 * 
	 * @effects returns true if this portfolio is saved
	 * false otherwise.
	 * 
	 * @return true if saved, false otherwise;
	 */
	public Boolean isSaved();
}
