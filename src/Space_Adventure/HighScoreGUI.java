package Space_Adventure;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// Class for displaying HighScores
public class HighScoreGUI extends JFrame {

	private static final long serialVersionUID = 1L;
    private static Image bg;

	// Constructor
	public HighScoreGUI() {
        JFrame highScore_frame = new JFrame("High Scores");
		highScore_frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		highScore_frame.setSize(Variables.screenwitdh, Variables.screenheight);
		highScore_frame.setLocationRelativeTo(null);
		highScore_frame.setResizable(false);

		// Draw background
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

		highScore_frame.getContentPane();
        JButton btn_back = new JButton("Back to main menu");
		highScore_frame.setVisible(true);
		highScore_frame.add(btn_back);

		// Action for back-button
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				highScore_frame.dispose();
			}
		});
	}
}