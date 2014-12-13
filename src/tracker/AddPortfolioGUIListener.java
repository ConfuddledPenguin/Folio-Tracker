package tracker;

import gui.AddPortfolioGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Tracker;

class AddPortfolioGUIListener implements ActionListener {

	private Tracker tracker;
	private AddPortfolioGUI ui;
	
	public AddPortfolioGUIListener(AddPortfolioGUI ui, Tracker tracker) {
		
		this.tracker = tracker;
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		tracker.createPortfolio(ui.getName());
		ui.close();
	}
}
