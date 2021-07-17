package input;

//Here we follow the Strategy pattern.

public class DocumentReaderFactory {
	
	public DocumentReader createReader(String path, String encoding){
		
		 if (path.endsWith("docx")) {
			 if(encoding.equals("None")) {
				 return new WordReader(path);
			 }else if(encoding.equals("Atbash")){
				 return new AtbashReader(new WordReader(path));
			 }else if(encoding.equals("Rot-13")){
				 return new Rot13Reader(new WordReader(path));
			 }
		 }
		 else if(path.endsWith("xlsx")){
			 if(encoding.equals("None")) {
				 return new ExcelReader(path);
			 }else if(encoding.equals("Atbash")){
				 return new AtbashReader(new ExcelReader(path));
			 }else if(encoding.equals("Rot-13")){
				 return new Rot13Reader(new ExcelReader(path));
			 }
		 }
		
		return null;
	}

}
