package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class errorGUI {
 private String errorMessage;
 private JFrame frame;
 private JPanel mainPanel;
 
 public static void main(String[] args) {

		new errorGUI("No such ticker name");
	}
	
	public errorGUI(String errorMessage){
		this.errorMessage = errorMessage;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		ok.setBorder(new EmptyBorder(0,0,10,0));
		mainPanel.add(ok, BorderLayout.SOUTH);
		frame.add(mainPanel);
		frame.revalidate();
		frame.repaint();
	}

}
