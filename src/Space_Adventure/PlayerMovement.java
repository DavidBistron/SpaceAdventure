package Space_Adventure;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerMovement {

	Timer pmTime;

	public PlayerMovement() {
		pmTime = new Timer();
		pmTime.scheduleAtFixedRate(new TimerTask() {

			// Hier abfragen, ob die boolean-Variablen des Movements (Klasse KeyHandler) auf
			// True gesetzt sind, wenn ja = Bewegung erfolgt
			@Override
			public void run() {
				if (Variables.moveUp) {
					// Depending on the screen size! Image size on Y-axis is 600 pixels; top left = 0 = start [so that the UFO cannot fly out of the image 0]
					if (Variables.ufoY > 0) {
						Variables.ufoY -= Variables.speedUp;
					}
				} else if (Variables.moveDown) {
					// Depending on the screen size! Image is 600 pixels on Y-axis; UFO itself is 70 pixels high; so that the UFO cannot fly out of the image 490
					if (Variables.ufoY <= 495) {
						Variables.ufoY += Variables.speedDown;
					}
				}

				if (Variables.moveLeft) {
					if (Variables.ufoX > 10) {
						Variables.ufoX -= Variables.speedLeft;
					}
				} else if (Variables.moveRight) {
					if (Variables.ufoX <= 720) {
						Variables.ufoX += Variables.speedRight;
					}
				}
			}
		}, 0, 10); // Repeat after 10 milliseconds
	}
}