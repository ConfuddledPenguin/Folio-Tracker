package tracker;

import java.io.IOException;

import quoteServer.NoSuchTickerException;
import gui.HomeGUIInterface;
import gui.homeGUI;
import model.AlreadyExistsException;
import model.Portfolio;
import model.Stock;
import model.Tracker;
import model.TrackerImp;

public class Controller{
	
	private Tracker tracker;
	private HomeGUIInterface home;
	
	public Controller(){
		
		//create new model
		tracker = new TrackerImp();
		
		//Calling example code
		//remove this at some point
		addPortfolio();	
		
		//create new gui passing it this and the model
		home = new homeGUI(tracker);
	}
	
	/*--------------------------------------------------------------
	 * Examples to keep my head straight
	 */
	
	/**
	 * An example of how to add a portfolio to the model
	 * and how to manipulate it
	 */
	private void addPortfolio(){
		
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
	private void addStock(Portfolio p){
		
		Stock s = null;
		try {
			s = p.newStock("MS");
		} catch (NoSuchTickerException e) {
			System.err.println("Error ticker does not exist");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error talking to server");
			e.printStackTrace();
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			s = p.newStock("RBS.l");
		} catch (NoSuchTickerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
