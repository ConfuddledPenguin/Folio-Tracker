package tracker;

import gui.AddNewInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ui.close();
	}
}
