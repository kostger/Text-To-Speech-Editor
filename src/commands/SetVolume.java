package commands;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Document;

public class SetVolume implements ChangeListener{
		
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		int volume = (int)source.getValue();
		//System.out.println("Volume: "+ volume);
		setDocument(volume);	
	}
	
	public void setDocument(int volume) {
		int id = 1;		
		Document document = new Document();		
		document.audio(volume,id);
	}

}
