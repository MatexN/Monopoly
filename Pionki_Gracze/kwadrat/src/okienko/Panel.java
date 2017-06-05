package okienko;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel
{
	int x1,x2,x3;
	int y1,y2,y3;
	int kx1 = 200;
	int kx2 = 200;
	int kx3 = 200;
	int ky1 = 200;
	int ky2 =300;
	int ky3 = 400;
	public Panel(int x1, int y1, int x2, int y2, int x3, int y3)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		System.out.print("rytychycypycy");
		super.paintComponent(g);
		g.setColor(Color.red);
		g.fillRect(x1, y1, 50, 50);
		//pionek czerwony 
		g.fillOval(kx1, ky1, 35, 35);
		g.setColor(Color.white);
		g.drawOval(kx1+10, ky1+10, 15, 15);
		
		g.setColor(Color.blue);
		g.fillRect(x2, y2, 50, 50);
		//pionek niebieski
		g.fillOval(kx2, ky2, 35, 35);
		g.setColor(Color.white);
		g.drawOval(kx2+10, ky2+10, 15, 15);
		
		g.setColor(Color.green);
		g.fillRect(x3, y3, 50, 50);
		//pionek niebieski
		g.fillOval(kx3, ky3, 35, 35);
		g.setColor(Color.white);
		g.drawOval(kx3+10, ky3+10, 15, 15);
		
	}
}
