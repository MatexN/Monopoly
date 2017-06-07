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
 * G³ówne okno z gr¹.
 */
public class GlowneOkno extends JFrame {
	private static final long serialVersionUID = 1L;
	int[] wspolrzedneX = { 600, 552, 504, 456, 408, 360, 312, 264, 216, 168, 82, 82, 82, 82, 82, 82, 82, 82, 82, 82, 82,
			168, 216, 264, 312, 360, 408, 456, 504, 552, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600 };
	int[] wspolrzedneY = { 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 600, 552, 504, 456, 408, 360, 312, 264,
			216, 168, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 168, 216, 264, 312, 360, 408, 456, 504,
			552 };

	PolePlanszy[] planszaGrafika;
	PanelKarta[] karty;
	JLabel obecnyGraczLabel;
	JButton posiadaneNieruchomosciButton;
	JLabel gotowka;
	int indeksGracza;
	Plansza plansza;
	Gracz obecnyGracz;
	List<Gracz> listaGraczy;
	int iloscGraczy;
	JButton wykonajTureButton;

	/**
	 * Konstruktor tworz¹cy g³ówne okno gry. Tworzê tutaj wszystkie widoczne
	 * podczas gry elementy planszy, elementy interfejsu gracza (przycisk
	 * wykonania tury, wyœwietlenia posiadanych kart, informacje o saldzie
	 * konta, oraz który gracz wykonuje ruch), oraz definiujê obs³ugê zdarzeñ
	 * myszki.
	 * 
	 * @throws BoardCreatingException
	 * 			je¿eli wyst¹pi³ b³¹d przy tworzeniu planszy.
	 */
	public GlowneOkno() throws BoardCreatingException {
		iloscGraczy = Okienka.WyswietlWyborIlosciGraczy();
		indeksGracza = 0;
		plansza = new Plansza();
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
				System.out.println("B³¹d");
			}
		}

		wykonajTureButton = new JButton("Wykonaj turê");
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

		posiadaneNieruchomosciButton = new JButton("Poka¿ posiadane Karty");
		posiadaneNieruchomosciButton.setBounds(750, 150, 250, 50);
		posiadaneNieruchomosciButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PokazKarty();
			}
		});
		this.add(posiadaneNieruchomosciButton);

		planszaGrafika[obecnyGracz.getPozycja()].wyswietlPionek(0);
		this.add(gotowka);

		this.UstawGracza();
		this.UstawPieniadze(obecnyGracz.getIloscPieniedzy());

		for (int i = 0; i < iloscGraczy; i++) {
			planszaGrafika[0].wyswietlPionek(i);
		}
	}

	/**
	 * Metoda ustawiaj¹ca indeks gracza wykonuj¹cego ruch.
	 */
	public void UstawGracza() {
		obecnyGraczLabel.setText("Obecny gracz: " + (indeksGracza + 1));
	}

	/**
	 * Metoda ustawiaj¹ca informacjê o saldzie konta.
	 * 
	 * @param kwota Iloœæ pieniêdzy na koncie gracza.
	 */
	public void UstawPieniadze(int kwota) {
		gotowka.setText("Posiadane pieniadze: " + kwota + " z³");
	}

	/**
	 * Metoda wyswietlaj¹ca okno z list¹ posiadanych nieruchomoœci. Je¿eli gracz
	 * nie posiada ¿adnych nieruchomoœci wypisuje odpowiedni¹ informacjê.
	 */
	public void PokazKarty() {
		LinkedList<String> lista = obecnyGracz.getListaNieruchomosciNazwy();
		if (lista.size() > 0) {
			Okienka.WyswietlListePosiadanychNieruchomosci(obecnyGracz.getListaNieruchomosciNazwy());
		} else {
			Okienka.WyswietlWiadomosc("Gracz nie posiada nieruchomoœci.", "Lista Nieruchomoœci");
		}
	}

	/**
	 * Metoda uruchomiaj¹ca proces wykonywania tury.
	 * 
	 * @throws BoardCreatingException
	 *             je¿eli funkcja PodejmijCzynnoœæ rzuci wyj¹tek.
	 */
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
					"Gracz " + (indeksGracza + 1) + " posiada ujemn¹ iloœæ pieniêdzy" + "i wypada z gry.",
					"Przegra³eœ");
			listaGraczy.remove(obecnyGracz);
			if (this.listaGraczy.size() <= 1) {
				wykonajTureButton.setEnabled(false);
				Okienka.WyswietlWiadomosc("W grze zosta³ tylko jeden gracz, nastêpuje koniec gry", "Koniec gry");
			}
		} else {
			indeksGracza++;
			indeksGracza %= iloscGraczy;
		}
	}
}
