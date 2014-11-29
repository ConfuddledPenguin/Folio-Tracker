package model;

import java.util.ArrayList;
import java.util.List;

class PortfolioImp implements Portfolio {
	
	//The name of the portfolio
	private String name;
	//The total value of the portfolio
	private double totalValue = 0;
	//The net gain of this portfolio
	private double netGain = 0;
	//The stocks held in this portfolio
	List<Stock> stocks;
	
	public PortfolioImp(String name) {
		  this.name = name;
		  
		  stocks = new ArrayList<Stock>();
	}

	@Override
	public boolean newStock(String ticker, String name, double currentValue) {
		
		Stock s = new StockImp(ticker, name, currentValue);
		
		return stocks.add(s);
	}

	@Override
	public boolean deleteStock(Object o) {
		
		if ( o instanceof Stock){
			
			return stocks.remove( (Stock) o); 
		}
		
		return false;
	}

	@Override
	public List<Stock> getStocks() {
		
		return new ArrayList<Stock>(stocks);
	}

	@Override
	public double getTotalValue() {
		
		return totalValue;
	}

	@Override
	public boolean setTotalValue(double totalValue) {
		
		this.totalValue = totalValue;
		
		return true;
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
	public String GetName() {

		return name;
	}

}
