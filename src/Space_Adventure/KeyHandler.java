package Space_Adventure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Class for handling movements of spaceship
public class KeyHandler implements KeyListener {

	// Constructor
	public KeyHandler() {
	}

	@Override
	// Key Type
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	// Press key
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			Variables.moveUp = true;
		} 
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			Variables.moveDown = true;
		} 
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			Variables.moveLeft = true;
		} 
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			Variables.moveRight = true;
		} 
	}

	@Override
	// Release Key
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			Variables.moveUp = false;
		} 
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			Variables.moveDown = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			Variables.moveLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			Variables.moveRight = false;
		}
	}
}