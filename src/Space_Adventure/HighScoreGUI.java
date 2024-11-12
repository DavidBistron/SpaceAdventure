package Space_Adventure;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class HighScoreGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JFrame highScore_frame;
	private static JButton btn_back;
	private static Image bg;
	
	@SuppressWarnings({ "serial", "static-access" })
	public HighScoreGUI() {
		highScore_frame = new JFrame("High Scores");
		highScore_frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		highScore_frame.setSize(Variables.screenwitdh, Variables.screenheight);
		highScore_frame.setLocationRelativeTo(null);
		highScore_frame.setResizable(false);

		// draw background
		try {
			bg = ImageIO.read(new File("attachments/highScores.png"));
			highScore_frame.setContentPane(new JPanel(new BorderLayout()) {
				public void paintComponent(Graphics g) {
					g.drawImage(bg, 0, 0, null);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// addComponentsToPane(highScore_frame.getContentPane());
		highScore_frame.getContentPane();
		btn_back = new JButton("Back to main menu");
		highScore_frame.setVisible(true);
		highScore_frame.add(btn_back);

		// Code only needed, if working with a second screen; call method and select Screen 1
		SecondScreen ss = new SecondScreen();
		ss.showOnScreen(1, highScore_frame);
	}

}
