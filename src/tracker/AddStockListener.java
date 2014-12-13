package tracker;

import gui.AddStockGUI;
import gui.HomeGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStockListener implements ActionListener {

	private HomeGUI homeui;
	
	public AddStockListener(HomeGUI homeui) {
		
		this.homeui = homeui;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		new AddStockGUI(homeui.getCurrentPortfolio());
	}	
}
