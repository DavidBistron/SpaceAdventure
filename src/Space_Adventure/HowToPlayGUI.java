package Space_Adventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HowToPlayGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private static JFrame howTo_frame;
	private static JLabel label;
	private static JPanel pnl_btn;
	private static JButton btn_confirm;
	private static JButton btn_ger;
	private static JButton btn_eng;
	private static Image bg;
	
	private static Icon ger = new ImageIcon("icons/ger.png");
	private static Icon eng = new ImageIcon("icons/eng.png");

	@SuppressWarnings({ "serial", "static-access" })
	public HowToPlayGUI() {

		howTo_frame = new JFrame("How to play the game");
		howTo_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		howTo_frame.setSize(Variables.screenwitdh, Variables.screenheight);
		howTo_frame.setLocationRelativeTo(null);
		howTo_frame.setResizable(false);

		// draw background
		try {
			bg = ImageIO.read(new File("attachments/space1.png"));
			howTo_frame.setContentPane(new JPanel(new BorderLayout()) {
				public void paintComponent(Graphics g) {
					g.drawImage(bg, 0, 0, null);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// add components to pane
		addComponentsToPane(howTo_frame.getContentPane());
		howTo_frame.setVisible(true);
	}

	public static void addLabel(String text, Container container) {
		// JLabel label = new JLabel(text);
		label = new JLabel(text);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setForeground(Color.WHITE);
		label.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		label.setPreferredSize(new Dimension(700, 55));
		label.setMinimumSize(new Dimension(700, 55));
		label.setMaximumSize(new Dimension(700, 55));
		label.setFont(new Font("Serif", Font.ITALIC, 18));
		container.add(label);
	}
	
	public static void deleteLabelText(String text, Container container) {
		container.remove(label);
	}

	public static void buttonProperties(JButton button) {
		button.setPreferredSize(new Dimension(110, 60));
		button.setMinimumSize(new Dimension(100, 50));
		button.setMaximumSize(new Dimension(100, 50));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
	}

	public static void addComponentsToPane(Container pane) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		FlowLayout flow = new FlowLayout();		
		pnl_btn = new JPanel(flow);
		pnl_btn.setBackground(Color.BLACK);
		
		btn_confirm = new JButton("Back to Main Menu");
		btn_confirm.setBackground(Color.BLACK);
		btn_confirm.setForeground(Color.GREEN);
		
		btn_ger = new JButton();
		btn_ger.setIcon(ger);
		btn_ger.setPreferredSize(new Dimension(100,100));
		btn_ger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLabel("Willkommen zum Space-Adventure!", pane);
				addLabel("Beschreibung:", pane);
				addLabel("In diesem Spiel fliegst du durch das Weltall und bahnst dir einen Weg durch die Meteoriten!", pane);
				addLabel("Sammle die umherfliegenden Astronauten ein, um Punkte zu sammeln!", pane);
				addLabel("Steuerung:", pane);
				addLabel("Nutze die Pfeiltasten oder W, A, S, D auf deiner Tastatur, um dein Raumschiff zu steuern!", pane);
				addLabel("Spielstart:", pane);
				addLabel("Klicke auf 'Start Game', waehle dein Raumschiff aus und bestaetige deine Auswahl!", pane);
				howTo_frame.revalidate();
				// howTo_frame.repaint();
			}
		});
		
		btn_eng = new JButton();
		btn_eng.setIcon(eng);
		btn_eng.setPreferredSize(new Dimension(100,100));
		btn_eng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLabel("Welcome to Space-Adventure!", pane);
				addLabel("Description:", pane);
				addLabel("In this game you have to fly through space and find a way between the meteorites!", pane);
				addLabel("Collect the astronauts flying around to score points!", pane);
				addLabel("How to fly:", pane);
				addLabel("Use Arrow Keys or W, A, S, D on your keyboard to fly your spaceship!", pane);
				addLabel("Start Game:", pane);
				addLabel("Click on 'Start Game' and choose your spaceship and confirm your selection!", pane);
				howTo_frame.revalidate();
				// howTo_frame.repaint();
			}
		});
		
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				howTo_frame.dispose();
			}			
		});
		
		pnl_btn.add(btn_ger);
		pnl_btn.add(btn_eng);
		pnl_btn.add(btn_confirm);
		
		pane.add(pnl_btn);
	}	
}