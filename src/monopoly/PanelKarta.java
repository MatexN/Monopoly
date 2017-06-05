package monopoly;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Panel do obsługi kart
 */
public class PanelKarta extends JPanel {
	BufferedImage Image;

	public PanelKarta(int i) {
		setBounds(300, 270, 160, 212);
		setVisible(false);
		try {
			Image = ImageIO.read(new File("img/" + i + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(Image, 0, 0, null);
	}
}
