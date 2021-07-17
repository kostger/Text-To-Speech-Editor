package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import model.Document;

public class SelectedToSpeech implements ActionListener {


	public void actionPerformed(ActionEvent e) {
		
		AbstractButton abstractButton = (AbstractButton)e.getSource();
		boolean selected = abstractButton.getModel().isSelected(); //True if button is pressed, else false
		
		Document document = new Document();
        if(selected) {
			document.setSelected(1);	
        }
        else {
        	document.setSelected(0);
        }
	}

}
