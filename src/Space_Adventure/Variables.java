package Space_Adventure;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.*;

// Class to collect all variables
public class Variables {

	// General Screen properties
	public static int screenwitdh = 800, screenheight = 600;

	// Label for displaying life points and shield
	public static JLabel livesLabel;
	public static JLabel shieldLabel;

	// Timer for shield and OFF by default
	public static Timer shieldTimer;
	public static boolean shieldActive = false;

	// KeyHandler Variables (standard = false, so movements don't take place arbitrarily)
	public static boolean moveUp = false, moveDown = false, moveLeft = false, moveRight = false;
	
	// Background Variables
	public static BufferedImage spaceImage1, spaceImage2;
	public static int backgroundY1 = 0;
	public static int backgroundY2 = -600; // -600, because screen height = 600
	
	// SpaceShip Variables
	public static BufferedImage imageUfo;
	public static BufferedImage imageRocket;
	public static BufferedImage imageDelorean;
	static int ufoX = 400, ufoY = 400; 
	static int speedUp = 5, speedDown = 5, speedLeft = 5, speedRight = 5;
	static int energy = 5;
	static int maxEnergy = 5;
		
	// SpaceShip Tail Variables (Animation of engine)
	public static BufferedImage ufoLights1, ufoLights2;
	public static BufferedImage rocketLights1, rocketLights2;
	public static BufferedImage deloreanLights1, deloreanLights2;
	public static int animatedLights;

	// Meteorite Variables
	public static BufferedImage imageMeteorite;
	public static int[] meteoritesX = new int[10];
	public static int[] meteoritesY = new int[10];

	// Collision --> default = false
	public static Image iconHit;
	public static boolean collision = false;
	public static boolean lostGame = false;
	public static int expAnimation;

	// Collectibles Variables
	public static BufferedImage imageAstronaut;
	public static BufferedImage imageET;
	public static int[] collectiblesX1 = new int [5];
	public static int[] collectiblesY1 = new int [5];
	public static int[] collectiblesX2 = new int [5];
	public static int[] collectiblesY2 = new int [5];
	public static int[] collectiblesSpeed1 = new int [6];
	public static int[] collectiblesSpeed2 = new int [3];

	// Collecting --> default = false
	public static boolean collect1 = false;
	// public static boolean collect2 = false;

	// Constructor
	public Variables() {
		try {
			// Background --> The same image is instantiated 2x and repeated like on an assembly line
			spaceImage1 = ImageIO.read(new File("attachments/space1.png"));
			spaceImage2 = ImageIO.read(new File("attachments/space1.png"));
			
			// Ufo
			imageUfo = ImageIO.read(new File("attachments/ufo.png"));
			// Ufo light
			ufoLights1 = ImageIO.read(new File("attachments/ufolights_r.png"));
			ufoLights2 = ImageIO.read(new File("attachments/ufolights_l.png"));
			
			// Rocket
			imageRocket = ImageIO.read(new File("attachments/rocket.png"));
			// Rocket light
			rocketLights1 = ImageIO.read(new File("attachments/rocketlights_fire_l.png"));
			rocketLights2 = ImageIO.read(new File("attachments/rocketlights_fire_r.png"));
			
			// Delorean
			imageDelorean = ImageIO.read(new File("attachments/delorean.png"));
			// DeLorean light
			deloreanLights1 = ImageIO.read(new File("attachments/delorean_fire_l.png"));
			deloreanLights2 = ImageIO.read(new File("attachments/delorean_fire_r.png"));
			
			// Meteorite
			imageMeteorite = ImageIO.read(new File("attachments/meteorite.png"));
			
			// Collision with Meteorite
			// imageHitMeteorite = ImageIO.read(new File("attachments/explosion.gif"));
			iconHit = new ImageIcon("attachments/explosion.gif").getImage();
			
			// Collectibles 
			imageAstronaut = ImageIO.read(new File("attachments/astronaut.png"));
			imageET = ImageIO.read(new File("attachments/ET.png"));

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found.");
		}

		// Set individual speed of collectibles

		// Standard collectible
		collectiblesSpeed1[0] = 2;
		collectiblesSpeed1[1] = 3;
		collectiblesSpeed1[2] = 2;
		collectiblesSpeed1[3] = 3;
		collectiblesSpeed1[4] = 4;
		collectiblesSpeed1[5] = 3;

		// Rare collectible
		collectiblesSpeed2[0] = 4;
		collectiblesSpeed2[1] = 6;
		collectiblesSpeed2[2] = 5;
	}
}