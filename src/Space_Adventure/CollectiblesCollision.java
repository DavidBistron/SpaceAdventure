package Space_Adventure;

// Specific class for Collectibles Collision
public class CollectiblesCollision extends CollisionHandler {
	public CollectiblesCollision() {
		// Start collision detection
		startCollisionDetection(Variables.collectiblesX1, Variables.collectiblesY1, 5, 50, 70, 30);
		startCollisionDetection(Variables.collectiblesX2, Variables.collectiblesY2, 5, 50, 70, 30);
	}

	@Override
	protected void handleCollision(int objectIndex) {
		// Specific logic for collectibles
		Variables.collect1 = true;
		// Additional logic for collectibles
	}
}