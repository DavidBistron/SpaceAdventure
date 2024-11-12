package Space_Adventure;

import javax.swing.JFrame;

public class GUI {
	
	MeteoriteMovement mM;

	// Constructor
	@SuppressWarnings("static-access")
	public GUI() {
		
		Variables.frame = new JFrame();
		Variables.frame.setTitle("Space Adventure");
		Variables.frame.setDefaultCloseOperation(Variables.frame.EXIT_ON_CLOSE);
		Variables.frame.setSize(Variables.screenwitdh, Variables.screenheight);
		Variables.frame.setLocationRelativeTo(null);
		Variables.frame.setResizable(false);
		// Variables.frame.setLayout(null);	// no layout needed, drawing is done on the label
		
		Variables.frame.addKeyListener(new KeyHandler());
		Variables.frame.requestFocus(); 	// necessary for KeyHandler

		Variables.frame.setVisible(true);
		
		Variables.label = new Label();
		Variables.label.setBounds(0, 0, Variables.screenwitdh, Variables.screenheight);
		Variables.label.setVisible(true);
		Variables.frame.add(Variables.label);
		
		// Code only needed, if working with a second screen; call method and select Screen 1
		SecondScreen ss = new SecondScreen();
		ss.showOnScreen(1, Variables.frame);
		
		// Music
		// Music.sounds("audio/InGame.wav");
		
		mM = new MeteoriteMovement();
	}	
}
