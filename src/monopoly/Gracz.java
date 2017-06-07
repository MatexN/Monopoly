package monopoly;

import java.util.LinkedList;
import java.util.List;

import pola.Pole;
import pola.PoleNieruchomosc;
import util.Kostka;
import util.Okienka;
import util.Ustawienia;

/**
 * Klasa reprezentujaca gracza.
 */
public class Gracz {
	/**
	 * Pole przechowuje ilo�� pieni�dzy gracza.
	 */
	private int iloscPieniedzy;
	/**
	 * Pole przechowuje informacj� czy gracz jest w Wi�zieniu.
	 */
	private boolean czyWWiezieniu;
	/**
	 * Pole przechowuje list� posiadanych nieruchomo�ci
	 */
	private List<Pole> posiadaneNieruchomosci;
	/**
	 * Pole przechowuje list� nazw posiadanych nieruchomo�ci
	 */
	private LinkedList<String> posiadaneNieruchomosciNazwa;
	/**
	 * Pole przechowuje aktualn� pozycj� gracza na planszy.
	 */
	private int pozycja;
	/**
	 * Pole przechowuje liczb� podj�tych pr�b wyj�cia z Wi�zienia.
	 */
	private int probyWyjsciaZWiezienia;
	/**
	 * Pole przechowuje sum� oczek wylosowanych przy rzucie ko��mi.
	 */
	private int sumaWyrzuconychOczek;

	/**
	 * Tworzy obiekt klasy z zadan� ilo�ci� pieni�dzy na start.
	 *
	 * @param iloscPieniedzy
	 *            startowa kwota pieni�dzy.
	 */
	public Gracz(int iloscPieniedzy) {
		this.iloscPieniedzy = iloscPieniedzy;
		czyWWiezieniu = false;
		posiadaneNieruchomosci = new LinkedList<>();
		posiadaneNieruchomosciNazwa = new LinkedList<>();
		pozycja = 0;
		probyWyjsciaZWiezienia = 0;
	}

	/**
	 * Dodaje graczowi podan� kwot�.
	 * 
	 * @param iloscPieniedzy
	 *            ilo�� pieni�dzy do dodania
	 * @throws IllegalArgumentException
	 *             je�eli przekazano ujemn� kwot�
	 */
	public void dodajPieniadze(int iloscPieniedzy) throws IllegalArgumentException {
		if (iloscPieniedzy < 0)
			throw new IllegalArgumentException("Pr�ba dodania ujemnej ilo�ci pieniedzy");
		this.iloscPieniedzy += iloscPieniedzy;
	}

	/**
	 * Odejmuje graczowi pieni�dze.
	 * 
	 * @param iloscPieniedzy
	 *            ilo�� pieni�dzy do odj�cia
	 */
	public void odejmijPieniadze(int iloscPieniedzy) {
		this.iloscPieniedzy -= iloscPieniedzy;
	}

	/**
	 * Zwraca ilo�� pieni�dzy posiadanych przez gracza.
	 * 
	 * @return ile pieni�dzy posiada gracz
	 */
	public int getIloscPieniedzy() {
		return iloscPieniedzy;
	}
	
	/**
	 * Metoda zwraca list� nieruchomo�ci posiadanych przez gracza.
	 * @return Lista p�l posiadanych przez gracza
	 */
	public List<Pole> getListaNieruchomosci(){
		return posiadaneNieruchomosci;
	}
	/**
	 * Metoda zwraca list� nazw nieruchomo�ci posiadanych przez gracza.
	 * @return Lista nazw nieruchomo�ci posiadanych przez gracza.
	 */
	public LinkedList<String> getListaNieruchomosciNazwy(){
		return posiadaneNieruchomosciNazwa;
	}

	/**
	 * Sprawdza, czy gracz znajduje si� w wi�zieniu.
	 *
	 * @return true je�eli gracz jest w wi�zieniu, false w przeciwnym wypadku
	 */
	public boolean czyWWiezieniu() {
		return this.czyWWiezieniu;
	}

	/**
	 * Sprawdza, czy gracz posiada dan� kwot� pieni�dzy.
	 * 
	 * @param ilosc
	 *            ilo�� pieni�dzy
	 * @return true je�eli gracz posiada dan� kwot�, false w przeciwnym wypadku
	 */
	public boolean czyMaPieniadze(int ilosc) {
		if (this.iloscPieniedzy < ilosc)
			return false;
		else
			return true;
	}

	/**
	 * Dodaje nieruchomo�� graczowi
	 *
	 * @param nieruchomosc
	 *            pole, kt�re zostanie dodane graczowi
	 */
	public void dodajNieruchomosc(PoleNieruchomosc nieruchomosc) {
		this.posiadaneNieruchomosci.add(nieruchomosc);
		this.posiadaneNieruchomosciNazwa.add(nieruchomosc.GetNazwa());
	}

	/**
	 * Ustawia pozycj� gracza
	 * 
	 * @param pozycja
	 *            zadana pozycja gracza
	 */
	public void setPozycja(int pozycja) {
		this.pozycja = pozycja;
	}

	/**
	 * Zwraca pozycj� gracza.
	 * 
	 * @return pozycja gracza
	 */
	public int getPozycja() {
		return this.pozycja;
	}

	/**
	 * Wysy�a gracza do wi�zienia.
	 */
	public void idzDoWiezienia() {
		this.czyWWiezieniu = true;
		this.pozycja = 10;
	}

	/**
	 * Metoda wywo�ywana na pocz�tku tury gracza. Pokazuje graczowi skierowane
	 * do niego oferty handlowe (je�eli jakie� by�y), a nast�pnie mo�liwo�ci
	 * wyj�cia z wi�zienia (jezeli gracz jest w wi�zieniu).
	 */
	public void startTury() {
		this.sumaWyrzuconychOczek = 0;

		if (this.czyWWiezieniu) {
			// sprawdzenie czy gracz nie przekroczyl maksymalnej liczby prob
			// wyjscia z wiezienia
			if (this.probyWyjsciaZWiezienia < 3) {
				int decyzja = Okienka.WyswietlWyjscieZWiezienia();
				// gracz probuje wyrzucic dublet
				if (decyzja == 0) {
					int kostka1 = Kostka.Rzuc();
					int kostka2 = Kostka.Rzuc();
					Okienka.WyswietlKostke(kostka1, kostka2);
					if (kostka1 == kostka2) {
						this.sumaWyrzuconychOczek = kostka1 + kostka2;
						this.czyWWiezieniu = false;
						Okienka.WyswietlWiadomosc("Uda�o ci si� wyrzuci� dublet, mo�esz wyj�� z wi�zienia.",
								"Wi�zenie");
					} else {
						probyWyjsciaZWiezienia++;
						Okienka.WyswietlWiadomosc("Nie uda�o ci si� wyrzuci� dubletu.", "Wi�zienie");
					}
				} else {
					this.odejmijPieniadze(50);
					this.czyWWiezieniu = false;
				}
			}
			// gracz musi zap�aci� 50 z�
			else {
				Okienka.WyswietlWiadomosc(
						"Wykorzysta�e� pr�by wyrzucenia dubletu. Zap�a�" + "50 z� za wyj�cie z wi�zienia", "Wi�zienie");
				this.odejmijPieniadze(50);
				this.czyWWiezieniu = false;
			}
		}
	}

	/**
	 * Losuje o ile gracz ma si� ruszy� i wykonuje ruch.
	 */
	public void wykonajRuch() {
		int oczka1 = Kostka.Rzuc();
		int oczka2 = Kostka.Rzuc();
		Okienka.WyswietlKostke(oczka1, oczka2);
		this.sumaWyrzuconychOczek = oczka1 + oczka2;
		this.wykonajRuch(sumaWyrzuconychOczek);
	}

	/**
	 * Wykonuje ruch gracza o zadan� liczb� p�l.
	 * 
	 * @param oIle
	 *            o ile p�l przesun�� gracza
	 */
	public void wykonajRuch(int oIle) {
		this.sumaWyrzuconychOczek = oIle;
		int dokad = this.pozycja + this.sumaWyrzuconychOczek;
		if (dokad > 39)
			this.dodajPieniadze(Ustawienia.kwotaStart);
		dokad %= 40;

		this.pozycja = dokad;
	}

	/**
	 * Zwraca ilo�� dworc�w posiadanych przez gracz.
	 *
	 * @return liczba dworc�w posiadanych przez gracza
	 */
	public int liczbaDworcow() {
		int liczbaDworcow = 0;
		for (Pole pole : posiadaneNieruchomosci) {
			if (pole.getClass() == pola.PoleDworzec.class) {
				liczbaDworcow++;
			}
		}
		return liczbaDworcow;
	}

	/**
	 * Zwraca ilo�� obiekt�w u�yteczno�ci publicznej posiadanych przez gracza.
	 *
	 * @return ilo�� obiekt�w u�yteczno�ci publicznej posiadanych przez gracza
	 */
	public int liczbaObiektowUzytecznosciPublicznej() {
		int liczbaObiektow = 0;

		for (Pole pole : posiadaneNieruchomosci) {
			if (pole.getClass() == pola.PoleUzytecznosciPublicznej.class)
				liczbaObiektow++;
		}

		return liczbaObiektow;
	}

	/**
	 * Zwraca sume oczek, kt�r� gracz wyrzuci� w danej turze.
	 * 
	 * @return ile oczek gracz wyrzuci� w tej turze
	 */
	public int getSumaWyrzuconychOczek() {
		return this.sumaWyrzuconychOczek;
	}
}
