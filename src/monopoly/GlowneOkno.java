package monopoly;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pola.Pole;
import pola.PolePlanszy;
import util.Okienka;
import wyjatki.BoardCreatingException;

/**
 * Główne okno z grą.
 */
public class GlowneOkno extends JFrame {
	int[] wspolrzedneX = { 600, 552, 504, 456, 408, 360, 312, 264, 216, 168, 82, 82, 82, 82, 82, 82, 82, 82, 82, 82, 82,
			168, 216, 264, 312, 360, 408, 456, 504, 552, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600 };
	int[] wspolrzedneY = { 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 552, 504, 456, 408, 360, 312, 264,
			216, 168, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 168, 216, 264, 312, 360, 408, 456, 504,
			552 };

	PolePlanszy[] planszaGrafika;
	PanelKarta[] karty;
	JLabel obecnyGraczLabel;
	JLabel gotowka;
	int indeksGracza;
	Plansza plansza;
	Gracz obecnyGracz;
	List<Gracz> listaGraczy;
	int iloscGraczy;
	JButton wykonajTureButton;

	public GlowneOkno() throws BoardCreatingException {
		indeksGracza = 0;
		plansza = new Plansza();
		iloscGraczy = 2;
		listaGraczy = new LinkedList<>();
		for (int i = 0; i < iloscGraczy; i++)
			listaGraczy.add(new Gracz(2000));
		obecnyGracz = listaGraczy.get(indeksGracza);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 800);
		this.setLayout(null);
		this.setMinimumSize(new Dimension(1100, 800));
		planszaGrafika = new PolePlanszy[40];
		karty = new PanelKarta[40];

		for (int i = 0; i < 40; i++) {
			final int indeks = i;
			try {
				BufferedImage img = ImageIO.read(new File("img/" + indeks + ".jpg"));
				int height = img.getHeight();
				int width = img.getWidth();

				PolePlanszy pole = new PolePlanszy(wspolrzedneX[indeks], wspolrzedneY[indeks], width, height, img);
				planszaGrafika[indeks] = pole;

				PanelKarta karta = new PanelKarta(indeks);
				karty[indeks] = karta;
				this.add(karta);

				pole.addMouseListener(new MouseListener() {
					public void mousePressed(MouseEvent e) {
					}

					public void mouseReleased(MouseEvent e) {
					}

					public void mouseEntered(MouseEvent e) {
						karty[indeks].setVisible(true);
					}

					public void mouseExited(MouseEvent e) {
						karty[indeks].setVisible(false);
					}

					public void mouseClicked(MouseEvent e) {
					}
				});

				this.add(pole);

			} catch (Exception e) {
				System.out.println("Błąd");
			}
		}

		wykonajTureButton = new JButton("Wykonaj turę");
		wykonajTureButton.setBounds(800, 552, 150, 40);
		wykonajTureButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					WykonajTure();
				} catch (BoardCreatingException e1) {
					e1.printStackTrace();
				}
			}
		});
		this.add(wykonajTureButton);

		obecnyGraczLabel = new JLabel();
		obecnyGraczLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		obecnyGraczLabel.setBounds(300, 30, 250, 50);
		this.add(obecnyGraczLabel);

		gotowka = new JLabel();
		gotowka.setFont(new Font("Arial", Font.PLAIN, 18));
		gotowka.setBounds(750, 100, 250, 50);

		planszaGrafika[obecnyGracz.getPozycja()].wyswietlPionek(0);
		this.add(gotowka);

		this.UstawGracza();
		this.UstawPieniadze(obecnyGracz.getIloscPieniedzy());

		for (int i = 0; i < iloscGraczy; i++) {
			planszaGrafika[0].wyswietlPionek(i);
		}
	}

	public void UstawGracza() {
		obecnyGraczLabel.setText("Obecny gracz: " + (indeksGracza + 1));
	}

	public void UstawPieniadze(int kwota) {
		gotowka.setText("Posiadane pieniadze: " + kwota + " zł");
	}

	public void WykonajTure() throws BoardCreatingException {
		obecnyGracz = listaGraczy.get(indeksGracza);
		UstawGracza();

		obecnyGracz.startTury();
		this.UstawPieniadze(obecnyGracz.getIloscPieniedzy());

		if (!obecnyGracz.czyWWiezieniu()) {
			planszaGrafika[obecnyGracz.getPozycja()].skasujPionek(indeksGracza);
			obecnyGracz.wykonajRuch();
			int indeks = obecnyGracz.getPozycja();
			planszaGrafika[indeks].wyswietlPionek(indeksGracza);
			this.UstawPieniadze(obecnyGracz.getIloscPieniedzy());

			Pole pole = plansza.getPole(indeks);
			pole.PodejmijCzynnosc(obecnyGracz);
			this.UstawPieniadze(obecnyGracz.getIloscPieniedzy());

			if (indeks != obecnyGracz.getPozycja()) {
				planszaGrafika[indeks].skasujPionek(indeksGracza);
				planszaGrafika[obecnyGracz.getPozycja()].wyswietlPionek(indeksGracza);
				plansza.getPole(obecnyGracz.getPozycja()).PodejmijCzynnosc(obecnyGracz);
				this.UstawPieniadze(obecnyGracz.getIloscPieniedzy());
			}
		}

		if (obecnyGracz.getIloscPieniedzy() < 0) {
			Okienka.WyswietlWiadomosc(
					"Gracz " + (indeksGracza + 1) + " posiada ujemną ilość pieniędzy" + "i wypada z gry.",
					"Przegrałeś");
			listaGraczy.remove(obecnyGracz);
			if (this.listaGraczy.size() <= 1) {
				wykonajTureButton.setEnabled(false);
				Okienka.WyswietlWiadomosc("W grze został tylko jeden gracz, następuje koniec gry", "Koniec gry");
			}
		} else {
			indeksGracza++;
			indeksGracza %= iloscGraczy;
		}
	}
}
