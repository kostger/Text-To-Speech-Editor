package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Document;
import model.FakeTTSFacade;

class SelectedToSpeechTest {
	
	Document test = new Document();
	FakeTTSFacade fake = new FakeTTSFacade();
	private String selected;
	private String fakeContents;
	
	@Test
	void test() {
		String test_string = "123456789123456789";
		
		test.setMySelectedText(test_string);
		selected = test.getMySelectedText();
		fake.play(selected);
		fakeContents = fake.getPlayedContents();
		if(!selected.equals(fakeContents)) {
			fail("Failed in Document to Speech");
		}
		
	}

}
