package output;


public abstract class WriterDecorator implements DocumentWriter {
	
	private DocumentWriter writer;
	
	public WriterDecorator(DocumentWriter writer) {	
		this.writer = writer;
	}
	
	public void write(String text) {
		writer.write(text);
	}
	
}
