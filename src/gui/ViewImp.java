package gui;

import model.Tracker;

public class ViewImp implements View{

	private Tracker tracker;
	
	public ViewImp(Tracker tracker) {
		
		this.tracker = tracker;
	}

	@Override
	public void showHomeGUI() {
		
		new homeGUI(tracker);
	}

	@Override
	public void showError() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAddStockGUI() {
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
	public void showbuySharesGUI() {
		// TODO Auto-generated method stub
		
	}
	
	
}
