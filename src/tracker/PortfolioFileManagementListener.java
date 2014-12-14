package tracker;

import gui.HomeGUIInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JMenuItem;

import model.Portfolio;
import model.Tracker;

public class PortfolioFileManagementListener implements ActionListener{

	private HomeGUIInterface ui;
	private Tracker tracker;
	
	public PortfolioFileManagementListener(HomeGUIInterface ui, Tracker tracker) {
		this.tracker = tracker;
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JMenuItem source = (JMenuItem) e.getSource();
		
		if(source.getText().equals("Save Folio")){
			//TODO
			Portfolio portfolio = ui.getCurrentPortfolio();
			File file = new File(portfolio.getName());
			portfolio.savePortfolio(file);
		}else if(source.getText().equals("Load Portfolio")){
			//TODO
			System.out.println("Imagine it printing out");
		}
	}

	
}
