package gui;

import java.awt.Container;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserInterface extends JFrame {
	
	public static void main(String[] args) {
		
		new UserInterface();
	}
	
	public UserInterface(){
		
		createFrame();
		
	}
	
	private void createFrame(){
		
		createMenu();
		createInterface();
		
		setTitle("Folio Tracker");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
		
		setVisible(true);
		
	}
	
	private void createMenu(){
		
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu();
		JMenuItem item;
		
		//build the first menu
		item = new JMenuItem("fish");
		
		menu.add(item);
		
		
	}

	private void createInterface(){
		
		Container pane = getContentPane();
		FlowLayout gl = new FlowLayout();
		pane.setLayout(gl);
		
		JButton button = new JButton("Click here to reinforce the idea of thomas being a tit");
		
		button.addActionListener(
				
					new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
								
							System.exit(0);
							
						}
					}
				
				);
		
		pane.add(button);
		
	}
}
