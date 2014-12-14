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

import model.Stock;

public class TickerDisplayGUI {

	private JFrame frame;
	private JPanel mainPanel;
	private Stock stock;


	public TickerDisplayGUI(Stock stock) {
		this.stock = stock;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		JPanel tickerPanel = new JPanel(new GridLayout(6, 0, 10, 0));
		tickerPanel.setBorder(new EmptyBorder(10, 180, 0, 0));
		JLabel tickerSymbolLabel = new JLabel("Ticker Symbol: " + stock.getTicker());
		JLabel stockNameLabel = new JLabel("Stock Name: " + stock.getName());
		JLabel currentValueLabel = new JLabel("Current Value: " + stock.getCurrentValue());
		JLabel dailyChangeLabel = new JLabel("Daily Change: " + stock.getDailyChange());
		JLabel totalGainLabel = new JLabel("Total Gain: " + stock.getNetGain());
		JLabel totalSpend = new JLabel("Total Spend: " + stock.getTotalSpent());
		tickerPanel.add(tickerSymbolLabel);
		tickerPanel.add(stockNameLabel);
		tickerPanel.add(currentValueLabel);
		tickerPanel.add(dailyChangeLabel);
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
		buttonPanel.add(buyShares);
		buttonPanel.add(sellShares);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
	}

}
