package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class tickerDisplayGUI {
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel tickerPanel;
	private JPanel valuePanel;
	private JPanel gainPanel;
	private JMenuBar menus;
	private JMenu edit;
	private JMenuItem addShares;
	private JMenuItem sellShares;
	private JLabel tickerSymbol;
	private JLabel stockName;
	private JLabel currentValue;
	private JLabel dailyChange;
	private JLabel totalSpend;
	private JLabel totalGain;
	

	public static void main(String[] args) {

		new tickerDisplayGUI();
	}

	public tickerDisplayGUI() {
		makeFrame();
	}
	
	private void makeFrame(){
		// create a new frame
		frame = new JFrame("Editing Portfolio 'tickerName' for 'portfolioName'");
		frame.setSize(500, 300);
		// frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		// centre the GUI according to the screen size
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2
				- frame.getHeight() / 2);
		createMenu(frame);
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(500, 300));
		createTickerPanel();
		createValuePanel();
		createGainPanel();
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();
	}
	
	private void createMenu(JFrame frame){
			menus = new JMenuBar();
			edit = new JMenu("Edit");
			addShares = new JMenuItem("Add Shares");
			sellShares = new JMenuItem("Sell Shares");
			menus.add(edit);
			edit.add(addShares);
			edit.add(sellShares);
			frame.setJMenuBar(menus);
		}
		
	
	private void createTickerPanel(){
		tickerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(500, 100);
		tickerPanel.setPreferredSize(d);
		tickerPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
		tickerSymbol = new JLabel("Ticker Symbol: +Ticker Symbol");
		tickerSymbol.setBorder(new EmptyBorder(0, 0, 0, 30));
		stockName = new JLabel("Stock Name: +StockName");
		tickerPanel.add(tickerSymbol);
		tickerPanel.add(stockName);
		mainPanel.add(tickerPanel, BorderLayout.NORTH);
	}
	
	private void createValuePanel(){
		valuePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(500, 100);
		valuePanel.setPreferredSize(d);
		currentValue = new JLabel("Current Value: +Current Value");
		currentValue.setBorder(new EmptyBorder(0, 0, 0, 30));
		dailyChange = new JLabel("Daily Change: +Daily Change");
		valuePanel.add(currentValue);
		valuePanel.add(dailyChange);
		mainPanel.add(valuePanel, BorderLayout.CENTER);
	}
	
	
	private void createGainPanel(){
		gainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(500, 100);
		valuePanel.setPreferredSize(d);
		gainPanel.setBorder(new EmptyBorder(0, 0, 30, 0));
		totalGain = new JLabel("Total Gain: +totalGain");
		totalGain.setBorder(new EmptyBorder(0, 0, 0, 30));
		totalSpend = new JLabel("Total Spend: +totalSpend");
		gainPanel.add(totalGain);
		gainPanel.add(totalSpend);
		mainPanel.add(gainPanel, BorderLayout.SOUTH);
	}
}
