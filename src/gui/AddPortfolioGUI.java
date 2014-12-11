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

import tracker.AddPortfolioGUIListener;
import model.Tracker;

public class AddPortfolioGUI {
	
	private JFrame frame;
	private JPanel mainPanel;
	private JTextField nameField;
	
	private ActionListener al;
	
	private Tracker tracker;

	public AddPortfolioGUI(Tracker tracker) {
		
		this.tracker = tracker;
		
		makeFrame();
	}

	private void makeFrame() {
		frame = new JFrame("Add new Portfolio");
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
		
		
		JLabel label =  new JLabel("Name Of Portfolio:");
		mainPanel.add(label, BorderLayout.WEST);
		
		nameField = new JTextField();
		mainPanel.add(nameField, BorderLayout.EAST);
		
		JButton add = new JButton("Add Portfolio");
		
		add.addActionListener( new AddPortfolioGUIListener(this, tracker) );
		
		mainPanel.add(add, BorderLayout.SOUTH);
		
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();

	}
	
	public String getName(){
		return nameField.getText();
	}
	
	public void close(){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}
