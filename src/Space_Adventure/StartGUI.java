package Space_Adventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartGUI extends JFrame {
	
	// Buttons only for Start-Screen
	public static JButton btn_newGame, btn_highScores, btn_options, btn_exit, btn_deLorean;
	public static JFrame startFrame;
		
	private static Image bg;
	
	private static Icon iconNewGame = new ImageIcon("icons/start_game.png");
	// Icon iconNewGame = new ImageIcon(getClass().getClassLoader().getResource("start_game.png")); --> for exe & jar file
	private static Icon iconHighscores = new ImageIcon("icons/highScore.png");
	private static Icon iconOptions = new ImageIcon("icons/options.png");
	private static Icon iconExitGame = new ImageIcon("icons/exit_game.png");
	private static Icon iconDelorean = new ImageIcon("icons/delorean1a.png");
	
	// Constructor --> Create newObject of class StartGUI
	@SuppressWarnings({ "static-access" })
	public StartGUI() {

		startFrame = new JFrame();
		startFrame.setTitle("Space Adventure");
		startFrame.setDefaultCloseOperation(startFrame.EXIT_ON_CLOSE);
		startFrame.setSize(Variables.screenwitdh, Variables.screenheight);
		startFrame.setLocationRelativeTo(null);
		startFrame.setResizable(false);
	
		// Draw background
		try {
			bg = ImageIO.read(new File("attachments/space1.png"));
			startFrame.setContentPane(new JPanel(new BorderLayout()) {
				public void paintComponent(Graphics g) {
					g.drawImage(bg, 0, 0, null);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Set up the content pane
		addComponentsToPane(startFrame.getContentPane());
		startFrame.setVisible(true);
		
		// Music
		// Music.sounds("audio/StartScreen.wav"); --> old Version --> could only play one song while game is running
		new SoundEffects().StartMenuMusic();
		
		// Code only needed, if working with a second screen; call method and select Screen 1
		// SecondScreen ss = new SecondScreen();
		// ss.showOnScreen(1, startFrame);
	}
	
	/* --> not used, difficult to add a ActionListener to buttons
	private static void addButton(JButton name, Icon icon, Container container) {
		JButton button = new JButton(icon);		
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(100, 50));
		button.setMinimumSize(new Dimension(100,50));
		button.setMaximumSize(new Dimension(100,50));
		container.add(button);
	}
	*/
	
	// Options for Text above Buttons in Main Menu
	public static void addLabel(String text, Container container) {
		JLabel label = new JLabel(text);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setForeground(Color.GREEN);
		label.setPreferredSize(new Dimension(100,50));
		label.setMinimumSize(new Dimension(100,50));
		label.setMaximumSize(new Dimension(100,50));
		container.add(label);
	}
	
	// Options for Buttons in Main Menu
	public static void buttonProperties(JButton button) {
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(100,50));
		button.setMinimumSize(new Dimension(80,60));
		button.setMaximumSize(new Dimension(80,60));
		
	}
	
	// Add Text and Buttons to the Screen
	public static void addComponentsToPane(Container pane) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		addLabel("New Game", pane);
		btn_newGame = new JButton();
		btn_newGame.setIcon(iconNewGame);
		buttonProperties(btn_newGame);
		pane.add(btn_newGame);
		
		btn_newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new SoundEffects().SoundEffectsClick();
				startFrame.dispose();
				new PlayerGUI();
			}
		});
		
		addLabel("Highscores", pane);
		btn_highScores = new JButton();
		btn_highScores.setIcon(iconHighscores);
		buttonProperties(btn_highScores);
		pane.add(btn_highScores);
		
		btn_highScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new SoundEffects().SoundEffectsClick();
				new HighScoreGUI();	
			}
		});
		
		addLabel("How to play", pane);
		btn_options = new JButton();
		btn_options.setIcon(iconOptions);
		buttonProperties(btn_options);
		pane.add(btn_options);
		
		btn_options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new SoundEffects().SoundEffectsClick();
				new HowToPlayGUI(); // new GUI with instructions how to play --> use Arrow Keys or W, A, S, D
			}
		});
		
		addLabel("Exit Game", pane);
		btn_exit = new JButton();
		btn_exit.setIcon(iconExitGame);
		buttonProperties(btn_exit);
		pane.add(btn_exit);
		
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
				
		addLabel("Special", pane);
		btn_deLorean = new JButton();
		btn_deLorean.setIcon(iconDelorean);
		buttonProperties(btn_deLorean);
		pane.add(btn_deLorean);
		
		btn_deLorean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SoundEffects().SoundEffectsClick();	
			}
		});
	}	
}
