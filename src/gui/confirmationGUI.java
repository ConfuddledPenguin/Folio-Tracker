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
import javax.swing.border.EmptyBorder;

public class confirmationGUI implements ConfirmationInterface{
	private String msg;
	private JFrame frame;
	private JPanel mainPanel;
	private ActionListener al;

	public confirmationGUI(String msg, ActionListener al) {
		this.msg = msg;
		this.al = al;
		makeFrame();
	}

	/**
	 * Creates the main JFrame which has a label added to the center of it and
	 * confirmation buttons added to the bottom
	 */
	private void makeFrame() {
		frame = new JFrame("Deleting " + msg);
		frame.setSize(800, 175);
		frame.setResizable(false);
		// allow the frame to be in front of the home GUI
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		// centre the GUI according to the screen size
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2
				- frame.getHeight() / 2);
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(900, 250));
		JLabel confirmationLabel = new JLabel(
				"Are you sure you wish to delete " + msg);
		confirmationLabel.setBorder(new EmptyBorder(10, 70, 0, 0));
		mainPanel.add(confirmationLabel);
		addButtons();
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();
	}

	/**
	 * creates the buttons to be added to the bottom of the main frame
	 */
	private void addButtons() {
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setSize(400, 100);
		JButton yes = new JButton("Yes");
		yes.addActionListener(al);
		JButton no = new JButton("No");
		no.addActionListener(al);
		buttonPanel.add(yes);
		buttonPanel.add(no);
		buttonPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Method to close the JFrame
	 */
	public void close() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

}
