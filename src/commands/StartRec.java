package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartRec implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		
		ReplayManager replay = new ReplayManager();
		replay.startRecording();
		
	}
	
	
	
}
