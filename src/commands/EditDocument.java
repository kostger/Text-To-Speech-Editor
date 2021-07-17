package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;

public class EditDocument implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		Document document = new Document();
		document.setEditable();
		
	}

}
