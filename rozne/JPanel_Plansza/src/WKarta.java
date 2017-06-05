
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WKarta extends JPanel {


	BufferedImage Image;
	int i;
	public WKarta(int i){
	
		this.i=i;
		setBounds(300, 270, 160, 212);
		setVisible(false);
		try{
			//wczytanie obrazka o nazwie i.ToString() + ".jpg"
			Image = ImageIO.read(new File(i + ".png"));
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(Image, 0, 0, null);
	}
}


