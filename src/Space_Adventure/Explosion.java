package Space_Adventure;

import java.util.Timer;
import java.util.TimerTask;

public class Explosion {

	Timer expTimer;
	// Temporary variable
	private int temp = 0;
	
	public Explosion() {
		expTimer = new Timer();
		expTimer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				if (Variables.collision) {
					if (temp < 15) {
						Variables.expAnimation = temp;
						temp++;
					} else if (temp == 15) {
						Variables.expAnimation = 15;
						temp = 0;
						Variables.collision = false;
					}
				}
			}
		}, 0, 30);
	}
}
