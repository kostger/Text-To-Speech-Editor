package output;

import model.Rot13;

public class Rot13Writer extends WriterDecorator {

	public Rot13Writer(DocumentWriter writer) {
		super(writer);
	}
	
    public void write(String text) {
        super.write(encode(text));
    }
	
	public String encode (String doc) {
		
		Rot13 rot = new Rot13();
		return rot.code(doc);
	}
}
