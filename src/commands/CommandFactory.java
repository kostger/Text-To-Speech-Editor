package commands;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeListener;

public class CommandFactory {
	
	JTextArea textArea;
	ReplayManager replay = new ReplayManager();
	
	public CommandFactory(JTextArea textArea) {
		this.textArea = textArea;	
	}
	
	public ActionListener createCommand(String key) {
		
		//textArea.setText("HELLO"); DOESNT WORK MAN DONT KNOW WHAT TO DO!!! STATIC METHODS IT IS
		
		if("openFile".equals(key)) {
			return new OpenDocument();
		}
		else if("editFile".equals(key)) {
			return new EditDocument();
		}
		else if("saveFile".equals(key)){
			return new SaveDocument();	
		}
		else if("select".equals(key)) {
			return new SelectedToSpeech();
		}
		else if("activateRec".equals(key)) {
			return new StartRec();
		}
		else if("replayRec".equals(key)) {
			return new RecordedToSpeech();
		}
		else if("deactRec".equals(key)) {
			return new StopRec();
		}
		else {
			JOptionPane.showMessageDialog(null,"Something went wrong");
			return null;
		}
		
	}
	
	public MouseListener createMouseCommand(String key) {
		if("play".equals(key)) {
			return new DocumentToSpeech();
		}
		else if("help".equals(key)) {
			return new ShowHelp();
		}
		return null;
		
	}
	
	public ChangeListener createChangeCommand(String key) {
		if("volume".equals(key)){
			return new SetVolume();
		}
		else if("speechRate".equals(key)) {
			return new SetSpeechRate();
		}
		else if("pitch".equals(key)) {
			return new SetPitch();
		}
		return null;
	}

}
