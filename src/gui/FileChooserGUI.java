package gui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserGUI implements FileChooserInterface{
	
		JFileChooser chooser;
	
	public FileChooserGUI() {
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Portfolio files", "ftf");
		chooser.setFileFilter(filter);
		File dir = new File(System.getProperty("user.home"));
		chooser.setCurrentDirectory(dir);
	}
	
	/* (non-Javadoc)
	 * @see gui.FileChooserInterface#GetFile()
	 */
	@Override
	public File GetFile(){
		
		int returnval = chooser.showOpenDialog(chooser);
		
		if(returnval == JFileChooser.APPROVE_OPTION) {
			   return chooser.getSelectedFile();
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see gui.FileChooserInterface#SaveFile()
	 */
	@Override
	public File SaveFile(){
		
		
		int returnval = chooser.showSaveDialog(chooser);
		
		if(returnval == JFileChooser.APPROVE_OPTION) {
			   return chooser.getSelectedFile();
		}
		
		return null;
	}

}
