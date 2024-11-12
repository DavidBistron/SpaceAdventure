package Space_Adventure;

import java.util.Timer;
import java.util.TimerTask;

public class LostGame {

	private Timer lgTimer;
	// Temporary variables
	private int temp = 0;
	private int tempCollectibles1 = 0;
	private int tempCollectibles2 = 0;
	private int tempMeteorites = 0;
	
	public LostGame() {
		lgTimer = new Timer();
		lgTimer.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				
				if (Variables.lostGame) {
					if (temp >= 0 && temp <= 55) {
						temp++;
					} else if (temp == 56) {
						System.out.println("VERLOREN!");
						
						// Collectible 1
						for (int i = 0; i <= 4; i++) {
							Variables.collectiblesX1[i] = 20 + tempCollectibles1;
							Variables.collectiblesY1[i] = -200 - tempCollectibles1;
							
							tempCollectibles1 += 133;
						}
						
						// Collectible 2
						for (int i = 0; i <= 4; i++) {
							Variables.collectiblesX2[i] = 44 + tempCollectibles2;
							Variables.collectiblesY2[i] = -2000 - tempCollectibles2;
							
							tempCollectibles2 += 280;
						}
						
						// set meteorites
						for (int i = 0; i <= 6; i++) {
							Variables.meteoritesY[i] = 0;
						}
						
						for (int i = 0; i <= 6; i++) {
							Variables.meteoritesY[i] = -100 - tempMeteorites;
							tempMeteorites += 133;
						}
						temp = 0;
						
						// if --> for Points? see Video 08 Minute 07:00
						
						Variables.energy = Variables.maxEnergy;
						Variables.lostGame = false;	
					}
				}
			}
		}, 0, 15);
	}
}
