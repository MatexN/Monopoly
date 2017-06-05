package okienko;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ButtonTest extends JFrame {
	//JButton mb;
	//JButton CustButton;
	public ButtonTest() {

	    JFrame frame = new JFrame();
	    frame.getContentPane().setBackground(Color.black);
	    frame.setSize(1300,800);
	    frame.setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	//	JButton CustButton  = new CustButton("ryryyryr");
	    JButton mb = new CustButton("ChujCIWDupeikamienijkuperytychycypycycycyc");
		 setBounds(100,100,100,550);
	     frame.add(mb);

	//  pack();
	  setLocationRelativeTo(null);
	  setVisible(true);
	  
	 // Pionek pionek = new Pionek(620,665, Color.RED);
	//	add(pionek);
	}

	public static void main(String args[]) {
	  new ButtonTest();	
	}
}