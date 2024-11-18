package Space_Adventure;

public class MainStartSpaceA {
	
	// Call all classes and instantiate new objects
	public static void main(String[] args) {

		// Frame, Variables, KeyHandler and GUI
		new StartGUI();
		new Variables();
		new Label();
		new KeyHandler();

		// Movements
		new BackgroundMovement();
		new PlayerMovement();
		new CollectiblesMovement();

		// Collisions
		new CollectiblesCollision();
		new MeteoriteCollision();

		// Animations
		new UfoLightsAnimation();
		new Explosion();
	}
}