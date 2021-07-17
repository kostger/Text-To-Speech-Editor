package model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTS implements TTS{
	
	private VoiceManager vm;
	private Voice voice;
	
	
	public FreeTTS() {
		System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		vm = VoiceManager.getInstance();
		voice = vm.getVoice("kevin16");
		voice.allocate();	
	}
	
	public Voice getVoice() {
		return voice;
	}
	
	public void play(String str){
		voice.speak(str);
	}
	
	public void setVolume(int vol) {
		float volume = (float)vol/100;
		voice.setVolume(volume);
	}
	
	public void setSpeechRate(int rate) {
		float newRate = (float)rate*3;
		voice.setRate(newRate);
	}
	
	public void setPitch(int pitch) {
		float newPitch = (float)pitch*2;
		voice.setPitch(newPitch);
	}
	
	public void print() {
		System.out.println("Final V: " + voice.getVolume());
		System.out.println("Final R: " + voice.getRate());
		System.out.println("Final P: " + voice.getPitch());	
	}

}
