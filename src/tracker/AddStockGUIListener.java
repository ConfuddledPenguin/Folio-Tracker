package tracker;

import gui.AddNewInterface;
import gui.ErrorInterface;
import gui.errorGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.AlreadyExistsException;
import model.Portfolio;
import quoteServer.NoSuchTickerException;

public class AddStockGUIListener implements ActionListener {

	private Portfolio portfolio;
	private AddNewInterface ui;
	
	public AddStockGUIListener(AddNewInterface ui, Portfolio portfolio) {
		
		this.portfolio = portfolio;
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			portfolio.newStock(ui.getInfo());
		} catch (NoSuchTickerException e1) {
			ErrorInterface ui = new errorGUI(e1.getMessage());
		} catch (IOException e1) {
			 ErrorInterface ui = new errorGUI(e1.getMessage());
		} catch (AlreadyExistsException e1) {
			ErrorInterface ui = new errorGUI(e1.getMessage());
		}
		ui.close();
	}
}
