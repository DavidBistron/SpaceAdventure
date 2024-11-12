package Space_Adventure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	// Constructor --> not needed, because no objects to create
	public KeyHandler() {
	}

	@Override
	// Die 3 Methoden keyTyped, keyPressed und keyReleased sind verpflichtend, wenn der KeyListener implementiert wird!
	// gedr�ckt und wieder losgelassen wird --> tippen
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	// gedr�ckt und gehalten --> dr�cken
	public void keyPressed(KeyEvent e) {
		// Wenn die Pfeiltaste OBEN gedr�ckt wird = Bewegung
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			Variables.moveUp = true;
		} 
		// Wenn die Pfeiltaste UNTEN gedr�ckt wird = Bewegung
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			Variables.moveDown = true;
		} 
		// Wenn die Pfeiltaste LINKS gedr�ckt wird = Bewegung
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			Variables.moveLeft = true;
		} 
		// Wenn die Pfeiltaste RECHTS gedr�ckt wird = Bewegung
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			Variables.moveRight = true;
		} 
	}

	@Override
	// loslassen		
	public void keyReleased(KeyEvent e) {
		// Wenn die Pfeiltaste OBEN losgelassen wird = !Bewegung
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			Variables.moveUp = false;
		} 
		// Wenn die Pfeiltaste UNTEN losgelassen wird = !Bewegung
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			Variables.moveDown = false;
		}
		// Wenn die Pfeiltaste LINKS losgelassen wird = !Bewegung
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			Variables.moveLeft = false;
		}
		// Wenn die Pfeiltaste RECHTS losgelassen wird = !Bewegung
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			Variables.moveRight = false;
		}
	}
}
