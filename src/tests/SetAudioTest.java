package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Document;
import model.FakeTTSFacade;

class SetAudioTest {
	
	FakeTTSFacade fake = new FakeTTSFacade();
	Document test = new Document();
	
	@Test
	void test() {
		
		int test_vol = 80;
		int test_rate = 55;
		int test_pitch = 50;
		
		test.audio(test_vol,1);
		test.audio(test_rate,2);
		test.audio(test_pitch,3);
		int docVol = test.getVolume();
		int docRate = test.getSpeechRate();
		int docPitch = test.getPitch();
		
		fake.setVolume(docVol);
		fake.setSpeechRate(docRate);
		fake.setPitch(docPitch);
		int fakeVol = fake.getVolume();
		int fakeRate = fake.getSpeechRate();
		int fakePitch = fake.getPitch();
		
		if(docVol != fakeVol) {
			fail("Failed in Document to Speech");
		}
		if(docRate != fakeRate) {
			fail("Failed in Document to Speech");
		}
		if(docPitch != fakePitch) {
			fail("Failed in Document to Speech");
		}
		
	}

}
