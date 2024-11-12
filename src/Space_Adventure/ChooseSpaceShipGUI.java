package Space_Adventure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ChooseSpaceShipGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static JFrame choose_frame;
	public static JLabel lbl_spaceShip;
	public static JRadioButton radio_btn_ufo, radio_btn_deLorean, radio_btn_rocket;
	public static JButton btn_confirm;
		
	private static Icon iconUfo = new ImageIcon("attachments/ufo.png");
	private static Icon iconDelorean = new ImageIcon("attachments/delorean1.2.png");
	private static Icon iconRocket = new ImageIcon("attachments/rocket.png");
	
	private static ButtonGroup btn_group;
	
	private String playerName;
	
	JLabel picture;
	
	@SuppressWarnings("static-access")
	public ChooseSpaceShipGUI() {	
		
		choose_frame = new JFrame("Special-Options");
		choose_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		choose_frame.setPreferredSize(new Dimension(Variables.screenwitdh, Variables.screenheight));
		// choose_frame.setLocationRelativeTo(null);
		
		BorderLayout border = new BorderLayout();
		choose_frame.getContentPane().setLayout(border);
		
		playerName = PlayerGUI.getTxtName();
				
		lbl_spaceShip = new JLabel("Welcome Commander " + playerName + "! Select your Spaceship!");
		lbl_spaceShip.setOpaque(true);
		lbl_spaceShip.setBackground(Color.BLACK);
		lbl_spaceShip.setForeground(Color.WHITE);
		lbl_spaceShip.setFont(new Font("Serif", Font.ITALIC, 22));
		lbl_spaceShip.setPreferredSize(new Dimension(100,100));
		lbl_spaceShip.setHorizontalAlignment(SwingConstants.CENTER);
				
		radio_btn_ufo = new JRadioButton("Ufo", iconUfo);
		radio_btn_ufo.setSelected(true);
		radio_btn_ufo.setBackground(Color.GRAY);
		radio_btn_ufo.setForeground(Color.WHITE);
		
		radio_btn_rocket = new JRadioButton("Rocket", iconRocket);
		radio_btn_rocket.setHorizontalAlignment(SwingConstants.CENTER);
		radio_btn_rocket.setBackground(Color.GRAY);
		radio_btn_rocket.setForeground(Color.WHITE);
		
		radio_btn_deLorean = new JRadioButton("Delorean", iconDelorean);
		radio_btn_deLorean.setBackground(Color.GRAY);
		radio_btn_deLorean.setForeground(Color.WHITE);
		
		btn_group = new ButtonGroup();
		btn_group.add(radio_btn_ufo);
		btn_group.add(radio_btn_rocket);
		btn_group.add(radio_btn_deLorean);
		
		btn_confirm = new JButton("Confirm selection and start game!");
		btn_confirm.setForeground(Color.GREEN);
		btn_confirm.setBackground(Color.BLACK);
		btn_confirm.setPreferredSize(new Dimension(50,50));
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose_frame.dispose();
				SoundEffects.stop();
				new GUI();
				new SoundEffects().LevelOneMusic();
			}
		});
		
		choose_frame.add(lbl_spaceShip, BorderLayout.PAGE_START);
		choose_frame.add(radio_btn_ufo, BorderLayout.LINE_START);
		choose_frame.add(radio_btn_rocket, BorderLayout.CENTER);
		choose_frame.add(radio_btn_deLorean, BorderLayout.LINE_END);
		choose_frame.add(btn_confirm, BorderLayout.PAGE_END);
		
		choose_frame.pack();
		choose_frame.setVisible(true);
		
		// Code only needed, if working with a second screen; call method and select Screen 1
		SecondScreen ss = new SecondScreen();
		ss.showOnScreen(1, choose_frame);
	}
}
