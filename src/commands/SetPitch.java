package commands;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Document;

public class SetPitch implements ChangeListener {
	
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		int pitch = (int)source.getValue();
		//System.out.println("Pitch: "+ pitch);
		setDocument(pitch);
	}
	
	public void setDocument(int pitch) {
		int id = 3;		
		Document document = new Document();		
		document.audio(pitch,id);
	}
}
