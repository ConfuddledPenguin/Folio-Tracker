package gui;

import javax.swing.*;
import javax.swing.table.TableModel;

public class PortfolioTable extends JTable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2793630795098152789L;

	public PortfolioTable(TableModel tm) {
		super(tm);
	}
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}

}
