package commands;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Document;
import view.Component;


public class SaveDocument implements ActionListener{

    private String extension = "";
    Document document = new Document();
    Component component = new Component();
    
    public void actionPerformed(ActionEvent e) {

    	JFileChooser fileChooser = new JFileChooser("C:/");
        FileFilter docfilter = new FileNameExtensionFilter("Doc Files (.docx)", "docx");
        FileFilter xlfilter = new FileNameExtensionFilter("Excel Files (.xlsx)", "xlsx");
        fileChooser.addChoosableFileFilter(docfilter);
        fileChooser.addChoosableFileFilter(xlfilter);
		JComponent box = component.encodingType("Encoding");
		fileChooser.setAccessory(box);
        
        int approval = fileChooser.showSaveDialog(null);

        if (approval == JFileChooser.APPROVE_OPTION) {
        	
        	//get filter that the user chose
        	String filter = fileChooser.getFileFilter().getDescription();
        	if (filter.equals("Doc Files (.docx)")) {
        		extension = ".docx";
        	}
        	else if (filter.equals("Excel Files (.xlsx)")) {
        		extension = ".xlsx";
        	}
        	
        	String path = fileChooser.getSelectedFile().getAbsolutePath() + extension;
        	String encoding = Component.getEncodingType();
        	document.setPar(path, encoding);
			document.save();	
        }
        else {
        	JOptionPane.showMessageDialog(null, "Cancelled.");
        }
    }
}
