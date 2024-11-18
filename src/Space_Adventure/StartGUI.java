package Space_Adventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
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

public class StartGUI extends JFrame {

	// Icons
	private static final Icon iconNewGame = new ImageIcon("icons/start_game.png");
	private static final Icon iconHighscores = new ImageIcon("icons/highScore.png");
	private static final Icon iconOptions = new ImageIcon("icons/options.png");
	private static final Icon iconExitGame = new ImageIcon("icons/exit_game.png");
	private static final Icon iconDelorean = new ImageIcon("icons/delorean1a.png");

	private static Image background;

	// Constructor --> Create newObject of class StartGUI
	public StartGUI() {
		setupFrame();
		loadBackgroundImage();
		setupContentPane();
		playMusic();
	}

	// Set up main frame
	private void setupFrame() {
		setTitle("Space Adventure");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Variables.screenwitdh, Variables.screenheight);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	// Load background image
	private void loadBackgroundImage() {
		try {
			background = ImageIO.read(new File("attachments/space1.png"));
			setContentPane(new JPanel(new BorderLayout()) {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(background, 0, 0, null);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setupContentPane() {
		Container pane = getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		addButtonWithLabel(pane, "New Game", iconNewGame, e -> openNewGame());
		addButtonWithLabel(pane, "Highscores", iconHighscores, e -> openHighScores());
		addButtonWithLabel(pane, "How to Play", iconOptions, e -> openHowToPlay());
		addButtonWithLabel(pane, "Exit Game", iconExitGame, e -> exitGame());
		addButtonWithLabel(pane, "Special", iconDelorean, e -> playSpecialSound());

		setVisible(true);
	}

	// Method for adding buttons
	private void addButtonWithLabel(Container container, String labelText, Icon icon, ActionListener actionListener) {
		addLabel(labelText, container);

		JButton button = new JButton(icon);
		configureButton(button);
		button.addActionListener(actionListener);
		container.add(button);
	}

	// Method for adding labels
	private void addLabel(String text, Container container) {
		JLabel label = new JLabel(text);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setForeground(Color.GREEN);
		label.setPreferredSize(new Dimension(100, 50));
		container.add(label);
	}

	// Method for configuring buttons
	private void configureButton(JButton button) {
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(100, 50));
		button.setMinimumSize(new Dimension(80, 60));
		button.setMaximumSize(new Dimension(80, 60));
	}

	private void openNewGame() {
		dispose();
		new PlayerGUI();
	}

	private void openHighScores() {
		new HighScoreGUI();
	}

	private void openHowToPlay() {
		new HowToPlayGUI();
	}

	private void exitGame() {
		System.exit(0);
	}

	private void playSpecialSound() {
		new SoundEffects().SoundEffectsClick();
	}

	private void playMusic() {
		new SoundEffects().StartMenuMusic();
	}
}