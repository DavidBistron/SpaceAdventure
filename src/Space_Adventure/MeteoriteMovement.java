package Space_Adventure;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MeteoriteMovement {
	
	Timer mmTime;
	Timer randomTime;
	// Temporary variable
	private int temp = 0;
	
	/*
	Random r = new Random();
	double rDouble = r.nextDouble()*10;
	int randomInt = (int) rDouble;
	*/
	
	// Constructor
	public MeteoriteMovement() {
				
		// Step 1: Set standard position of meteorites
		// Variables.meteoritesX.length;
		for (int i = 0; i <= 6; i++) {
			// 20 = default
			Variables.meteoritesX[i] = 20 + temp;
			// -100 = to be vertically displaced
			Variables.meteoritesY[i] = -100 - temp;
			// 5 meteorites --> 800 pixel width --> 800 / 5 = 160
			temp += 133;
		}
		// Step 2: set movement of meteorites
		mmTime = new Timer();
		mmTime.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// needed for random speed
				Random r = new Random(System.currentTimeMillis());
				double rDouble = r.nextDouble()*10;
				int randomInt = (int) rDouble;
				
				for (int i = 0; i <= 6; i++) {
					// Variable.meteoritesy[i] += Variables.meteoritesSpeed[i];
					Variables.meteoritesY[i] += randomInt;
					// System.out.println(randomInt);
						
					if (Variables.meteoritesY[i] >= Variables.screenheight) {
						Variables.meteoritesY[i] = -100;
						try {
							TimeUnit.SECONDS.sleep((long) 0.5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					rDouble = r.nextDouble()*10; 
					randomInt = (int) rDouble;
				}
			}
		}, 0, 10);	// 0 = firstTime; 10 = period (every 10 miliseconds new meteorites appear)
	}
}
