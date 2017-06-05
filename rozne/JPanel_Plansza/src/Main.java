import javax.swing.JFrame;
import java.awt.event.*;

public class Main extends JFrame{
	int[] wspolrzedneX = {600,552,504,456,408,360,312,264,216,168,82,82,82,82,82,82,82,82,82,82,82,
			168,216,264,312,360,408,456,504,552,600,600,600,600,600,600,600,600,600,600}; // KARTA SPEC 86 -- 68 |
	int[] wspolrzedneY = {600,600,600,600,600,600,600,600,600,600,600,552,504,456,408,360,312,264,216,168,100,
			100,100,100,100,100,100,100,100,100,100,168,216,264,312,360,408,456,504,552};
	int[] szerokoscX = {86,48,48,48,48,48,48,48,48,48,86,86,86,86,86,86,86,86,86,86,86,
			48,48,48,48,48,48,48,48,48,86,86,86,86,86,86,86,86,86,86};
	int[] wysokoscY = {68,68,68,68,68,68,68,68,68,68,68,48,48,48,48,48,48,48,48,48,68,
			68,68,68,68,68,68,68,68,68,68,48,48,48,48,48,48,48,48,48};
	WKarta[] Karta = new WKarta[40];
	public Main(){
		setSize(1300,800);
		setTitle("Monopoly");
		setLayout(null);
		for(int i = 0; i<40; i++){
			Pole pole = new Pole(wspolrzedneX[i],wspolrzedneY[i], szerokoscX[i], wysokoscY[i], i);
			WKarta karta = new WKarta(i);
			Karta[i] = karta;
			add(karta);
			final int mysz = i;
			
			pole.addMouseListener(new MouseListener(){
				 public void mousePressed(MouseEvent e) {
				    }

				    public void mouseReleased(MouseEvent e) {
				    }

				    public void mouseEntered(MouseEvent e) {
				    //	System.out.println("Mysz wesz³a na pole " + mysz);
				    	Karta[mysz].setVisible(true);
				    }

				    public void mouseExited(MouseEvent e) {
				    	//System.out.println("Mysz wysz³a z pola " + mysz);
				    	Karta[mysz].setVisible(false);
				    }

				    public void mouseClicked(MouseEvent e) {
				    }
			});
			add(pole);
		}
		Pionek pionek = new Pionek(620,655,630,655,640,655);
		add(pionek);
		KasaGraczyLabel piniundz = new KasaGraczyLabel();
		add(piniundz);
	}
	  public static void main(String[] args) {
		  	Main okno = new Main();
		  	okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			okno.setVisible(true);
		  }
}
