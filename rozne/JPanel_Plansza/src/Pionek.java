import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Pionek extends JPanel{

//	int x, y; 
	int x1,x2,x3;
	int y1,y2,y3;
//	public void ustawXY(int x, int y){
	//	this.x=x;
	//	this.y=y;
//	}
	public void paintBorder(Graphics g)
    {
		g.setColor(Color.red);
		g.fillRect(900, 100, 50, 50);

		g.setColor(Color.blue);
		g.fillRect(1100, 100, 50, 50);

		g.setColor(Color.green);
		g.fillRect(900, 220, 50, 50);
}
	public Pionek(int x1,int y1, int x2,int y2, int x3, int y3){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.x3=x3;
		this.y3=y3;
		setBounds(0,0,1300,900);
	}
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.RED);
		//pionek czerwony 
		g.fillOval(x1, y1, 25, 25);
		g.setColor(Color.white);
		g.drawOval(x1+5, y1+5, 15, 15);
	
		g.setColor(Color.BLUE);
		//pionek czerwony 
		g.fillOval(x2, y2, 25, 25);
		g.setColor(Color.white);
		g.drawOval(x2+5, y2+5, 15, 15);
	
		g.setColor(Color.GREEN);
		//pionek czerwony 
		g.fillOval(x3, y3, 25, 25);
		g.setColor(Color.white);
		g.drawOval(x3+5, y3+5, 15, 15);
	

	}
}
