package Space_Adventure;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class SecondScreen {

	// Constructor
	public SecondScreen() {
	}
	
	// Decide where to display the game
	public static void showOnScreen(int screen, JFrame frame) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		if (screen > -1 && screen < gs.length) {
			frame.setLocation(gs[screen].getDefaultConfiguration().getBounds().x, frame.getY());
		} else if (gs.length > 0) {
			frame.setLocation(gs[0].getDefaultConfiguration().getBounds().x, frame.getY());
		} else {
			throw new RuntimeException("No Screens Found");
		}
	}
}
