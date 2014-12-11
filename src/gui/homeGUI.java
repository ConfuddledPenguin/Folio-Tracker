package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import tracker.*;
import model.*;


public class homeGUI {

	//This frame in which we are drawing things
	private JFrame frame;
	private JTabbedPane tabs;
	
	private List<DefaultTableModel> models;
	
	//The Tracker of folios
	private Tracker tracker;
	
	private Portfolio currentPortfolio;
	
	/**
	 * Constructor for the UI. This creates the initial view
	 * 
	 * @param tracker the model
	 */
	public homeGUI(Tracker tracker){
		
		this.tracker = tracker;
		models = new ArrayList<DefaultTableModel>();
		
		frame = new JFrame("Folio Tracker");
		// frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		buildMenu();
		buildPortfolio();
		
		frame.pack();
		
		// centre the GUI according to the screen size
		frame.setSize(650, 600);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2
				- frame.getHeight() / 2);
		
		frame.setVisible(true);
		frame.repaint();
		
		
		//THIS WILL BE REMOVED
		//TODO REMOVE once auto refreash is done
		while(true){
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			update();
		}
	}
	
	/**
	 * Build the Menu bar
	 */
	public void buildMenu(){
		
		JMenuBar menus = new JMenuBar();
		
		JMenu file = new JMenu("File");
		JMenuItem newFolio = new JMenuItem("Create Folio");
		newFolio.addActionListener(new AddPortfolioListener(this, tracker));
		file.add(newFolio);
		
		menus.add(file);
		
		JMenu folio = new JMenu("Folio");
		JMenuItem closeFolio = new JMenuItem("Close Folio");
		JMenuItem deleteFolio = new JMenuItem("Delete Folio");
		JMenuItem addStock = new JMenuItem("Add Stock");
		
		addStock.addActionListener(new AddStockListener(this, tracker));
		
		folio.add(closeFolio);
		folio.add(deleteFolio);
		folio.add(addStock);
		
		menus.add(folio);
		frame.setJMenuBar(menus);
	}
	
	/**
	 * Build the portfolio view
	 */
	public void buildPortfolio(){
		
		tabs = new JTabbedPane();
		
		addPortfolios();
	}
	
	private void rebuildPortfolio(){
		
		tabs.removeAll();
		addPortfolios();
	}
	
	private void addPortfolios(){
		for(Portfolio p: tracker.getPortfolios()){
			
			JPanel portfolioPanel = new JPanel();
			
			portfolioPanel.setLayout(new BorderLayout());
			
			//Add tabs
			
			portfolioPanel.add(new JScrollPane(createTickerTable(p)));
			
			tabs.addTab(p.getName(), portfolioPanel);
			
			frame.add(tabs);
		
			//Add value display
			
			JPanel value = new JPanel();
			
			value.setLayout(new BorderLayout());
			
			value.add(new JLabel("Total value: $" + p.getTotalValue()), BorderLayout.WEST);
			value.add(new JLabel("NetGain: $" + p.getNetGain()), BorderLayout.EAST);
			
			portfolioPanel.add(value, BorderLayout.SOUTH);
		}
	}
	
	/**
	 * Create the ticker table
	 * 
	 * @return
	 */
	public JTable createTickerTable(Portfolio p){
		
		DefaultTableModel model = new DefaultTableModel();
		models.add(model);
		JTable table = new PortfolioTable(buildTableModel(p, model));
		
		table.setBackground(Color.WHITE);
		
		return table;
	}
	
	
	
	private TableModel buildTableModel(Portfolio p, DefaultTableModel model){
		
		String[] columnNames = { "Ticker Symbol", "Stock Name", "Number Of Shares",
				"Current Price", "Value Of Holding" };
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		for (int i = 0; i < p.getStocks().size(); i++ ){
			
			Stock s = p.getStocks().get(i);
			
			Vector<Object> v = new Vector<Object>();
			
			v.addElement(s.getTicker());
			v.addElement(s.getName());
			v.addElement(s.getNumberOfShares());
			v.addElement(s.getCurrentValue());
			v.addElement(s.getHoldingValue());
			
			data.addElement(v);
		}
		
		for (int i = 0; i < columnNames.length; i++) {
			model.addColumn(columnNames[i]);
		}
		
		for(Vector<Object> d: data){
			model.addRow(d);
		}
		
		return model;
	}
	
	public Portfolio getCurrentPortfolio(){
		
		return tracker.getPortfolios().get(tabs.getSelectedIndex());
	}
	
	public void update(){
		
		System.out.println("repaint");
		int index = tabs.getSelectedIndex();
		rebuildPortfolio();
		tabs.setSelectedIndex(index);		
		frame.repaint();
	}
}
