package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tracker.ErrorGUIListener;

public class errorGUI implements ErrorInterface {
	
 private String errorMessage;
 private JFrame frame;
 private JPanel mainPanel;
 private ActionListener al;
	
	public errorGUI(String errorMessage){
		this.errorMessage = errorMessage;
		al = new ErrorGUIListener(this);
		makeFrame();
	}
	
	/**
	 * Creates the main JFrame which has a label added to the center of it and
	 * confirmation buttons added to the bottom
	 */
	private void makeFrame() {
		frame = new JFrame("error");
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
		mainPanel.setPreferredSize(new Dimension(400, 250));
		JLabel errorMessageLabel = new JLabel(errorMessage, SwingConstants.CENTER);
		errorMessageLabel.setBorder(new EmptyBorder(10, 0, 0, 0));
		mainPanel.add(errorMessageLabel);
		JButton ok = new JButton("OK");
		ok.addActionListener(al);
		ok.setBorder(new EmptyBorder(0,0,10,0));
		mainPanel.add(ok, BorderLayout.SOUTH);
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();
	}
	
	/**
	 * Method to close the JFrame
	 */
	public void close() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

}
