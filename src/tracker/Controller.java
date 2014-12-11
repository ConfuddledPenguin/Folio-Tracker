package tracker;

import gui.View;
import gui.ViewImp;
import gui.homeGUI;
import model.Portfolio;
import model.Stock;
import model.Tracker;
import model.TrackerImp;

public class Controller {
	
	private Tracker tracker;
	private View view;
	
	public Controller(){
		
		//create new model
		tracker = new TrackerImp();
		
		//Calling example code
		addPortfolio();	
		
		//create new gui passing it this and the model
		view = new ViewImp(tracker);
		view.showHomeGUI();			
	}
	
	/*--------------------------------------------------------------
	 * Examples to keep my head straight
	 */
	
	/**
	 * An example of how to add a portfolio to the model
	 * and how to manipulate it
	 */
	public void addPortfolio(){
		
		tracker.createPortfolio("Example");
		Portfolio p = tracker.getPortfolios().get(0); // we know there is only one
		tracker.createPortfolio("2");
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
		
		Stock s = p.newStock("MS");
		
		s.addShares(2000, 12.0);
		s = p.newStock("RBS.l");
		s.addShares(3000, 18.00);
	}
}
