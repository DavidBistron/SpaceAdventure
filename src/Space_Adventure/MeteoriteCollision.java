package Space_Adventure;

// Specific class for Meteorite Collision
public class MeteoriteCollision extends CollisionHandler {

	public MeteoriteCollision() {
		// Start collision detection
		startCollisionDetection(Variables.meteoritesX, Variables.meteoritesY, 7, 50, 70, 30);
	}

	@Override
	protected void handleCollision(int objectIndex) {
		// Specific logic for meteorites
		Variables.collision = true;
		Variables.meteoritesY[objectIndex] = -100;  // Reset meteorites
		if (Variables.energy > 0) {
			Variables.energy -= 1;
			updateLifeLabel();
		}
		if (Variables.energy == 0) {
			Variables.lostGame = true;
		}
	}

	// Updates Label for Live display
	private static void updateLifeLabel() {
		Variables.livesLabel.setText("Lives: " + Variables.energy);
	}
}