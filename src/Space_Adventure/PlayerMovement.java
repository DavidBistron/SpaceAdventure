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
				if (Variables.moveUp == true) {
					if (Variables.ufoY > 0) { 					// Abhängig von der Bildgröße! Bild ist auf Y-Achse 600 Pixel groß; oben links = 0 = Beginn [damit das Ufo nicht aus dem Bild fliegen kann 0]
						Variables.ufoY -= Variables.speedUp;
					}
				} else if (Variables.moveDown == true) {
					if (Variables.ufoY <= 495) { 				// Abhängig von der Bildgröße! Bild ist auf Y-Achse 600 Pixel groß; Ufo selbst ist 70 Pixel hoch; damit das Ufo nicht aus dem Bild fliegen kann 490
						Variables.ufoY += Variables.speedDown;
					}
				}

				if (Variables.moveLeft == true) {
					if (Variables.ufoX > 10) {
						Variables.ufoX -= Variables.speedLeft;
					}
				} else if (Variables.moveRight == true) {
					if (Variables.ufoX <= 720) { 				// Abhängig von der Bildgröße! Bild ist auf X-Achse 800 Pixel groß; Ufo selbst ist 50 Pixel breit; damit das Ufo nicht aus dem Bild fliegen kann 490
						Variables.ufoX += Variables.speedRight;
					}
				}
			}
		}, 0, 10); // Wdh. nach 10 Milisekunden
	}
}
