package Space_Adventure;

public class MainStartSpaceA {
	
	// Call all classes and instantiate new objects
	public static void main(String[] args) {
		new StartGUI();
		new Variables();
		new Label();
		new KeyHandler();
		new BackgroundMovement();
		new PlayerMovement();
		new CollectiblesMovement();
		new CollectiblesCollision();
		new MeteoriteCollision();
		new UfoLightsAnimation();
		new Explosion();
	}
}
