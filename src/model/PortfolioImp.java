package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import quoteServer.IQuote;
import quoteServer.MethodException;
import quoteServer.NoSuchTickerException;
import quoteServer.Quote;
import quoteServer.WebsiteDataException;

/**
 * A implementation of the portfolio interface
 *
 */
class PortfolioImp implements Portfolio, Observer {
	
	//The name of the portfolio
	private String name;
	//The netGain of this portfolio
	private volatile double netGain =0;
	//The total value of this portfolio
	private volatile double totalValue =0;
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
	public PortfolioImp(String name) {
		  this.name = name;
		  
		  stocks = new ArrayList<StockImp>();
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
	public synchronized Stock newStock(String ticker) {
		
		IQuote quoter = new Quote(TrackerImp.USE_PROXY);
		String name = "";
		String exchange = "";
		double currentValue = 0;
		try {
			quoter.setValues(ticker);
			name = quoter.getName();
			exchange = quoter.getExchange();
			currentValue = quoter.getLatest();
		} catch (IOException | WebsiteDataException
				| MethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NoSuchTickerException e){
			System.out.println("Stock does not exist");
		}
		
		StockImp s = new StockImp(ticker, name, exchange, currentValue);
		s.addObserver(this);
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
	public synchronized boolean deleteStock(Object o) {
		
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
	 * Returns a List of the stocks
	 * 
	 * @effects returns this.stock
	 * 
	 * @return The stock
	 */
	@Override
	public synchronized List<Stock> getStocks() {
		
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
	public synchronized double getTotalValue() {
		
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
	public synchronized double getNetGain() {
		
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

	/**
	 * The update method overridden from {@link Observer}.
	 * 
	 * This method is called when ever a stock contained in this 
	 * portfolio is modified. It updates this portfolio to 
	 * reflect any changes
	 * 
	 * @note This really shouldn't be public since it will only
	 * ever be called by things within the same package as it and
	 * therefore should be package protected. It is public since
	 * we are overriding the {@link Observer} interface 
	 * 
	 * @effects updates this
	 * @modifies this
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		calculateNetGain();
		calculateTotalValue();
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
		
		return stocks.size();
	}
	
	/**
	 * Updates all the stocks within this portfolio and
	 * then updates the portfolio to reflect the changes.
	 */
	synchronized void update(){
		
		for(StockImp s: stocks){
			
			s.update();
		}
		
		calculateNetGain();
		calculateTotalValue();
	}
	
	/*-----------------------------------------------------------------------
	 * Private methods
	 */
	
	/**
	 * Calclate the net gain within this portfolio
	 * 
	 * @effects this.netGain = netGain of all stocks
	 * @modifies this
	 */
	private void calculateNetGain(){

		netGain = 0;
		
		for(StockImp s: stocks){
			
			netGain += s.getNetGain();
		}
	}
	
	/**
	 * Calclate the totalValue of this portfolio
	 * 
	 * @effects this.totalValue = totalValue of all stocks
	 * @modifies this
	 */
	private void calculateTotalValue() {

		totalValue = 0;
		
		for(StockImp s: stocks){
			
			totalValue += s.getHoldingValue();
		}
	}
}
