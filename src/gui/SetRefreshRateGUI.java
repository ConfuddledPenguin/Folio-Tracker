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
import javax.swing.JTextField;

import model.Tracker;
import tracker.AddPortfolioGUIListener;
import tracker.SetRefreshRateGUIListener;
import tracker.SetRefreshRateListener;

public class SetRefreshRateGUI implements SetRefreshRateInterface{

	private JFrame frame;
	private JPanel mainPanel;
	private JTextField timeField;
	
	private ActionListener al;

	public SetRefreshRateGUI(Tracker tracker) {
		
		al = new SetRefreshRateGUIListener(this, tracker);
		
		makeFrame();
	}

	private void makeFrame() {
		frame = new JFrame("Set the Refresh Rate");
		frame.setSize(400, 175);
		frame.setResizable(false);
		// allow the frame to be in front of the home GUI
		frame.setAlwaysOnTop(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// centre the GUI according to the screen size
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2
				- frame.getHeight() / 2);
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(400, 175));
		
		
		JLabel label =  new JLabel("Time between refreshes in seconds:");
		mainPanel.add(label, BorderLayout.WEST);
		
		timeField = new JTextField();
		mainPanel.add(timeField, BorderLayout.EAST);
		
		JButton add = new JButton("Set Rate");
		
		add.addActionListener(al);
		
		mainPanel.add(add, BorderLayout.SOUTH);
		
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();
	}
	
	@Override
	public String getRefreshRate() {
		
		return timeField.getText();
		
	}

	@Override
	public void close() {
		
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));		
	}

}
