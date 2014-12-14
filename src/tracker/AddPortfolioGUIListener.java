package tracker;

import gui.AddNewInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Tracker;

public class AddPortfolioGUIListener implements ActionListener {

	private Tracker tracker;
	private AddNewInterface ui;
	
	public AddPortfolioGUIListener(AddNewInterface ui, Tracker tracker) {
		
		this.tracker = tracker;
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name = ui.getInfo();
		
		if(name.length() == 0){
			//TODO throw error
			ui.close();
			new AddPortfolioListener(tracker).actionPerformed(new ActionEvent(this, 0, ""));
		}else{
			tracker.createPortfolio(name);
			ui.close();
		}
	}
}
