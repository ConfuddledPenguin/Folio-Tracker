package tracker;

import gui.ConfirmationInterface;
import gui.HomeGUIInterface;
import gui.confirmationGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import model.*;

public class RemoveStockListener implements ActionListener{

	private HomeGUIInterface ui;
	ConfirmationInterface confirmui = null;
	
	public RemoveStockListener(HomeGUIInterface ui) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source = "";
		Portfolio portfolio = ui.getCurrentPortfolio();
		Stock stock = ui.getCurrentStock();
		
		if(stock == null){
			return;
		}
		
		if(e.getSource() instanceof JMenuItem){
			source = ((JMenuItem) e.getSource()).getText();
		}else if(e.getSource() instanceof JButton){
			source = ((JButton) e.getSource()).getText();
		}
		
		if( source.equals("Remove Stock")){
			if(portfolio.isSaved()){
				portfolio.deleteStock(stock);
			}else{
				confirmui = new confirmationGUI("Warning: Once the stock " + stock.getName() + " is deleted it is gone forever", this);
			}
		}else if(source.equals("Yes")){
			System.out.println("close");
			portfolio.deleteStock(stock);
			confirmui.close();
		}
	}

}
