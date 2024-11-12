//package Space_Adventure;
//
//import java.io.File;
//
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//
//public class Music {
//
//	// Constructor --> not needed, because no objects to create
//	public Music() {
//	}
//	
//	// track for soundfile, which to play while game
//	public static synchronized void sounds(String track) {
//		
//		final String trackName = track;		
//		
//		// music is going to be played in a thread
//		new Thread(new Runnable() {
//			
//			@SuppressWarnings("static-access")
//			public void run() {
//				while(true) {
//					try {
//						Clip clip = AudioSystem.getClip();
//						AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(trackName));
//						clip.open(inputStream);
//						clip.loop(clip.LOOP_CONTINUOUSLY); // can be looped 2 times, 3 times whatever, or continuously
//						
//						Thread.sleep(clip.getMicrosecondLength()/1000);
//						
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//	}
//}
