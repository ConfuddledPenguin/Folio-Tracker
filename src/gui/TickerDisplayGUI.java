package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tracker.StockTradeListener;
import model.Stock;

public class TickerDisplayGUI implements TickerDisplayGUIInterface {

	private JFrame frame;
	private JPanel mainPanel;
	
	private ActionListener al;
	
	private Stock stock;

	public TickerDisplayGUI(Stock stock) {
		
		this.stock = stock;
		
		al = new StockTradeListener(stock);
		
		makeFrame();
	}

	/**
	 * creates the frame which displays the ticker information as well as
	 * buttons that allow the user to sell and buy shares for that ticker
	 */
	private void makeFrame() {
		// create a new frame
		frame = new JFrame("Editing " + stock.getName() + " shares");
		frame.setSize(500, 300);
		// frame.setResizable(false);
		frame.setVisible(true);
		frame.setResizable(false);
		// centre the GUI according to the screen size
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2
				- frame.getHeight() / 2);
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(500, 300));
		createTickerPanel();
		createButtonPanel();
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * creates the panel which displays all the information for that ticker.
	 * This panel is then centered in the main frame.
	 */
	private void createTickerPanel() {
		JPanel tickerPanel = new JPanel(new GridLayout(6, 2, 10, 0));
		tickerPanel.setBorder(new EmptyBorder(10, 70, 0, 0));
		JLabel tickerSymbolLabel = new JLabel("Ticker Symbol: " + stock.getTicker());
		JLabel stockNameLabel = new JLabel("Stock Name: " + stock.getName());
		JLabel stockExchangeLabel = new JLabel("Stock Exchnage: " + stock.getExchange());
		JLabel currentValueLabel = new JLabel("Current Value: " + stock.getCurrentValue());
		JLabel openingLabel = new JLabel("Opening value: " + stock.getOpeningPrice());
		JLabel dailyChangeLabel = new JLabel("Daily Change: " + stock.getDailyChange());
		JLabel dailyMaxLabel = new JLabel("Daily Max: " + stock.getDailyMax());
		JLabel dailyMinLabel = new JLabel("Daily Min: " + stock.getDailyMin());
		JLabel volumeAvailable = new JLabel("Volume Available: " + stock.getVolume());
		JLabel holdingValueLabel = new JLabel("Holding Value: " + stock.getHoldingValue());
		JLabel totalSpend = new JLabel("Total Spend: " + stock.getTotalSpent());
		JLabel totalGainLabel = new JLabel("Total Gain: " + stock.getNetGain());
		tickerPanel.add(tickerSymbolLabel);
		tickerPanel.add(stockNameLabel);
		tickerPanel.add(stockExchangeLabel);
		tickerPanel.add(currentValueLabel);
		tickerPanel.add(openingLabel);
		tickerPanel.add(dailyChangeLabel);
		tickerPanel.add(dailyMaxLabel);
		tickerPanel.add(dailyMinLabel);
		tickerPanel.add(volumeAvailable);
		tickerPanel.add(holdingValueLabel);
		tickerPanel.add(totalGainLabel);
		tickerPanel.add(totalSpend);
		mainPanel.add(tickerPanel, BorderLayout.CENTER);
	}

	/**
	 * Creates the panel which consists of the add and sell shares buttons. This
	 * panel is set to the south in the main frame
	 */
	private void createButtonPanel() {
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBorder(new EmptyBorder(10, 0, 20, 0));
		JButton buyShares = new JButton("Buy Shares");
		JButton sellShares = new JButton("Sell Shares");
		buyShares.addActionListener(al);
		sellShares.addActionListener(al);
		buttonPanel.add(buyShares);
		buttonPanel.add(sellShares);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
	}

}
