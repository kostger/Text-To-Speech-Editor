package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.ReplayManager;
import model.Document;

class StopRecordingTest {

	ReplayManager manager = new ReplayManager();
	Document test = new Document();
	private String path = System.getProperty("user.dir").toString() + "\\tests\\test1.docx";
	@Test
	void test() {
		manager.startRecording();
		test.setPar(path, "None");
		test.open();
		
		test.setReplayContents(test.getContent());
		manager.stopRecording();
		if(manager.isActive()) {
			fail("Failed to stop recording.");
			
		}
		
	}

}
