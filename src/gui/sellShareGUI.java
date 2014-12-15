package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tracker.StockTradeGUIListener;
import model.Stock;

public class sellShareGUI implements StockTradeGUIInterface {
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel noOfShares;
	private JPanel sellButton;
	private JLabel noOfSharesLabel;
	private JTextField noOfSharesText;
	private JButton sell;
	
	private Stock stock;
	private ActionListener al;

	public sellShareGUI(Stock stock) {
		
		this.stock = stock;
		this.al = new StockTradeGUIListener(stock, this);
		
		makeFrame();
	}

	/**
	 * creates the initial JFrame and adds the components created in separate
	 * methods to it
	 */
	private void makeFrame() {
		frame = new JFrame("Selling Shares From +StockName");
		frame.setSize(400, 175);
		frame.setResizable(false);
		// allow the frame to be in front of the home GUI
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		// centre the GUI according to the screen size
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2
				- frame.getHeight() / 2);
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(400, 175));
		numberOfSharesPane();
		sellButtonPane();
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();

	}

	/**
	 * Creates the number of shares panel consisting of a label and text box for
	 * the user to enter the required amount of shares to sell
	 */
	private void numberOfSharesPane() {
		noOfShares = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(400, 50);
		// set border from top of panel
		noOfShares.setBorder(new EmptyBorder(40, 10, 10, 10));
		noOfShares.setPreferredSize(d);
		noOfSharesLabel = new JLabel("number of Shares:    ");
		noOfSharesText = new JTextField(10);
		noOfShares.add(noOfSharesLabel);
		noOfShares.add(noOfSharesText);
		mainPanel.add(noOfShares, BorderLayout.CENTER);

	}

	/**
	 * Creates the sell button to be added to the bottom of the JFrame
	 */
	private void sellButtonPane() {
		sellButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(400, 50);
		sellButton.setPreferredSize(d);
		sell = new JButton("Sell");
		sell.addActionListener(al);
		sellButton.add(sell);
		mainPanel.add(sellButton, BorderLayout.SOUTH);
	}

	@Override
	public int amount() {
		
		int amount = Integer.parseInt(noOfSharesText.getText());
		
		return amount;
	}
	
	/**
	 * Method to close the JFrame
	 */
	public void close() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}
