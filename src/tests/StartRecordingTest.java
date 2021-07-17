package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.ReplayManager;
import model.Document;

class StartRecordingTest {

	ReplayManager manager = new ReplayManager();
	Document test = new Document();
	private String path = System.getProperty("user.dir").toString() + "\\tests\\test1.docx";
	@Test
	void test() {
		manager.startRecording();
		test.setPar(path, "None");
		test.open();
		if(!manager.isActive()) {
			fail("Failed to start recording command");
			
		}
		
		
		
	}

}
