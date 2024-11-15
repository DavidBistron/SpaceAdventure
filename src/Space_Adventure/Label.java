package Space_Adventure;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Class for painting the background, images etc.
public class Label extends JLabel {

	private static final long serialVersionUID = 1L;
	
	/*
	// solution to show GIF
	JLabel imageLabel = new JLabel();
	ImageIcon ii = new ImageIcon(this.getClass().getResource("explosion.gif"));
	*/
	
	private JPanel pnl_restart;
	private JButton btn_restart;
	
	// Constructor --> not needed, because no objects to create
	public Label() {
		// imageLabel.setIcon(ii);
	}
	
	// Method for painting components
	// Order of images is important
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Decission for game lost or not
		// if game lost = false
		if (!Variables.lostGame) {
			
		// Necessary code snippet for correct graphics
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		/* Background
		*  paint commands --> null = observer --> not needed, therefore null
		*  x = 0, top left of the screen
		*  y = different
		*/
		g.drawImage(Variables.spaceImage1, 0, Variables.backgroundY1, 800, 600, null);
		g.drawImage(Variables.spaceImage2, 0, Variables.backgroundY2, 800, 600, null);
				
		// Collectibles
		for (int i = 0; i <= 4; i++) {
			g.drawImage(Variables.imageAstronaut, Variables.collectiblesX1[i], Variables.collectiblesY1[i], 80, 60, null);
		}
		
		for (int i = 0; i <= 4; i++) {
			g.drawImage(Variables.imageET, Variables.collectiblesX2[i], Variables.collectiblesY2[i], 50, 30, null);
		}
		
		// Loop, because of Array with 5 meteorites --> shouldn't be larger than Array [Variables.meteoritesX.length]
		for (int i = 0; i <= 6; i++) {
			g.drawImage(Variables.imageMeteorite, Variables.meteoritesX[i], Variables.meteoritesY[i], 80, 60, null);
		}
		
		// SpaceShips
		if (ChooseSpaceShipGUI.radio_btn_ufo.isSelected() == true) {
			g.drawImage(Variables.imageUfo, Variables.ufoX, Variables.ufoY, 50, 70, null);
		} else if (ChooseSpaceShipGUI.radio_btn_rocket.isSelected() == true) {
			g.drawImage(Variables.imageRocket, Variables.ufoX, Variables.ufoY, 50, 70, null);
		} else if (ChooseSpaceShipGUI.radio_btn_deLorean.isSelected() == true) {
			g.drawImage(Variables.imageDelorean, Variables.ufoX, Variables.ufoY, 50, 70, null);
		}
		
		// Tail animation --> Y+60, because otherwise lights will be placed in SpaceShip!
		if (ChooseSpaceShipGUI.radio_btn_ufo.isSelected() == true) {
			if (Variables.animatedLights == 0) {
				g.drawImage(Variables.ufoLights1, Variables.ufoX, Variables.ufoY+45, 50, 50, null);
			} else if (Variables.animatedLights == 1) {
				g.drawImage(Variables.ufoLights2, Variables.ufoX, Variables.ufoY+45, 50, 50, null);
			}
		} else if (ChooseSpaceShipGUI.radio_btn_rocket.isSelected() == true) {
			if (Variables.animatedLights == 0) {
				g.drawImage(Variables.rocketLights1, Variables.ufoX, Variables.ufoY+60, 50, 50, null);
			} else if (Variables.animatedLights == 1) {
				g.drawImage(Variables.rocketLights2, Variables.ufoX, Variables.ufoY+60, 50, 50, null);
			}
		} else if (ChooseSpaceShipGUI.radio_btn_deLorean.isSelected() == true) {
			if (Variables.animatedLights == 0) {
				g.drawImage(Variables.deloreanLights1, Variables.ufoX, Variables.ufoY+45, 70, 70, null);
			} else if (Variables.animatedLights == 1) {
				g.drawImage(Variables.deloreanLights2, Variables.ufoX, Variables.ufoY+45, 70, 70, null);
			}
		}
		
		// Explosion animation
		if (Variables.collision) {
				g.drawImage(Variables.iconHit, Variables.ufoX-10, Variables.ufoY-10, 70, 70, null);
				new SoundEffects().SoundEffectsClick();
		}
		
		// if game lost = true
		} else if (Variables.lostGame) {
			g.drawImage(Variables.spaceImage1, 0, Variables.backgroundY1, 800, 600, null);
			g.drawImage(Variables.spaceImage2, 0, Variables.backgroundY2, 800, 600, null);
			g.setColor(new Color(130, 0, 15));
			g.setFont(new Font("Arial",Font.BOLD, 35));
			g.drawString("Game Over!", 310, 200);
			
			g.drawString("Press 'R' to restart game!", 195, 300);
						
			repaint();
			// new SoundEffects().SoundEffectsLostGame();
		}

		// Necessary method to draw the images constantly, not only once! If only once drawed, images will disappear immediately!
		repaint();
	}
	
	public void restartGame(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_R) {
			paintComponent(getGraphics());
		}
	}
}
