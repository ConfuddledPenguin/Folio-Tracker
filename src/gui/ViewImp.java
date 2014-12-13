package gui;

import java.util.Observable;
import java.util.Observer;

import model.Portfolio;
import model.Stock;
import model.Tracker;

public class ViewImp implements View, Observer{

	private Tracker tracker;	
	
	public ViewImp(Tracker tracker) {
		
		this.tracker = tracker;
		
		tracker.addObserver(this); 
	}

	@Override
	public void showHomeGUI() {
		
		new homeGUI(tracker, this);
	}

	@Override
	public void showError() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAddPortfolio() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAddShareGUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showTickerDisplayGUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showBuySharesGUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean showDeleteStockGUI() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean showDeletePortfolioGUI() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showSellSharesGUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAddStockGUI(Portfolio portfolio) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Portfolio getCurrentPortfolio() {
		//TODO
		
		return null;
	}

	@Override
	public Stock getCurrentStock() {
		//TODO
		
		return null;
	}
	
	/**
	 * Up dates the view
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		System.out.println("UDATE VIEW NOW");
		
	}	
}
