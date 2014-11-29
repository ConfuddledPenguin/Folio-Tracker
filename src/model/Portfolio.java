package model;

import java.util.List;

public interface Portfolio {
	
	public String GetName();
	
	public boolean newStock(String ticker, String name, double currentValue);
	public boolean deleteStock(Object o);

	public List<Stock> getStocks();
	
	public double getTotalValue();
	public boolean setTotalValue(double totalValue);
	
	public double getNetGain();
	public boolean setNetGain(double netGain);
}
