package tracker;

import gui.AddNewInterface;
import gui.AddStockGUI;
import gui.HomeGUIInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStockListener implements ActionListener {

	private HomeGUIInterface homeui;
	
	public AddStockListener(HomeGUIInterface homeui) {
		
		this.homeui = homeui;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		AddNewInterface ui = new AddStockGUI(homeui.getCurrentPortfolio());
	}	
}
