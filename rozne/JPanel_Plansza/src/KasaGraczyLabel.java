import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class KasaGraczyLabel extends JPanel{
	
	
	public KasaGraczyLabel(){
		
	//	JPanel p = new JPanel();

    //    JLabel lab1 = new JLabel("User Name", JLabel.LEFT);
   //     p.setLayout(new FlowLayout());
     //   p.add(lab1 = new JLabel("add JLabel"));
        setBounds(0,0,1300,900);
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
	
}
	
}
