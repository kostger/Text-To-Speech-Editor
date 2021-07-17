package commands;

//import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Document;
import view.Component;

public class OpenDocument implements ActionListener {
	
	Document document = new Document();
	Component component = new Component();
	
	public void actionPerformed(ActionEvent e) {
		
		try {
			FileFilter filter = new FileNameExtensionFilter("MS Files",new String[] { "docx", "xlsx"});
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(filter);
			fileChooser.addChoosableFileFilter(filter);
			JComponent box = component.encodingType("Decoding");
			fileChooser.setAccessory(box);
			
			fileChooser.showOpenDialog(null);
			
			File f= fileChooser.getSelectedFile();
			String path = f.getAbsolutePath();
			String encoding = Component.getEncodingType();
			document.setPar(path,encoding);
			document.open();
			
		}catch(Exception ae ){
			
			JOptionPane.showMessageDialog(null, "Cancelled.");
		}
	}
	
}

