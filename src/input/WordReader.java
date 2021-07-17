package input;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordReader implements DocumentReader{
	private String docText = "";
	private String path;
	
	public WordReader(String path) {
		this.path = path;
	}
	
	public String read(){  
		
		try(XWPFDocument docx = new XWPFDocument(Files.newInputStream(Paths.get(path)))){
			XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
			docText= extractor.getText();
			extractor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return docText;
	}

}
