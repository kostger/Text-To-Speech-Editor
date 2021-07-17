package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.ReplayManager;
import model.Document;
import model.FakeTTSFacade;

class ReplayTest {
	
	Document test = new Document();
	FakeTTSFacade fake = new FakeTTSFacade();
	ReplayManager manager = new ReplayManager();
	private String path;
	private String content;
	private String test_string = " This is a test file.\n\n" +" "+ "This\tis\ta\ttest\tfile.\t";

	@Test
	void test() {
		manager.startRecording();
		path = System.getProperty("user.dir").toString() + "\\tests\\test1.docx";
		test.setPar(path, "None");
		test.open();
		content = test.getContent();
		fake.play(content);
		test.setReplayContents(content);
		
		path = System.getProperty("user.dir").toString() + "\\tests\\test2.xlsx";
		test.setPar(path, "None");
		test.open();
		content = test.getContent();
		fake.play(content);
		test.setReplayContents(content);
		
		if(!test_string.equals(manager.getRecorded())) {
			fail("Failed to replay recorded content.");
			
		}
		
	}

}
