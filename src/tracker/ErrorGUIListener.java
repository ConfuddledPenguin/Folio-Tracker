package tracker;

import gui.ErrorInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorGUIListener implements ActionListener{

	private ErrorInterface ui;
	
	public ErrorGUIListener(ErrorInterface ui) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ui.close();
	}
}
