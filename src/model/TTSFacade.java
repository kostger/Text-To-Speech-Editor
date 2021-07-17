package model;


public class TTSFacade {

	TTS freetts;
	
	
	public TTSFacade() {
		
		//put if statement if you have more text to speech apis
		freetts = new FreeTTS();
	}
	
	
	public void play(String str){
		freetts.play(str);
	}
	
	public void setVolume(int vol) {
		freetts.setVolume(vol);
	}
	
	public void setSpeechRate(int rate) {
		freetts.setSpeechRate(rate);
	}
	
	public void setPitch(int pitch) {
		freetts.setPitch(pitch);
	}
	
}


