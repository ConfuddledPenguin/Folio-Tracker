package tracker;

import gui.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import model.*;

public class AddPortfolioListener implements ActionListener {

	private homeGUI ui;
	private Tracker tracker;
	
	public AddPortfolioListener(homeGUI ui, Tracker tracker) {
		
		this.ui = ui;		
		this.tracker = tracker;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		new AddPortfolioGUI(tracker);

	}

	
}
