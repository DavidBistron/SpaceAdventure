package Space_Adventure;

import java.util.Timer;
import java.util.TimerTask;

public class BackgroundMovement {

	// Timer = one possibility (Other is ...) --> need to be importet from java.util
	Timer bmTime;
	
	// Constructor
	public BackgroundMovement() {
		bmTime = new Timer();
		bmTime.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				// Necessary for a smooth flow of images (looks like flying through space)
				if (Variables.backgroundY1 < 596) {
					Variables.backgroundY1 += 2;
				} else {
					Variables.backgroundY1 = -600;
				}
				
				if (Variables.backgroundY2 < 596) {
					Variables.backgroundY2 += 2;
				} else {
					Variables.backgroundY2 = -600;
				}
			}
		}, 0, Variables.backgroundSpeed);
	}
}