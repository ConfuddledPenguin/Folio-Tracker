package tracker;

import gui.ErrorInterface;
import gui.FileChooserGUI;
import gui.FileChooserInterface;
import gui.HomeGUIInterface;
import gui.errorGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JMenuItem;

import model.FailedToLoadFileException;
import model.FailedToSaveFileException;
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
		FileChooserInterface chooser = new FileChooserGUI();
		
		if(source.getText().equals("Save Folio")){
			
			Portfolio portfolio = ui.getCurrentPortfolio();
			
			if(portfolio == null){
				return;
			}
			
			File file = chooser.SaveFile();
			try {
				portfolio.savePortfolio(file);
			} catch (FailedToSaveFileException e1) {
				ErrorInterface errorui = new errorGUI("Failed to save file");
			}
		}else if(source.getText().equals("Load Folio")){
			File file = chooser.GetFile();
			try {
				tracker.loadPortfolio(file);
			} catch (FailedToLoadFileException e1) {
				ErrorInterface errorui = new errorGUI("Failed to load file");
			}
		}
	}

	
}
