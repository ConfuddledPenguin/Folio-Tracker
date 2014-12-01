package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class UserInterface {
	private JFrame frame;
	private JMenuBar menus;
	private JMenu file;
	private JMenu folio;
	private JMenuItem closeFolio;
	private JMenuItem newFolio;
	private JMenuItem deleteFolio;
	private JPanel mainPanel;
	private JTabbedPane tabs;
	private JPanel addShares;
	private JLabel folioValue;
	private JLabel noOfShares;
	private JTextField tickerText;
	private JTextField noOfSharesText;
	private JLabel tickerSymbol;
	private JButton addFolio;
	String[] columnNames = { "Ticker Symbol", "Stock Name", "Number Of Shares",
			"Price Per Share", "Value Of Holding" };

	public static void main(String[] args) {

		new UserInterface();
	}

	public UserInterface() {
		makeFrame();
	}

	private void makeFrame() {
		// create a new frame
		frame = new JFrame("Folio Tracker");
		frame.setSize(650, 600);
		// frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// centre the GUI according to the screen size
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2
				- frame.getHeight() / 2);
		// add a menu bar to the frame
		createMenu(frame);
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(650, 500));
		frame.add(mainPanel);
		createTabs();
		createAddSharesPane();
		createFolioValueLabel();
		createTickerTable();

	}

	private void createMenu(JFrame frame) {
		menus = new JMenuBar();
		file = new JMenu("File");
		folio = new JMenu("Folio");
		closeFolio = new JMenuItem("Close Folio");
		newFolio = new JMenuItem("Create Folio");
		deleteFolio = new JMenuItem("Delete Folio");
		menus.add(file);
		menus.add(folio);
		file.add(newFolio);
		folio.add(closeFolio);
		folio.add(deleteFolio);
		frame.setJMenuBar(menus);
	}

	// will only appear once there are tabs to create (I think)
	private void createTabs() {
		tabs = new JTabbedPane();
		mainPanel.add(tabs, BorderLayout.CENTER);
	}

	private void createAddSharesPane() {
		addShares = new JPanel(new FlowLayout());
		Dimension d = new Dimension(650, 50);
		addShares.setPreferredSize(d);
		addShares.setBackground(Color.gray);
		tickerSymbol = new JLabel("Ticker Symbol:");
	    noOfShares = new JLabel("Number Of Shares:");
	    tickerText = new JTextField(20);
	    noOfSharesText = new JTextField(4);
		addFolio = new JButton("Add");
		addShares.add(tickerSymbol);
		addShares.add(tickerText);
		addShares.add(noOfShares);
		addShares.add(noOfSharesText);
		addShares.add(addFolio);
		mainPanel.add(addShares, BorderLayout.NORTH);
	}

	// parameter will have to be passed in here and obviously the label content
	// will be changed
	private void createFolioValueLabel() {
		folioValue = new JLabel("test label", SwingConstants.CENTER);
		Dimension d = new Dimension(650, 50);
		folioValue.setPreferredSize(d);
		folioValue.setOpaque(true);
		folioValue.setBackground(Color.gray);
		mainPanel.add(folioValue, BorderLayout.SOUTH);
	}

	// rows will be added dynamically, just implemented the layout
	private void createTickerTable() {
     //create table
      DefaultTableModel model = new DefaultTableModel(); 
      JTable tickerTable = new JTable(model);
      //add columns to the table
      for(int i=0; i<columnNames.length;i++){
    	  model.addColumn(columnNames[i]);
      }
      tickerTable.setBackground(Color.WHITE);
      mainPanel.add(new JScrollPane(tickerTable), BorderLayout.CENTER);
      
	}
}
