package Space_Adventure;

import java.util.Timer;
import java.util.TimerTask;

public class CollectiblesMovement {
	Timer cmTime;
	private int temp = 0;
	private int temp1 = 0;
	
	// Constructor
	public CollectiblesMovement() {
		
		// Collectible 1
		for (int i = 0; i <= 4; i++) {
			Variables.collectiblesX1[i] = 20 + temp;
			Variables.collectiblesY1[i] = -200 - temp;
			
			temp += 133;
		}
		
		// Collectible 2
		for (int i = 0; i <= 4; i++) {
			Variables.collectiblesX2[i] = 44 + temp1;
			Variables.collectiblesY2[i] = -2000 - temp1;
			
			temp1 += 280;
		}
		
		cmTime = new Timer();
		cmTime.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				// Collectible 1
				for (int i = 0; i <= 4; i++) {
					Variables.collectiblesY1[i] += Variables.collectiblesSpeed1[i];
					
					if (Variables.collectiblesY1[i] >= Variables.screenheight) {
						Variables.collectiblesY1[i] = -350;
					}
				}
				
				// Collectible 2
				for (int i = 0; i <= 2; i++) {
					Variables.collectiblesY2[i] += Variables.collectiblesSpeed2[i];
					
					if (Variables.collectiblesY2[i] >= Variables.screenheight) {
						Variables.collectiblesY2[i] = -2500;
					}
				}
			}
		}, 0, 10);
	}
}