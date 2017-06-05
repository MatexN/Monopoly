import java.awt.Color;
import java.awt.FlowLayout;  
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

//import default package.Gracze;

public class Okno extends JFrame implements  MouseListener{
	private static final long serialVersionUID = 1L;
	JButton[] buttonsTab = new JButton[40];
	BufferedImage[] ImagesTab = new BufferedImage[40];
	JButton button1;
	JButton button;
	JButton[] buttonPola = new JButton[28];
	BufferedImage[] PolaTab = new BufferedImage[28];
int z = 0;
//////////////////////////////////////////////////////////////////////////////////////
	public Okno(){
		//setLayout(new FlowLayout());
		setSize(1300,800);
		setTitle("Monopoly");
	//	setLayout(null);
		int[] wspolrzedneX = {600,552,504,456,408,360,312,264,216,168,82,82,82,82,82,82,82,82,82,82,82,
				168,216,264,312,360,408,456,504,552,600,600,600,600,600,600,600,600,600,600}; // KARTA SPEC 86 -- 68 |
		int[] wspolrzedneY = {600,600,600,600,600,600,600,600,600,600,600,552,504,456,408,360,312,264,216,168,100,
				100,100,100,100,100,100,100,100,100,100,168,216,264,312,360,408,456,504,552};
		int[] szerokoscX = {86,48,48,48,48,48,48,48,48,48,86,86,86,86,86,86,86,86,86,86,86,
				48,48,48,48,48,48,48,48,48,86,86,86,86,86,86,86,86,86,86};
		int[] wysokoscY = {68,68,68,68,68,68,68,68,68,68,68,48,48,48,48,48,48,48,48,48,68,
				68,68,68,68,68,68,68,68,68,68,48,48,48,48,48,48,48,48,48};
		//wspolrzedneX = {1,2,3,4,5,6,7,8,9,10};
		
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
		
		//stworzenie guzikow planszy
		for (int i = 0; i < 40; i++)
			buttonsTab[i] = new JButton();
		//tworzenie dok³adnych informacji kart planszy
		for(int i = 0; i<28; i++)
			buttonPola[i] = new JButton();
		
		try {
		//wczytanie obrazkow, obrazki powinny nazywac sie "1.jpg", "2.jpg"
			for (int i = 0; i < 40; i++){
			//wczytanie obrazka o nazwie i.ToString() + ".jpg"
				ImagesTab[i] = ImageIO.read(new File(i + ".jpg"));
			}
			for(int i = 0; i <28; i++){
				// pola do wyswietlania zaindeksowane od 0 do 27 
				PolaTab[i] = ImageIO.read(new File(i + ".png"));
			}
		}
		catch (IOException e) {
			System.out.println("Blad wczytywania planszy");
		}
		// ustalanie obrazków guzików na planszy
		for (int i = 0; i < 40; i++){
			buttonsTab[i].setIcon(new ImageIcon(ImagesTab[i]));
			buttonsTab[i].setVisible(true);
		}
		// ustalanie ikonek do wyswietlania specyfikacji pola 
		for (int i = 0; i < 28; i++){
			buttonPola[i].setIcon(new ImageIcon(PolaTab[i]));
			buttonPola[i].setVisible(false);
		}
		// lokowanie calej planszy wszystkich pól 
		for(int i = 0; i < 40; i++){
			buttonsTab[i].setBounds(wspolrzedneX[i], wspolrzedneY[i], szerokoscX[i], wysokoscY[i]);
			add(buttonsTab[i]);
		
			buttonsTab[i].addMouseListener(this);
		}
		
		//podlaczanie guzikow wyswietlanych jako wartosci szczegolowe pola pod obrazki
		for(int i = 0; i<28; i++){
		buttonPola[i].setVisible(false);
		buttonPola[i].setBounds(300, 270, 160, 212);
		  add(buttonPola[i]);
		}
								 // x1  y1  x2  y2  x3  y3
		Pionek pionek = new Pionek(620-z,665,630-z,665,640-z,665);
		add(pionek);
		
	}
		
	public static void main(String[] args)
	{
		Okno okno = new Okno();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setVisible(true);
		
	        
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object zrodlo = e.getSource();
		if(zrodlo == buttonsTab[0]){
			//z +=86;
		//	repaint();
			//System.out.print(" is ");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Object zrodlo = e.getSource();
		if(zrodlo==buttonsTab[1])
		{//#1
			  buttonPola[0].setVisible(true);  
			//  z+=86;
			//  System.out.print(" is "+z);
			//  repaint();
		}
		if(zrodlo==buttonsTab[3])
		{//#3
			  buttonPola[1].setVisible(true);   
		}
		if(zrodlo==buttonsTab[5])
		{//#5
			  buttonPola[2].setVisible(true);   
		}
		if(zrodlo==buttonsTab[6])
		{//#6
			  buttonPola[3].setVisible(true);   
		}
		if(zrodlo==buttonsTab[8])
		{//#8////
			  buttonPola[4].setVisible(true);   
		}
		if(zrodlo==buttonsTab[9])
		{//#9
			  buttonPola[5].setVisible(true);   
		}
		if(zrodlo==buttonsTab[11])
		{//#11
			  buttonPola[6].setVisible(true);
		}
		if(zrodlo==buttonsTab[12])
		{//#12
			  buttonPola[7].setVisible(true);   
		}
		if(zrodlo==buttonsTab[13])
		{//#13
			  buttonPola[8].setVisible(true);   
		}
		if(zrodlo==buttonsTab[14])
		{//#14
			  buttonPola[9].setVisible(true);   
		}
		if(zrodlo==buttonsTab[15])
		{//#15
			  buttonPola[10].setVisible(true);   
		}
		if(zrodlo==buttonsTab[16])
		{//#16
			  buttonPola[11].setVisible(true);   
		}
		if(zrodlo==buttonsTab[18])
		{//#18////
			  buttonPola[12].setVisible(true);   
		}
		if(zrodlo==buttonsTab[19])
		{//#19
			  buttonPola[13].setVisible(true);   
		}
		if(zrodlo==buttonsTab[21])
		{//#21
			  buttonPola[14].setVisible(true);
		}
		if(zrodlo==buttonsTab[23])
		{//#23
			  buttonPola[15].setVisible(true);   
		}
		if(zrodlo==buttonsTab[24])
		{//#24
			  buttonPola[16].setVisible(true);   
		}
		if(zrodlo==buttonsTab[25])
		{//#25
			  buttonPola[17].setVisible(true);   
		}
		if(zrodlo==buttonsTab[26])
		{//#26
			  buttonPola[18].setVisible(true);   
		}
		if(zrodlo==buttonsTab[27])
		{//#27
			  buttonPola[19].setVisible(true);   
		}
		if(zrodlo==buttonsTab[28])
		{//#28////
			  buttonPola[20].setVisible(true);   
		}
		if(zrodlo==buttonsTab[29])
		{//#29
			  buttonPola[21].setVisible(true);   
		}
		if(zrodlo==buttonsTab[31])
		{//#31
			  buttonPola[22].setVisible(true);
		}
		if(zrodlo==buttonsTab[32])
		{//#32
			  buttonPola[23].setVisible(true);   
		}
		if(zrodlo==buttonsTab[34])
		{//#34
			  buttonPola[24].setVisible(true);   
		}
		if(zrodlo==buttonsTab[35])
		{//#35
			  buttonPola[25].setVisible(true);   
		}
		if(zrodlo==buttonsTab[37])
		{//#37
			  buttonPola[26].setVisible(true);   
		}
		if(zrodlo==buttonsTab[39])
		{//#39
			  buttonPola[27].setVisible(true);   
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Object zrodlo = e.getSource();
		if(zrodlo==buttonsTab[1])
		{//#1
			  buttonPola[0].setVisible(false);   
		}
		if(zrodlo==buttonsTab[3])
		{//#3
			  buttonPola[1].setVisible(false);   
		}
		if(zrodlo==buttonsTab[5])
		{//#5
			  buttonPola[2].setVisible(false);   
		}
		if(zrodlo==buttonsTab[6])
		{//#6
			  buttonPola[3].setVisible(false);   
		}
		if(zrodlo==buttonsTab[8])
		{//#8////
			  buttonPola[4].setVisible(false);   
		}
		if(zrodlo==buttonsTab[9])
		{//#9
			  buttonPola[5].setVisible(false);   
		}
		if(zrodlo==buttonsTab[11])
		{//#11
			  buttonPola[6].setVisible(false);   
		}
		if(zrodlo==buttonsTab[12])
		{//#12
			  buttonPola[7].setVisible(false);   
		}
		if(zrodlo==buttonsTab[13])
		{//#13
			  buttonPola[8].setVisible(false);   
		}
		if(zrodlo==buttonsTab[14])
		{//#14
			  buttonPola[9].setVisible(false);   
		}
		if(zrodlo==buttonsTab[15])
		{//#15
			  buttonPola[10].setVisible(false);   
		}
		if(zrodlo==buttonsTab[16])
		{//#16
			  buttonPola[11].setVisible(false);   
		}
		if(zrodlo==buttonsTab[18])
		{//#18////
			  buttonPola[12].setVisible(false);   
		}
		if(zrodlo==buttonsTab[19])
		{//#19
			  buttonPola[13].setVisible(false);   
		}
		if(zrodlo==buttonsTab[21])
		{//#21
			  buttonPola[14].setVisible(false);
		}
		if(zrodlo==buttonsTab[23])
		{//#23
			  buttonPola[15].setVisible(false);   
		}
		if(zrodlo==buttonsTab[24])
		{//#24
			  buttonPola[16].setVisible(false);   
		}
		if(zrodlo==buttonsTab[25])
		{//#25
			  buttonPola[17].setVisible(false);   
		}
		if(zrodlo==buttonsTab[26])
		{//#26
			  buttonPola[18].setVisible(false);   
		}
		if(zrodlo==buttonsTab[27])
		{//#27
			  buttonPola[19].setVisible(false);   
		}
		if(zrodlo==buttonsTab[28])
		{//#28////
			  buttonPola[20].setVisible(false);   
		}
		if(zrodlo==buttonsTab[29])
		{//#29
			  buttonPola[21].setVisible(false);   
		}
		if(zrodlo==buttonsTab[31])
		{//#31
			  buttonPola[22].setVisible(false);
		}
		if(zrodlo==buttonsTab[32])
		{//#32
			  buttonPola[23].setVisible(false);   
		}
		if(zrodlo==buttonsTab[34])
		{//#34
			  buttonPola[24].setVisible(false);   
		}
		if(zrodlo==buttonsTab[35])
		{//#35
			  buttonPola[25].setVisible(false);   
		}
		if(zrodlo==buttonsTab[37])
		{//#37
			  buttonPola[26].setVisible(false);   
		}
		if(zrodlo==buttonsTab[39])
		{//#39
			  buttonPola[27].setVisible(false);   
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	
}
