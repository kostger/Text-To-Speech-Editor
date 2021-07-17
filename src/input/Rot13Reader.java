package input;

import model.Rot13;

public class Rot13Reader extends ReaderDecorator{

	public Rot13Reader(DocumentReader reader) {
		super(reader);
	}
	
	public String read() {
        return decode(super.read());
    }
	
	public String decode (String doc) {
		
		Rot13 rot = new Rot13();
		return rot.code(doc);
	}
	
	
}
