package output;

public class DocumentWriterFactory {

    
    public DocumentWriter createWriter(String path, String encoding){
    	
    	if(path.endsWith(".docx")) {
			 if(encoding.equals("None")) {
				 return new WordWriter(path);
			 }else if(encoding.equals("Atbash")){
				 return new AtbashWriter(new WordWriter(path));
			 }else if(encoding.equals("Rot-13")){
				 return new Rot13Writer(new WordWriter(path));
			 }
    	}
    	else if(path.endsWith(".xlsx")){
    		if(encoding.equals("None")) {
				 return new ExcelWriter(path);
			 }else if(encoding.equals("Atbash")){
				 return new AtbashWriter(new ExcelWriter(path));
			 }else if(encoding.equals("Rot-13")){
				 return new Rot13Writer(new ExcelWriter(path));
			 }
    	}
    	
    	return null;
    }
}
