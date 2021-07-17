package model;

public class FakeTTSFacade extends TTSFacade {
	
	private String playedContents;
	private int volume;
	private int speechRate;
	private int pitch;
	
	@Override
	public void play(String str) {
		playedContents = str;
		super.play(str);	
	}
	
	@Override
	public void setVolume(int vol) {
		volume = vol;
		super.setVolume(vol);
	}

	@Override
	public void setSpeechRate(int rate) {
		speechRate = rate;
		super.setSpeechRate(rate);
	}

	@Override
	public void setPitch(int newPitch) {
		pitch = newPitch;
		super.setPitch(newPitch);
	}
	
	public String getPlayedContents() {
		return playedContents;
	}
	
	public int getVolume() {
		return volume;	
	}
	
	public int getSpeechRate() {
		return speechRate;
	}
	
	public int getPitch() {
		return pitch;
		
	}

}
