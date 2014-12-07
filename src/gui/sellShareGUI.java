package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class sellShareGUI {
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel noOfShares;
	private JPanel sellButton;
	private JLabel noOfSharesLabel;
	private JTextField noOfSharesText;
	private JButton sell;

	public static void main(String[] args) {

		new sellShareGUI();
	}

	public sellShareGUI() {
		makeFrame();
	}

	private void makeFrame() {
		frame = new JFrame("Adding Shares To +StockName");
		frame.setSize(400, 175);
		frame.setResizable(false);
		// allow the frame to be in front of the home GUI
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	private void numberOfSharesPane() {
		noOfShares = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(400, 50);
		// set border from top of panel
		noOfShares.setBorder(new EmptyBorder(20, 10, 10, 10));
		noOfShares.setPreferredSize(d);
		noOfSharesLabel = new JLabel("number of Shares:    ");
		noOfSharesText = new JTextField(10);
		noOfShares.add(noOfSharesLabel);
		noOfShares.add(noOfSharesText);
		mainPanel.add(noOfShares, BorderLayout.CENTER);

	}

	private void sellButtonPane() {
		sellButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(400, 50);
		sellButton.setPreferredSize(d);
		sell = new JButton("sell");
		sellButton.add(sell);
		mainPanel.add(sellButton, BorderLayout.SOUTH);
	}

}
