package tracker;

import gui.AddStockGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Portfolio;

class AddStockGUIListener implements ActionListener {

	private Portfolio portfolio;
	private AddStockGUI ui;
	
	public AddStockGUIListener(AddStockGUI ui, Portfolio portfolio) {
		
		this.portfolio = portfolio;
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		portfolio.newStock(ui.getTicker());
		ui.close();
		
	}

}
