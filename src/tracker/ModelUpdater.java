package tracker;

import java.io.IOException;
import java.util.List;

import quoteServer.IQuote;
import quoteServer.MethodException;
import quoteServer.NoSuchTickerException;
import quoteServer.Quote;
import quoteServer.WebsiteDataException;
import model.*;

public class ModelUpdater {
	
	Model model;
	IQuote quoter;
	
	public ModelUpdater(Model model){
		
		this.model = model;
		
		quoter = new Quote(Driver.USE_PROXY);
	}
	
	public void update(){
		
		List<Portfolio> folios = model.getPortfolios();
		
		//update every portfolio in the model
		for(Portfolio p: folios){
			
			updatePortfolio(p);
			
		}
	}
	
	public void updatePortfolio(Portfolio p){
		
		List<Stock> stocks = p.getStocks();
		
		//update every stock
		for(Stock s: stocks){
			
			updateStock(s);
			
		}
	}
	
	public void updateStock(Stock s){
		
		String ticker = s.getTicker();
		
		try {
			quoter.setValues(ticker);				//give quoter stock ticker
			s.setCurrentValue(quoter.getLatest());	//update latest price
			s.setOpeningPrice(quoter.getOpen());	//update opening price
			s.setClosingPrice(quoter.getClose());	//update close price
			s.setDailyChange(quoter.getChange());	//update Daily change
			s.setVolume(quoter.getVolume());		//update volume
			s.setDailyMax(quoter.getRangeMax());	//update daily max
			s.setDailyMin(quoter.getRangeMin());	//update daily min
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebsiteDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchTickerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
