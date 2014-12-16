package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import quoteServer.NoSuchTickerException;

/**
 * A implementation of the portfolio interface
 * 
 * A portfolio stores information about a number of stocks
 * 
 * @author Tom Maxwell
 *
 */
class PortfolioImp implements Portfolio {
	
	private TrackerImp tracker;
	
	//The name of the portfolio
	private String name;
	private Boolean saved = false;
	//The stocks held in this portfolio
	List<StockImp> stocks;
	
	/**
	 * The constructor for the PortfolioImp
	 * 
	 * @effects creates a portfolio object
	 * @modifies this
	 * 
	 * @param name The name for the portfolio
	 */
	public PortfolioImp(String name, TrackerImp tracker) {
		  
		this.name = name;
		assert name!=null;
		assert(name.equals(name));
		this.tracker = tracker;
		assert tracker!=null;
		assert(tracker.equals(tracker));
		  
		stocks = new ArrayList<StockImp>();
	}


	/**
	 * Creates and add a new stock to this portfolio
	 * 
	 * @effects Creates a Stock object
	 * @modifies this
	 * 
	 * @param ticker The ticker of the stock
	 * 
	 * @return The new stock object
	 * @throws IOException Error communicating with server
	 * @throws NoSuchTickerException The ticker does not exist
	 * @throws AlreadyExistsException If the stock already exists
	 */
	@Override
	public synchronized Stock newStock(String ticker) throws NoSuchTickerException, IOException, AlreadyExistsException {
		
		StockImp s = null;
		assert ticker!=null;
		
		for(Stock stock: stocks){
			assert !stocks.isEmpty():"There are no stocks in stock array";
			assert stock!=null;
			if(stock.getTicker().equals(ticker)){
				throw new AlreadyExistsException("Stock already exists in portfolio");
			}
		}
		
		try{
			s = new StockImp(ticker, tracker);
		}catch (IOException e){
			s = new StockImp(ticker, tracker); // try again, if we fail again throw exception to caller
		}
		
		stocks.add(s);
		assert(stocks.contains(s)):"Stock" + s + " was not added.";
		
		saved = false;
		//assert(saved = false):"saved is true!";
		tracker.modelChanged();
		
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
	public synchronized boolean deleteStock(Object o) {
		
		if ( o instanceof Stock && o != null){
			assert o!=null;
			saved=false;
			tracker.modelChanged();
			return stocks.remove( (Stock) o);
			
			
			
		}
		
		return false;
	}
	
	/**
	 * Saves the portfolio
	 * 
	 * @effects saves the portfolio to the file given
	 * 
	 * @param outputFile the file to save to
	 */
	public void savePortfolio(File outputFile) {
		
		PortfolioSaver ps = new PortfolioSaver();
		
		ps.savePortfolio(this, outputFile);
		
		saved = true;
		
	}
	
	/**
	 * Returns whether the portfolio is saved or not
	 * 
	 * @effects returns true if this portfolio is saved
	 * false otherwise.
	 * 
	 * @return true if saved, false otherwise;
	 */
	public Boolean isSaved(){
		return saved;
	}
	
	/*-----------------------------------------------------------------------
	 * Below lies the land of the getters and setters. It is better not to
	 * voyage very deep into this land
	 */

	/**
	 * Returns a List of the stocks
	 * 
	 * @effects returns this.stock
	 * 
	 * @return The stock
	 */
	@Override
	public synchronized List<Stock> getStocks() {
		assert stocks!=null:"There are no stocks to view!";
		return new ArrayList<Stock>(stocks);
		
		
	}
	
	/**
	 * Returns a List of the stockImps
	 * 
	 * @effects returns this.stockImps
	 * 
	 * @return The stockImps
	 */
	synchronized List<StockImp> getStockImps(){
		
		return new ArrayList<StockImp>(stocks);	
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
		
		double totalValue = 0;
		assert (totalValue == 0): "Inital total value has not been set to 0";	
		
		for(StockImp s: stocks){
			assert !stocks.isEmpty():"There are no stocks in stock array";
			totalValue += s.getHoldingValue();
		}
		
		return totalValue;
	
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
		
		double netGain = 0;
		
		
		for(StockImp s: stocks){
			
			assert !stocks.isEmpty():"There are no stocks in stock array";
			netGain += s.getNetGain();
		}
		
		return netGain;
	}

	/**
	 * Returns the name of the portfolio
	 * 
	 * @effects returns this.name
	 * 
	 * @return The portfolios name
	 */
	@Override
	public String getName() {

		return name;
		
	}
	
	/*-----------------------------------------------------------------------
	 * Package methods
	 */
	
	/**
	 * Returns the number of stock held within this portfolio
	 * 
	 * @effects returns the number of stocks within this
	 * 
	 * @return the number of stocks
	 */
	int noStocks(){
		
		assert !stocks.isEmpty(): "Stocks is empty - 0 stocks";
		return stocks.size();
		
	}
	
	/**
	 * Updates all the stocks within this portfolio and
	 * then updates the portfolio to reflect the changes.
	 */
	synchronized void update(){
		
		for(StockImp s: stocks){
			assert stocks!=null: "Stock array is empty";
			s.update();
		}
	}
}
