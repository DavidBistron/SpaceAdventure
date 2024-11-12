package Space_Adventure;

import java.util.Timer;
import java.util.TimerTask;

public class MeteoriteCollision {

	private Timer mcTimer;
	private int temp = 0;
	
	// Constructor
	public MeteoriteCollision() {
		mcTimer = new Timer();
		mcTimer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				for (int i = 0; i <= 6; i++) {
					if (temp == 0) {

						// use -50 && +75 etc. so that not only one coordinate point is compared
						// (enlarge the hit field)
						if (Variables.ufoX >= Variables.meteoritesX[i] - 50
								&& Variables.ufoX <= Variables.meteoritesX[i] + 50
								&& Variables.ufoY >= Variables.meteoritesY[i] - 70
								&& Variables.ufoY <= Variables.meteoritesY[i] + 30) {
							Variables.collision = true;
							// =-100 so that the meteorite does not fly through the UFO, but is placed back
							// at top of the screen
							Variables.meteoritesY[i] = -100;

							if (Variables.energy >= 1) {
								Variables.energy -= 1;
							}

							if (Variables.energy == 0) {
								Variables.lostGame = true;
							}

							else if (Variables.energy > 0) {
								Variables.lostGame = false;
							}

							temp++;
						}
					}
				}

				// Timer, so you don`t hit every single Meteorite, you will have some time left
				// before next hit
				// --> low number (10) = hit every single meteorite --> high number (60) = more
				// time left before next hit!
				if (temp >= 1 && temp <= 10) {
					temp++;
				} else if (temp == 11) {
					temp = 0;
				}
			}
		}, 0, 15);
	}
}
