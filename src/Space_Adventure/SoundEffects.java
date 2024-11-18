package Space_Adventure;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// Class for managing sound effects
public class SoundEffects {

	public static String click_sound, startMenuMusic;
	public static Clip clip;

	// Constructor
	public SoundEffects() {
	}
	
	public void SoundEffectsClick() {
		click_sound = ".//audio//Godzilla.wav";
		setFile(click_sound);
		play();
	}

	public void StartMenuMusic() {
		startMenuMusic = ".//audio//StartScreen.wav";
		setFile(startMenuMusic);
		play();
		loop();
	}
	
	public void LevelOneMusic() {
		startMenuMusic = ".//audio//InGame3.wav";
		setFile(startMenuMusic);
		play();
		loop();
	}

	// Method preparing audio
	public static void setFile(String soundFileName) {
		try {
			File file = new File(soundFileName);
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method playing audio
	public static void play() {
		clip.setFramePosition(0);
		clip.start();
	}
	
	// loop song if necessary
	@SuppressWarnings("static-access")
	public static void loop() {
		clip.loop(clip.LOOP_CONTINUOUSLY);
	}
	
	// Method stopping audio
	public static void stop() {
		clip.stop();
	}
}