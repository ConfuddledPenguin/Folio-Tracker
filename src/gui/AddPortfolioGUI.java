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

public class AddPortfolioGUI implements AddNewInterface {
	
	private JFrame frame;
	private JPanel mainPanel;
	private JTextField nameField;
	
	private ActionListener al;

	public AddPortfolioGUI(Tracker tracker) {
		
		al = new AddPortfolioGUIListener(this, tracker);
		
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
		
		createNewPortfolioPanel();
		
		JButton add = new JButton("Add Portfolio");
		
		add.addActionListener(al);
		
		mainPanel.add(add, BorderLayout.SOUTH);
		
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();

	}
	
	private void createNewPortfolioPanel(){
		JPanel createPortfolio = new JPanel(new FlowLayout());
		createPortfolio.setSize(400, 175);
		createPortfolio.setBorder(new EmptyBorder(40,0,0,0));
		JLabel label =  new JLabel("Name Of Portfolio:");
		createPortfolio.add(label);		
		nameField = new JTextField(20);
		createPortfolio.add(nameField);	
		mainPanel.add(createPortfolio, BorderLayout.CENTER);		
	}
	
	public String getInfo(){
		return nameField.getText();
	}
	
	public void close(){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}
