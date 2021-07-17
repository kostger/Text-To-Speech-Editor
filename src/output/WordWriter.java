package output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class WordWriter implements DocumentWriter {
	
	private String path;
	
	public WordWriter(String path) {
		this.path = path;
	}

    public void write(String text){

        try(XWPFDocument document = new XWPFDocument()){
        	XWPFParagraph tmpParagraph = document.createParagraph();
        	XWPFRun tmpRun = tmpParagraph.createRun();
        	String[] textLines = text.split("\n");
        	for(String str : textLines) {
        	  tmpRun.setText(str);
        	  tmpRun.addBreak();
        	}
        	FileOutputStream outputStream = new FileOutputStream(new File(path));
        	document.write(outputStream);
        	document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
