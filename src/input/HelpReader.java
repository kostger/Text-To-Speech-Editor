package input;


import model.Document;

public class HelpReader {
	
	public void showText() {
		
		String path = System.getProperty("user.dir").toString() + "\\help.docx";
		Document document = new Document();
		document.setPar(path, "None");
		document.open();
		
	}
}
