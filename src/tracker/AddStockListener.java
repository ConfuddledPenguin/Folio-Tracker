package tracker;

import gui.AddStockGUI;
import gui.homeGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import model.*;

public class AddStockListener implements ActionListener {

	private homeGUI ui;
	
	public AddStockListener(homeGUI ui, Tracker tracker) {
		
		this.ui = ui;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		new AddStockGUI(ui.getCurrentPortfolio());

	}

	
}
