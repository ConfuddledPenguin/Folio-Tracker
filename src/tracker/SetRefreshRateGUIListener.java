package tracker;

import gui.ErrorInterface;
import gui.SetRefreshRateInterface;
import gui.errorGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.IllegalRefreashRateException;
import model.Tracker;

public class SetRefreshRateGUIListener implements ActionListener {

	private Tracker tracker;
	private SetRefreshRateInterface ui;
	
	public SetRefreshRateGUIListener(SetRefreshRateInterface ui, Tracker tracker) {
		
		this.tracker = tracker;
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int enteredRate = Integer.parseInt(ui.getRefreshRate());
		
		long rateInMS = enteredRate * 1000;
		
		System.out.println(rateInMS);
		
		try {
			tracker.setRefreshRate(rateInMS);
		} catch (IllegalRefreashRateException e1) {
			ErrorInterface errorui = new errorGUI(e1.getMessage());
		}
		
		ui.close();
	}

	
}
