package Space_Adventure;

import java.util.Timer;
import java.util.TimerTask;

// Class for fire animation of ufo, rocket and delorean
public class UfoLightsAnimation {

	Timer ulaTimer;
	private int animationVariable = 0;
	
	public UfoLightsAnimation() {
		ulaTimer = new Timer();
		ulaTimer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				if (animationVariable == 0) {
					Variables.animatedLights = 0;
					animationVariable++;
				} else if (animationVariable == 1) {
					Variables.animatedLights = 1;
					animationVariable--;
				}
			}
		}, 0, 130);
	}
}