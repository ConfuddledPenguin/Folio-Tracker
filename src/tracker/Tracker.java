package tracker;

import java.io.IOException;

import quoteServer.IQuote;
import quoteServer.MethodException;
import quoteServer.NoSuchTickerException;
import quoteServer.Quote;
import quoteServer.WebsiteDataException;
import model.*;

public class Tracker {
	
	Model model;
	
	public Tracker(){
		
		model = new ModelImp();
		//create new gui passing it this and the model
		
		
		//Calling example code
		addPortfolio();
		ModelUpdater mu = new ModelUpdater(model);
		
		while(true){
			try {
				Thread.sleep(Driver.DEFUALT_REFREASH_RATE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mu.update();
		}
	}
	
	/*--------------------------------------------------------------
	 * Examples to keep my head straight
	 */
	
	/**
	 * An example of how to add a portfolio to the model
	 * and how to manipulate it
	 */
	public void addPortfolio(){
		
		model.createPortfolio("Example");
		Portfolio p = model.getPortfolios().get(0); // we know there is only one
		
		//add a new stock
		addStock(p);
		
	}
	
	/**
	 * An example of how to add a stock to a portfolio
	 * and how to manipulate it
	 * 
	 * @param p the portfolio we are to add a stock to
	 */
	public void addStock(Portfolio p){
		
		//The stock info
		//The ticker
		String ticker = "MS";
		//Get rest of info from quoter
		IQuote quoter = new Quote(Driver.USE_PROXY);
		String name = "";
		String exchange = "";
		double currentValue = 0;
		try {
			quoter.setValues(ticker);
			name = quoter.getName();
			exchange = quoter.getExchange();
			currentValue = quoter.getLatest();
		} catch (IOException | WebsiteDataException | NoSuchTickerException
				| MethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//finally create new stock
		p.newStock(ticker, name, exchange, currentValue);
		
		//fetch it back
		Stock s = p.getStocks().get(0);
		
		//update either the whole model, the portfolio or the stock
		ModelUpdater mu = new ModelUpdater(model);
		mu.update();
//		mu.updatePortfolio(p);
//		mu.updateStock(s);
		
		//Add some shares
		addShares(s);
	}
	
	/**
	 * Example of how to add shares
	 * 
	 * @param s stock shares are to be added to
	 */
	public void addShares(Stock s){
		
		int noShares = 12;
		double initialValue = 23.89;
		
		s.addShares(noShares, initialValue);
	}
}
