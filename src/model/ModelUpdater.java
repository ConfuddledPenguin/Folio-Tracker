package model;

import java.io.IOException;
import java.util.List;

import quoteServer.*;
import tracker.Driver;

public class ModelUpdater implements Runnable{
	
	ModelImp model;
	IQuote quoter;
	
	public ModelUpdater(Model model){
		
		
		
		if(model instanceof ModelImp){
		
			this.model = (ModelImp) model;
			
			quoter = new Quote(Driver.USE_PROXY);
		}
	}
	
	public void run(){
		update();
	}
	
	public void update(){
		
		List<PortfolioImp> folios = model.getPortfolioImps();
		
		//update every portfolio in the model
		for(PortfolioImp p: folios){
			
			updatePortfolio(p);
		}
	}
	
	public void updatePortfolio(PortfolioImp p){
		
		List<StockImp> stocks =  p.getStockImps();
		
		//update every stock
		for(StockImp s: stocks){
			
			updateStock(s);
		}
	}
	
	public void updateStock(StockImp s){
		
		String ticker = s.getTicker();
		
		//Get Stock info
		try {
			quoter.setValues(ticker);				//give quoter stock ticker
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
		
		//update the stock
		try {
			s.setCurrentValue(quoter.getLatest());  //Update latest price
			s.setOpeningPrice(quoter.getOpen());	//update opening price
			s.setClosingPrice(quoter.getClose());	//update close price
			s.setDailyChange(quoter.getChange());	//update Daily change
			s.setVolume(quoter.getVolume());		//update volume
			s.setDailyMax(quoter.getRangeMax());	//update daily max
			s.setDailyMin(quoter.getRangeMin());	//update daily min
		} catch (MethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//update latest price
	}
}
