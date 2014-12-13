package gui;

import model.Portfolio;
import model.Stock;

public interface View {

	/**
	 * Shows the Home userinterface
	 */
	public void showHomeGUI();
			
	public void showError();
	
	public boolean showDeleteStockGUI();
	
	public boolean showDeletePortfolioGUI();
	
	public void showAddStockGUI(Portfolio portfolio);
	
	public void showAddPortfolio();
	
	public void showAddShareGUI();
	
	public void showTickerDisplayGUI();
	
	public void showBuySharesGUI();
	
	public void showSellSharesGUI();
	
	public Portfolio getCurrentPortfolio();
	
	public Stock getCurrentStock();
}
