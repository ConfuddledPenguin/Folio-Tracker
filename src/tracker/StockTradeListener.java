package tracker;

import gui.StockTradeGUIInterface;
import gui.buySharesGUI;
import gui.sellShareGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Stock;

public class StockTradeListener implements ActionListener{

	private Stock stock;
	
	public StockTradeListener(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton){
			if((((JButton) e.getSource()).getText().equals("Buy Shares"))){
				StockTradeGUIInterface ui = new buySharesGUI(stock);
			}else if((((JButton) e.getSource()).getText().equals("Sell Shares"))){
				StockTradeGUIInterface ui = new sellShareGUI(stock);
			}
		}
	}	
}
