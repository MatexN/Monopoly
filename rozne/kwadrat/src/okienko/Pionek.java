package okienko;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Pionek extends JPanel{
	Color kolor;
	int x, y; 
	public void ustawXY(int x, int y){
		this.x=x;
		this.y=y;
	}
	public Pionek(int x,int y, Color kolor){
		this.x=x;
		this.y=y;
		this.kolor = kolor;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(kolor);
		//pionek czerwony 
		g.fillOval(x, y, 25, 25);
		g.setColor(Color.white);
		g.drawOval(x+5, y+5, 15, 15);
	}
}