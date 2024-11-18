package Space_Adventure;

import javax.swing.JFrame;

public class GUI {
	// Main-Label variables
	public static Label label;
	MeteoriteMovement mM;
	public static JFrame frame;

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
		
		label = new Label();
		label.setBounds(0, 0, Variables.screenwitdh, Variables.screenheight);
		label.setVisible(true);
		frame.add(label);

		mM = new MeteoriteMovement();
	}	
}