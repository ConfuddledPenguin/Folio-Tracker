package gui;

import javax.swing.*;
import javax.swing.table.TableModel;

public class PortfolioTable extends JTable {
	
	
	public PortfolioTable(TableModel tm) {
		super(tm);
	}
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}

}
