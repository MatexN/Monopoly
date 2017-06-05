package monopol;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//import java.awt.event.ActionListener;

public class Okienko extends JFrame implements ActionListener 
{
	JButton kosci, bWyjscie;
	JLabel lWyswietlRzut1;
	JLabel lWyswietlRzut2;
	JLabel lWyswietlDublet;
	
	public Okienko()
	{
		setSize(600,700);
		setTitle("Monopoly");
		setLayout(null);
		kosci = new JButton("Rzuc Koœæmi");
		add(kosci);
		kosci.setBounds(150, 400, 120, 30);
		kosci.addActionListener(this);
		
		bWyjscie = new JButton("Wyjœcie");
		bWyjscie.setBounds(270,400,120,30);
		add(bWyjscie);
		bWyjscie.addActionListener(this);
		
		lWyswietlRzut1 = new JLabel("Kosc 1:");
		lWyswietlRzut1.setBounds(140, 200, 100, 120);
		add(lWyswietlRzut1);
		lWyswietlRzut2 = new JLabel("Kosc 2:");
		lWyswietlRzut2.setBounds(185, 200, 100, 120);
		add(lWyswietlRzut2);
		
		lWyswietlDublet = new JLabel();
		lWyswietlDublet.setBounds(148, 210, 200, 120);
		add(lWyswietlDublet);
		
		}
	
	public static void main(String[] args)
	{
		Okienko okno = new Okienko();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();
	    if(zrodlo == kosci){
	    	Random r = new Random();
	    	int a = r.nextInt(6)+1;
	    	int b = r.nextInt(6)+1;
	    	lWyswietlRzut1.setText(new Integer(a).toString());
	    	lWyswietlRzut2.setText(new Integer(b).toString());
	    	if(a == b){
	    		lWyswietlDublet.setText("Dublet");
	    	}
	    	else{ 
	    		lWyswietlDublet.setText("");
	    	}
	  }
	  else if(zrodlo == bWyjscie){
		dispose();
	  }
	}
	
}
