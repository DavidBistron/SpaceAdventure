package Space_Adventure;

import javax.swing.*;
import java.awt.*;

public class GUI {
	// Main-Label variables
	public static Label label;
	public static JFrame frame;

	MeteoriteMovement mM;

	// Constructor
	@SuppressWarnings("static-access")
	public GUI() {

		frame = new JFrame();
		frame.setTitle("Space Adventure");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(Variables.screenwitdh, Variables.screenheight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.addKeyListener(new KeyHandler());
		frame.requestFocus(); 	// necessary for KeyHandler
		frame.setVisible(true);

		// Label for displaying life points
		Variables.livesLabel = new JLabel("Lives: " + Variables.energy);
		Variables.livesLabel.setBounds(10, 10, 100, 30); // Position des Labels in der oberen linken Ecke
		Variables.livesLabel.setForeground(Color.WHITE);
		frame.add(Variables.livesLabel);

		// Label for displaying shield ON/OFF
		Variables.shieldLabel = new JLabel("Shield: OFF");
		// Label position
		Variables.shieldLabel.setBounds(10, 40, 100, 30);
		Variables.shieldLabel.setForeground(Color.GREEN);
		frame.add(Variables.shieldLabel);

		label = new Label();
		label.setBounds(0, 0, Variables.screenwitdh, Variables.screenheight);
		label.setVisible(true);
		frame.add(label);

		mM = new MeteoriteMovement();
	}
}