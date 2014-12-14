package tracker;

import gui.AddNewInterface;
import gui.AddPortfolioGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Tracker;

public class AddPortfolioListener implements ActionListener {
	
	private Tracker tracker;
	
	public AddPortfolioListener(Tracker tracker) {
		this.tracker = tracker;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		AddNewInterface ui = new AddPortfolioGUI(tracker);
	}	
}