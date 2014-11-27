package model;

import java.util.List;

public interface Portfolio {
	
	public boolean newStock(String ticker, int numberHeld, double price);
	public boolean deleteStock(Stock s);

	public List<Stock> getStocks();
	
	public double getTotalValue();
	public boolean setTotalValue();
	
	public double getNetGain();
	public boolean setNetGain();
}
