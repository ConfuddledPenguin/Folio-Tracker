package tracker;

import gui.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPortfolioListener implements ActionListener {

	private View ui;
	
	public AddPortfolioListener(View ui) {
		
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ui.showAddPortfolio();
	}	
}