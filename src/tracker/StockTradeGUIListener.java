package tracker;

import gui.StockTradeGUIInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.CantPurchaseMoreThanAvailableException;
import model.CantRemoveMoreThanOwnedException;
import model.Stock;

public class StockTradeGUIListener implements ActionListener {

	private Stock stock;
	private StockTradeGUIInterface ui;
	
	public StockTradeGUIListener(Stock stock, StockTradeGUIInterface ui) {
		this.stock = stock;
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton){
			if((((JButton) e.getSource()).getText().equals("Buy"))){
				try {
					stock.addShares(ui.amount());
				} catch (CantPurchaseMoreThanAvailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ui.close();
			}else if((((JButton) e.getSource()).getText().equals("Sell"))){
				try {
					stock.removeShares(ui.amount());
				} catch (CantRemoveMoreThanOwnedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ui.close();
			}
		}
	}

}
