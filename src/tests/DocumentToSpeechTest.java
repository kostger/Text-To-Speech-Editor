package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Document;
import model.FakeTTSFacade;

class DocumentToSpeechTest {
	
	FakeTTSFacade fake = new FakeTTSFacade();
	Document test = new Document();
	private String docContent;
	private String fakeContents;
	@Test
	void test() {
		String test_string = "This is a test";
		
		test.setContent(test_string);
		docContent = test.getContent();
		fake.play(docContent);
		fakeContents = fake.getPlayedContents();
		if(!docContent.equals(fakeContents)) {
			fail("Failed in Document to Speech");
		}
		
	}

}
