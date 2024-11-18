package Space_Adventure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// Class for adding a player name
public class PlayerGUI extends JFrame {

	// Variables
	private static final long serialVersionUID = 1L;
	private static JFrame player_frame;
    private static JTextField txt_name;
	private static String s;
	private static Image bg;
	
	// Constructor
	public PlayerGUI() {
			
		player_frame = new JFrame("Enter Name");
		player_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		player_frame.setPreferredSize(new Dimension(Variables.screenwitdh, Variables.screenheight));
		player_frame.setResizable(false);
		
		// Draw background
				try {
					bg = ImageIO.read(new File("attachments/space1.png"));
					player_frame.setContentPane(new JPanel(new FlowLayout()) {
						public void paintComponent(Graphics g) {
							g.drawImage(bg, 0, 0, null);
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
		
		FlowLayout flow = new FlowLayout();
		player_frame.getContentPane().setLayout(flow);

        JLabel lbl_name = new JLabel("Enter your name: ");
		lbl_name.setForeground(Color.WHITE);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);

        JButton btn_confirm = new JButton("Confirm!");
		btn_confirm.setBackground(Color.BLACK);
		btn_confirm.setForeground(Color.GREEN);
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = txt_name.getText();
				player_frame.dispose();
				new ChooseSpaceShipGUI();
			}
		});
		
		player_frame.add(lbl_name);
		player_frame.add(txt_name);
		player_frame.add(btn_confirm);
		player_frame.pack();
		player_frame.setVisible(true);
	}
	
	public static String getTxtName() {
		return s;
	}
}