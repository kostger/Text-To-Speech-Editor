package input;

public class AtbashReader extends ReaderDecorator {
	
	public AtbashReader(DocumentReader reader) {
		super(reader);
	}
	
	public String read() {
        return decode(super.read());
    }
	
	public String decode (String doc) {
		
		String normal = "";
		for(char c : doc.toCharArray()){
            if(Character.isLowerCase(c)){
                normal += (char) ('z' + ('a' - c));
            }
            else if(Character.isUpperCase(c)){
                normal += (char) ('Z' + ('A' - c));
            }
            else{
                normal += c;
            }
        }
		
		return normal;
	}
	
}
