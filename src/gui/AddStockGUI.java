package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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

import tracker.AddStockGUIListener;
import model.Portfolio;

public class AddStockGUI implements AddNewInterface{
	private JFrame frame;
	private JPanel mainPanel;
	private JTextField nameField;

	private Portfolio portfolio;
	
	private ActionListener addstock;

	public AddStockGUI(Portfolio portfolio) {

		this.portfolio = portfolio;
		addstock = new AddStockGUIListener(this, portfolio);

		makeFrame();
	}

	/**
	 * Creates the initial frame before adding a button to the bottom and the
	 * stock panel to the center
	 */
	private void makeFrame() {
		frame = new JFrame("Add new Stock");
		frame.setSize(400, 175);
		frame.setResizable(false);
		// allow the frame to be in front of the home GUI
		frame.setAlwaysOnTop(true);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// centre the GUI according to the screen size
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2
				- frame.getHeight() / 2);
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(400, 175));
		createStockPanel();
		JButton add = new JButton("Add Stock");
		add.addActionListener(addstock);
		mainPanel.add(add, BorderLayout.SOUTH);
		frame.add(mainPanel);
		frame.revalidate();

	}

	/**
	 * Build the stock Panel consisting of a label and text field
	 */
	private void createStockPanel() {
		JPanel stockPanel = new JPanel(new GridLayout(1, 1));
		stockPanel.setBorder(new EmptyBorder(50, 80, 50, 80));
		JLabel label = new JLabel("Name Of stock:");
		nameField = new JTextField(20);
		stockPanel.add(label);
		stockPanel.add(nameField);
		mainPanel.add(stockPanel, BorderLayout.CENTER);

	}
    
	/**
	 * Simple getter method to return the ticker name
	 * 
	 * @return - ticker name
	 */
	public String getInfo() {
		return nameField.getText();
	}
    
	/**
	 * Method to close the JFrame
	 */
	public void close() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

}
