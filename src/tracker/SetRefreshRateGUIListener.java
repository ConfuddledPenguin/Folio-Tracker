package tracker;

import gui.SetRefreshRateInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.IllegalRefreashRate;
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
		} catch (IllegalRefreashRate e1) {
			// TODO display error
			ui.close();
			new SetRefreshRateListener(tracker).actionPerformed(new ActionEvent(this, 0, ""));
		}
		
		ui.close();
	}

	
}
