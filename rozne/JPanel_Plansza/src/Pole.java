
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Pole extends JPanel{
	BufferedImage[] ImagesTab = new BufferedImage[40];
	int x,y,s,w,i;
	public Pole(int x, int y, int s, int w, int i){
		this.x=x;
		this.y=y;
		this.s=s;
		this.w=w;
		this.i=i;
		setBounds(x, y, s, w);
		
		try{
			//wczytanie obrazka o nazwie i.ToString() + ".jpg"
			ImagesTab[i] = ImageIO.read(new File(i + ".jpg"));
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawImage(ImagesTab[i], 0, 0, null);
	}
}
