package okienko;

import javax.swing.*;

public class PanelGraczy extends JFrame
{
	public PanelGraczy()
	{
		setSize(1300, 800);
		
		JLabel	AktywnyGracz = new JLabel("Kolejkê wykonuje: Gracz1");
		AktywnyGracz.setBounds(950, 20, 150,50);
		add(AktywnyGracz);
		
		JLabel gracz1 = new JLabel("Gracz1: 1500"); 
		gracz1.setBounds(900, 65, 150, 50);
		add(gracz1);
		JLabel gracz2 = new JLabel("Gracz2: 1500");
		gracz2.setBounds(1100, 65, 150, 50);
		add(gracz2);
		JLabel gracz3 = new JLabel("Gracz3: 1500");
		gracz3.setBounds(900, 185, 150, 50);
		add(gracz3);
		
		Panel panel = new Panel(900, 100, 1100, 100, 900, 220);
		add(panel);
		setVisible(true);
	}
}
