package tracker;

import gui.SetRefreshRateGUI;
import gui.SetRefreshRateInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Tracker;

public class SetRefreshRateListener implements ActionListener{

	private Tracker tracker;
	
	public SetRefreshRateListener(Tracker tracker) {
		
		this.tracker = tracker;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		SetRefreshRateInterface ui = new SetRefreshRateGUI(tracker);
	}

}
