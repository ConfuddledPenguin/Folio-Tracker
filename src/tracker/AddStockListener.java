package tracker;

import gui.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStockListener implements ActionListener {

	private View view;
	
	public AddStockListener(View view) {
		
		this.view = view;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		view.showAddStockGUI(view.getCurrentPortfolio());
	}

	
}
