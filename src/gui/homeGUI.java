package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.*;
import tracker.*;

public class homeGUI implements HomeGUIInterface, Observer{

	
	//This frame in which we are drawing things
	private JFrame frame;
	private JTabbedPane tabs;
	
	//The Tracker of folios
	private Tracker tracker;
	
	private List<JTable> tables = new ArrayList<JTable>(); 
	
	private boolean portfoliosPresent = false;
	
	private ActionListener addStockListner = new AddStockListener(this);
	private ActionListener portfolioListener;
	private ActionListener setRefreshRateListener;
	private ActionListener EditStockListener = new EditStockListener(this);
	private ActionListener fileman;
	private ActionListener closePortfolio;
	private ActionListener removeStock;
	
	/**
	 * Constructor for the UI. This creates the initial view
	 * 
	 * @param tracker the model
	 */
	public homeGUI(Tracker tracker){
		
		this.tracker = tracker;
		tracker.addObserver(this);
		
		//create actionListener for the future
		portfolioListener = new AddPortfolioListener(tracker);
		setRefreshRateListener = new SetRefreshRateListener(tracker);
		fileman = new PortfolioFileManagementListener(this, tracker);
		closePortfolio = new CloseFolioListener(this, tracker);
		removeStock = new RemoveStockListener(this);
		
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
	}
	
	/**
	 * Build the Menu bar
	 */
	public void buildMenu(){
		
		JMenuBar menus = new JMenuBar();
		
		JMenu file = new JMenu("File");
		
		JMenuItem newFolio = new JMenuItem("Create Folio");
		newFolio.addActionListener(portfolioListener);
		file.add(newFolio);
		
		JMenuItem loadFolio = new JMenuItem("Load Folio");
		loadFolio.addActionListener(fileman);
		file.add(loadFolio);
		
		JMenuItem saveFolio = new JMenuItem("Save Folio");
		saveFolio.addActionListener(fileman);
		file.add(saveFolio);
		
		menus.add(file);
		
		JMenu folio = new JMenu("Folio");
		JMenuItem closeFolio = new JMenuItem("Close Folio");
		closeFolio.addActionListener(closePortfolio);
		
		
		JMenuItem addStock = new JMenuItem("Add Stock");
		addStock.addActionListener(addStockListner);
		
		folio.add(closeFolio);
		folio.add(addStock);
		
		menus.add(folio);
		
		JMenu stock = new JMenu("Stock");
		JMenuItem editStock = new JMenuItem("Edit");
		editStock.addActionListener(EditStockListener);
		stock.add(editStock);
		
		JMenuItem deleteStock = new JMenuItem("Remove Stock");
		deleteStock.addActionListener(removeStock);
		stock.add(deleteStock);
		
		menus.add(stock);
		
		
		JMenu options = new JMenu("Options");
		JMenuItem setRefreash = new JMenuItem("Set Refreash Rate");
		setRefreash.addActionListener(setRefreshRateListener);
		options.add(setRefreash);
		
		menus.add(options);
		
		frame.setJMenuBar(menus);
	}
	
	/**
	 * Build the portfolio view
	 */
	public void buildPortfolio(){
		
		tabs = new JTabbedPane();
		
		addPortfolios(tabs);
		
		if(tabs.getTabCount()==0){
			JPanel addPortfolioPanel = new JPanel();
			addPortfolioPanel.setBorder(new EmptyBorder(0,190,0,0));
			
			addPortfolioPanel.setLayout(new BorderLayout());
			
			JLabel addPortfolioLabel = new JLabel("Please add a Portfolio");
			addPortfolioLabel.setFont(new Font("Serif", Font.BOLD, 25));
			
			addPortfolioPanel.add(addPortfolioLabel);
			
			
			frame.add(addPortfolioPanel, BorderLayout.CENTER);
			
			
			tabs.addTab("Default", addPortfolioPanel);
			
			frame.add(tabs);
		}
	}
	
	private void rebuildPortfolio(){
		
		portfoliosPresent = false; 
		int index = tabs.getSelectedIndex();
		int noPortfolios = tables.size();
		tabs.removeAll();
		tables.removeAll(tables);
		addPortfolios(tabs);
		if(tables.size() == noPortfolios)
			tabs.setSelectedIndex(index);
	}
	
	private void addPortfolios(JTabbedPane tabs){
		for(Portfolio p: tracker.getPortfolios()){
			
			portfoliosPresent = true;
			
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

		JTable table = new PortfolioTable(buildTableModel(p, model));
		table.addMouseListener((MouseListener)EditStockListener);
		tables.add(table);
		
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
	
	public Stock getCurrentStock(){
		
		Portfolio portfolio = getCurrentPortfolio();
		
		if (portfolio == null){
			return null;
		}
		
		int index = tables.get(tabs.getSelectedIndex()).getSelectedRow();
		
		Stock s;
		if(index >=0){
			s = portfolio.getStocks().get(index);
		}else
			s = null;
		
		return s;
	}
	
	public Portfolio getCurrentPortfolio(){
		
		if(tabs.getSelectedIndex()  < 0 || !portfoliosPresent){
			return null;
		}
		return tracker.getPortfolios().get(tabs.getSelectedIndex());
	}

	@Override
	public void update(Observable o, Object arg) {
		
		System.out.println("repaint");
		rebuildPortfolio();	
		frame.repaint();
	}
}
