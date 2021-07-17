package model;

import javax.swing.JOptionPane;

import commands.ReplayManager;
import input.DocumentReader;
import input.DocumentReaderFactory;
import output.DocumentWriterFactory;
import output.DocumentWriter;
import view.TTSEditorView;

public class Document {
	
	TTSEditorView window;
	private String contents;
	private String path;
	private String encoding;
	private String content;
	private String editedContent;
	private DocumentReader reader;
	private DocumentWriter writer;
	private static int isSelected;
	protected static int volume = 50;
	protected static int pitch = 50;
	protected static int rate = 50;
	
	
	public Document() {
	}
	
	public TTSEditorView getWindow() {
		window = TTSEditorView.getWindow();
		return window;
	}
	
	
	public void setDocReaderFactory(DocumentReaderFactory factory) {
		reader = factory.createReader(path, encoding);
	}

	public void setDocWriterFactory(DocumentWriterFactory factory){
		writer = factory.createWriter(path,encoding);
	}
	
	public void setPar(String newPath, String newEncoding) {
		path = newPath;
		encoding = newEncoding;
	}
	

	public void open() {
		setDocReaderFactory(new DocumentReaderFactory());
		getWindow();
		setContent(reader.read());
		window.setDisplay(getContent());
	}

	public void save() {
		setDocWriterFactory(new DocumentWriterFactory());
		getWindow();
		setContent(window.getTextArea());
		writer.write(getContent());
	}
	
	public void setEditable() {
		getWindow();
		window.getThisTextArea().setEditable(true);
	}
	
	public void setAudioManager(TTSFacade audioManager, String str) {
		
		audioManager.setVolume(volume);	
		audioManager.setSpeechRate(rate);
		audioManager.setPitch(pitch);	
		audioManager.play(str);	
	}
	
	public void playContents() {
		getWindow();
		if(isSelected == 0) {
			contents = window.getTextArea();
		}
		else if(isSelected == 1) {
			contents = playLine();
		}
		setReplayContents(contents);
		
		setAudioManager(new TTSFacade(), contents);
	}
	
	public String playLine() {
		String selected = "";
		getWindow();
		
		if (window.getSelectedText() != null) { 
	        selected = window.getSelectedText();
		}
		else {
			JOptionPane.showMessageDialog(null, "Please select some text.");
		}
		return selected;
	}
	
	public void setSelected(int set) {
		isSelected = set;
	}
	
	public void audio(int val,int id) {
		
		if(id == 1) {
			volume = val;	
		}else if(id == 2){
			rate = val;
		}else if(id == 3) {
			pitch = val;
		}
	}
	
	public void setReplayContents(String contents) {
		ReplayManager replay = new ReplayManager();
		if(replay.isActive()) {
			replay.setRecorded(contents);
		}
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	
	public String getContent() {
		return content;
	}
	
	
	/** Setters and Getters used in Tests **/
	
	public void setEditedContent() {
		getWindow();
		window.getThisTextArea().append(" //(edited)");
		editedContent = window.getTextArea();
	}

	public String getEditedContent() {
		return editedContent;
	}

	public void setMyTextArea(String content) {
		getWindow();
		window.setDisplay(content);
	}
	
	public void setMySelectedText(String content) {
		getWindow();
		window.setDisplay(content);
		window.getThisTextArea().setSelectionStart(7);
		window.getThisTextArea().setSelectionEnd(12);
		//System.out.println(window.getSelectedText());
	}
	
	public String getMySelectedText() {
		getWindow();
		return window.getSelectedText();
	}
	
	public int getVolume() {
		return volume;
	}
	
	public int getSpeechRate() {
		return rate; 
	}
	
	public int getPitch() {
		return pitch;
	}
	
	
}
