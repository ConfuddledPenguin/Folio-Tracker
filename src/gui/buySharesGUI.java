package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
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

public class buySharesGUI implements StockTradeGUIInterface{
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel noOfShares;
	private JPanel buyButton;
	private JLabel noOfSharesLabel;
	private JTextField noOfSharesText;
	private JButton buy;
	
	private Stock stock;
	private ActionListener al;

	public buySharesGUI(Stock stock) {
		
		this.stock = stock;
		this.al = new StockTradeGUIListener(stock, this);
		
		System.out.println("Draw");
		makeFrame();
	}

	/**
	 * Creates the initial buy shares frame
	 */
	private void makeFrame() {
		frame = new JFrame("Buying Shares for +StockName");
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
		saveButtonPane();
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();

	}

	/**
	 * Creates the panel which consists of a label and text box for the user to
	 * enter the required number of shares to buy
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
	 * Creates the buy button to be added to the bottom of the JFrame
	 */
	private void saveButtonPane() {
		buyButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(400, 50);
		buyButton.setPreferredSize(d);
		buy = new JButton("Buy");
		buy.addActionListener(al);
		buyButton.add(buy);
		mainPanel.add(buyButton, BorderLayout.SOUTH);
	}
	
	public int amount(){
		
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
