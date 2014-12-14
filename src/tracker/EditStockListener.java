package tracker;

import gui.HomeGUIInterface;
import gui.TickerDisplayGUI;
import gui.TickerDisplayGUIInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Stock;

public class EditStockListener implements ActionListener, MouseListener{

	private HomeGUIInterface ui;
	
	public EditStockListener(HomeGUIInterface ui) {
		this.ui = ui;
	}
	
	private void handleEvent(){
		
		Stock s = ui.getCurrentStock();
		
		if(s != null){
			TickerDisplayGUIInterface tickerUI = new TickerDisplayGUI(s);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		handleEvent();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getClickCount() == 2){
			handleEvent();
		}
	}
	
	/*
	 * Below are methods we have to have since this is a MouseListener
	 * The are not used for anything
	 */

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
