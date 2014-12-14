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
		
		createSetRefreshRatePanel();
		
		
		JButton add = new JButton("Set Rate");
		
		add.addActionListener(al);
		
		mainPanel.add(add, BorderLayout.SOUTH);
		
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();
	}
	
	private void createSetRefreshRatePanel(){
		JPanel refreshRate = new JPanel(new FlowLayout());
		refreshRate.setSize(400, 50);
		refreshRate.setBorder(new EmptyBorder(40, 0, 0, 0));
		JLabel label =  new JLabel("Time between refreshes in seconds:");
		refreshRate.add(label);		
		timeField = new JTextField(4);
		refreshRate.add(timeField);
		mainPanel.add(refreshRate, BorderLayout.CENTER);
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
