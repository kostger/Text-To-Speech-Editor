package commands;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Document;

public class SetSpeechRate implements ChangeListener {
	
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		int rate = (int)source.getValue();
		//System.out.println("Speech Rate: "+ rate);
		setDocument(rate);
	}
	
	public void setDocument(int rate) {
		int id = 2;		
		Document document = new Document();		
		document.audio(rate,id);
	}
}
