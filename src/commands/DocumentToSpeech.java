package commands;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Document;

public class DocumentToSpeech implements MouseListener{
	
	public DocumentToSpeech() {}
	public void setDocument() {}
	public void setReplayManager() {}
	
	
	public void mouseClicked(MouseEvent e) {
		Document document = new Document();
		document.playContents();
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}