package tracker;

import gui.ConfirmationInterface;
import gui.HomeGUIInterface;
import gui.confirmationGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import model.*;

public class CloseFolioListener implements ActionListener{

	private HomeGUIInterface ui;
	private Tracker tracker;
	ConfirmationInterface confirmui = null;
	
	public CloseFolioListener(HomeGUIInterface ui, Tracker tracker) {
		this.ui = ui;
		this.tracker = tracker;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source = "";
		Portfolio portfolio = ui.getCurrentPortfolio();
		
		if(portfolio == null){
			return;
		}
		
		if(e.getSource() instanceof JMenuItem){
			source = ((JMenuItem) e.getSource()).getText();
		}else if(e.getSource() instanceof JButton){
			source = ((JButton) e.getSource()).getText();
		}
		
		if( source.equals("Close Folio")){
			if(portfolio.isSaved()){
				tracker.deletePortfolio(portfolio);
			}else{
				confirmui = new confirmationGUI("Warning: Portfolio " + portfolio.getName() + " is not saved. Are you sure you wish to close it?", this);
			}
		}else if(source.equals("Yes")){
			System.out.println("close");
			tracker.getPortfolios();
			tracker.deletePortfolio(portfolio);
			confirmui.close();
		}else{
			confirmui.close();
		}
	}

}
