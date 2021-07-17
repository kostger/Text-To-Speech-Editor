package input;


public abstract class ReaderDecorator implements DocumentReader{
	
	private DocumentReader reader;
	
	public ReaderDecorator(DocumentReader reader) {	
		this.reader = reader;
	}
	
	public String read(){
		return reader.read();
	}

}
