package output;

public class AtbashWriter extends WriterDecorator{

	public AtbashWriter(DocumentWriter writer) {
		super(writer);
	}
	
	public void write(String text) {
	    super.write(encode(text));
	}
	   
	public String encode(String doc) {
		
		String encoded = "";
		for(char c : doc.toCharArray()){
            if(Character.isLowerCase(c)){
                encoded += (char) ('a' + ('z' - c));
            }
            else if(Character.isUpperCase(c)){
                encoded += (char) ('A' + ('Z' - c));
            }
            else{
                encoded += c;
            }
        }
		
		return encoded;
	}
}
