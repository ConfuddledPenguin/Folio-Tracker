package tracker;

import gui.AddNewInterface;
import gui.ErrorInterface;
import gui.errorGUI;

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
			ErrorInterface errorui = new errorGUI("You must give the portfolio a name");
			ui.close();
		}else{
			tracker.createPortfolio(name);
			ui.close();
		}
	}
}
