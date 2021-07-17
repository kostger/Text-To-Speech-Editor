package commands;

import javax.swing.JOptionPane;

import model.Document;
import model.TTSFacade;

public class ReplayManager {

	private static boolean recordingStatus;
	private static String recorded = "";

	public ReplayManager() {
	}
	
	public void setRecorded(String str) {
		recorded = recorded + " " + str;
		//an patisw play duo fores enw isActive tha mou kanei record duo fores to idio
		//System.out.println("setRecorded: " + recorded);
	}
	
	public String getRecorded() {
		//System.out.println("getRecorded: " + recorded);
		return recorded;
	}
	
	public void replay() {
		if(recorded.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please activate the recording first.");
		}
		else {
			Document document = new Document();
			document.setAudioManager(new TTSFacade(), getRecorded());
		}
	}
	
	public void startRecording() {
		recordingStatus = true;
	}
	
	public void stopRecording() {
		recordingStatus = false;
		recorded = "";
	}
	
	public boolean isActive() {
		return recordingStatus;
	}
}
