package tracker;

import gui.FileChooserGUI;
import gui.HomeGUIInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JMenuItem;

import model.Portfolio;
import model.Tracker;

public class PortfolioFileManagementListener implements ActionListener{

	private HomeGUIInterface ui;
	private Tracker tracker;
	
	public PortfolioFileManagementListener(HomeGUIInterface ui, Tracker tracker) {
		this.tracker = tracker;
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JMenuItem source = (JMenuItem) e.getSource();
		FileChooserGUI chooser = new FileChooserGUI();
		
		if(source.getText().equals("Save Folio")){
			
			Portfolio portfolio = ui.getCurrentPortfolio();
			
			if(portfolio == null){
				return;
			}
			
			File file = chooser.SaveFile();
			portfolio.savePortfolio(file);
		}else if(source.getText().equals("Load Folio")){
			File file = chooser.GetFile();
			tracker.loadPortfolio(file);
		}
	}

	
}
