package Space_Adventure;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

import javax.swing.*;

public class ChooseSpaceShipGUI extends JFrame {

	@Serial
	private static final long serialVersionUID = 1L;

	// Variables
	private static JFrame choose_frame;
	private static JLabel lbl_spaceShip;
	public static JRadioButton radio_btn_ufo, radio_btn_deLorean, radio_btn_rocket;
	private static JButton btn_confirm;

    // Spaceships Images
	private static final Icon iconUfo = new ImageIcon("attachments/ufo.png");
	private static final Icon iconDelorean = new ImageIcon("attachments/delorean1.2.png");
	private static final Icon iconRocket = new ImageIcon("attachments/rocket.png");

	// SpaceshipGUI - Modular structure
	public ChooseSpaceShipGUI() {
		initFrame();		// Initialises main frame
		initComponents();	// Initialises components
		layoutComponents();	//
		setupListeners();
	}

	// Main Frame
	private void initFrame() {
		choose_frame = new JFrame("Spaceship-Options");
		choose_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		choose_frame.setPreferredSize(new Dimension(Variables.screenwitdh, Variables.screenheight));
		choose_frame.getContentPane().setLayout(new BorderLayout());
	}

	// Components
	private void initComponents() {
        String playerName = PlayerGUI.getTxtName();

		// Initialize labels
		lbl_spaceShip = new JLabel("Welcome Commander " + playerName + "! Select your Spaceship!");
		lbl_spaceShip.setOpaque(true);
		lbl_spaceShip.setBackground(Color.BLACK);
		lbl_spaceShip.setForeground(Color.GREEN);
		lbl_spaceShip.setFont(new Font("Serif", Font.ITALIC, 22));
		lbl_spaceShip.setPreferredSize(new Dimension(100, 100));
		lbl_spaceShip.setHorizontalAlignment(SwingConstants.CENTER);

		// Initialize radio buttons
		radio_btn_ufo = new JRadioButton("Ufo", iconUfo);
		radio_btn_ufo.setSelected(true);
		configureRadioButton(radio_btn_ufo);

		radio_btn_rocket = new JRadioButton("Rocket", iconRocket);
		configureRadioButton(radio_btn_rocket);

		radio_btn_deLorean = new JRadioButton("Delorean", iconDelorean);
		configureRadioButton(radio_btn_deLorean);

		// Initialise button group
        ButtonGroup btn_group = new ButtonGroup();
		btn_group.add(radio_btn_ufo);
		btn_group.add(radio_btn_rocket);
		btn_group.add(radio_btn_deLorean);

		// Initialise confirm button
		btn_confirm = new JButton("Confirm selection and start game!");
		btn_confirm.setForeground(Color.GREEN);
		btn_confirm.setBackground(Color.BLACK);
		btn_confirm.setPreferredSize(new Dimension(50, 50));
	}

	private void layoutComponents() {
		// Layout the components
		choose_frame.add(lbl_spaceShip, BorderLayout.PAGE_START);
		choose_frame.add(radio_btn_ufo, BorderLayout.LINE_START);
		choose_frame.add(radio_btn_rocket, BorderLayout.CENTER);
		choose_frame.add(radio_btn_deLorean, BorderLayout.LINE_END);
		choose_frame.add(btn_confirm, BorderLayout.PAGE_END);

		choose_frame.pack();
		choose_frame.setVisible(true);
	}

	// Method for configuring ratioButtons -> Standardised configuration
	private void configureRadioButton(JRadioButton radioButton) {
		radioButton.setBackground(Color.BLACK);
		radioButton.setForeground(Color.WHITE);
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
	}

	// Method for confirm-btn (new Listeners should be added here)
	private void setupListeners() {
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose_frame.dispose();
				SoundEffects.stop();
				new GUI();	// Opens the "playing" GUI
				new SoundEffects().LevelOneMusic();
			}
		});
	}
}