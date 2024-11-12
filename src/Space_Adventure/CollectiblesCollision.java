package Space_Adventure;

import java.util.Timer;
import java.util.TimerTask;

public class CollectiblesCollision {
	
	private Timer ccTimer;
	private int temp1 = 0;
	private int temp2 = 0;

	// Constructor
	public CollectiblesCollision() {
		ccTimer = new Timer();
		ccTimer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				// Collectible 1
				for (int i = 0; i <= 4; i++) {
					if (temp1 == 0) {
						if (Variables.ufoX >= Variables.collectiblesX1[i] - 50
								&& Variables.ufoX <= Variables.collectiblesX1[i] + 50
								&& Variables.ufoY >= Variables.collectiblesY1[i] - 70
								&& Variables.ufoY <= Variables.collectiblesY1[i] + 30) {
							Variables.collect1 = true;
							Variables.collectiblesY1[i] = -100;
							temp1++;
						}
					}
				}

				// Collectible 2
				for (int i = 0; i <= 4; i++) {
					if (temp2 == 0) {
						if (Variables.ufoX >= Variables.collectiblesX2[i] - 50
								&& Variables.ufoX <= Variables.collectiblesX2[i] + 50
								&& Variables.ufoY >= Variables.collectiblesY2[i] - 70
								&& Variables.ufoY <= Variables.collectiblesY2[i] + 30) {
							Variables.collect2 = true;
							Variables.collectiblesY2[i] = -100;
							temp2++;
						}
					}
				}

				// Timer, so you don`t hit every single Meteorite, you will have some time left
				// before next hit
				// --> low number (10) = hit every single meteorite --> high number (60) = more
				// time left before next hit!
				if ((temp1 >= 1 || temp2 >= 1) && (temp1 <= 30 || temp2 <= 30)) {
					temp1++;
					temp2++;
				} else if (temp1 == 11 || temp2 == 11) {
					temp1 = 0;
					temp2 = 0;
				}
			}
		}, 0, 15);
	}
}
