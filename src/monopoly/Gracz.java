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
	 * Pole przechowuje iloœæ pieniêdzy gracza.
	 */
	private int iloscPieniedzy;
	/**
	 * Pole przechowuje informacjê czy gracz jest w Wiêzieniu.
	 */
	private boolean czyWWiezieniu;
	/**
	 * Pole przechowuje listê posiadanych nieruchomoœci
	 */
	private List<Pole> posiadaneNieruchomosci;
	/**
	 * Pole przechowuje listê nazw posiadanych nieruchomoœci
	 */
	private LinkedList<String> posiadaneNieruchomosciNazwa;
	/**
	 * Pole przechowuje aktualn¹ pozycjê gracza na planszy.
	 */
	private int pozycja;
	/**
	 * Pole przechowuje liczbê podjêtych prób wyjœcia z Wiêzienia.
	 */
	private int probyWyjsciaZWiezienia;
	/**
	 * Pole przechowuje sumê oczek wylosowanych przy rzucie koœæmi.
	 */
	private int sumaWyrzuconychOczek;

	/**
	 * Tworzy obiekt klasy z zadan¹ iloœci¹ pieniêdzy na start.
	 *
	 * @param iloscPieniedzy
	 *            startowa kwota pieniêdzy.
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
	 * Dodaje graczowi podan¹ kwotê.
	 * 
	 * @param iloscPieniedzy
	 *            iloœæ pieniêdzy do dodania
	 * @throws IllegalArgumentException
	 *             je¿eli przekazano ujemn¹ kwotê
	 */
	public void dodajPieniadze(int iloscPieniedzy) throws IllegalArgumentException {
		if (iloscPieniedzy < 0)
			throw new IllegalArgumentException("Próba dodania ujemnej iloœci pieniedzy");
		this.iloscPieniedzy += iloscPieniedzy;
	}

	/**
	 * Odejmuje graczowi pieni¹dze.
	 * 
	 * @param iloscPieniedzy
	 *            iloœæ pieniêdzy do odjêcia
	 */
	public void odejmijPieniadze(int iloscPieniedzy) {
		this.iloscPieniedzy -= iloscPieniedzy;
	}

	/**
	 * Zwraca iloœæ pieniêdzy posiadanych przez gracza.
	 * 
	 * @return ile pieniêdzy posiada gracz
	 */
	public int getIloscPieniedzy() {
		return iloscPieniedzy;
	}
	
	/**
	 * Metoda zwraca listê nieruchomoœci posiadanych przez gracza.
	 * @return Lista pól posiadanych przez gracza
	 */
	public List<Pole> getListaNieruchomosci(){
		return posiadaneNieruchomosci;
	}
	/**
	 * Metoda zwraca listê nazw nieruchomoœci posiadanych przez gracza.
	 * @return Lista nazw nieruchomoœci posiadanych przez gracza.
	 */
	public LinkedList<String> getListaNieruchomosciNazwy(){
		return posiadaneNieruchomosciNazwa;
	}

	/**
	 * Sprawdza, czy gracz znajduje siê w wiêzieniu.
	 *
	 * @return true je¿eli gracz jest w wiêzieniu, false w przeciwnym wypadku
	 */
	public boolean czyWWiezieniu() {
		return this.czyWWiezieniu;
	}

	/**
	 * Sprawdza, czy gracz posiada dan¹ kwotê pieniêdzy.
	 * 
	 * @param ilosc
	 *            iloœæ pieniêdzy
	 * @return true je¿eli gracz posiada dan¹ kwotê, false w przeciwnym wypadku
	 */
	public boolean czyMaPieniadze(int ilosc) {
		if (this.iloscPieniedzy < ilosc)
			return false;
		else
			return true;
	}

	/**
	 * Dodaje nieruchomoœæ graczowi
	 *
	 * @param nieruchomosc
	 *            pole, które zostanie dodane graczowi
	 */
	public void dodajNieruchomosc(PoleNieruchomosc nieruchomosc) {
		this.posiadaneNieruchomosci.add(nieruchomosc);
		this.posiadaneNieruchomosciNazwa.add(nieruchomosc.GetNazwa());
	}

	/**
	 * Ustawia pozycjê gracza
	 * 
	 * @param pozycja
	 *            zadana pozycja gracza
	 */
	public void setPozycja(int pozycja) {
		this.pozycja = pozycja;
	}

	/**
	 * Zwraca pozycjê gracza.
	 * 
	 * @return pozycja gracza
	 */
	public int getPozycja() {
		return this.pozycja;
	}

	/**
	 * Wysy³a gracza do wiêzienia.
	 */
	public void idzDoWiezienia() {
		this.czyWWiezieniu = true;
		this.pozycja = 10;
	}

	/**
	 * Metoda wywo³ywana na pocz¹tku tury gracza. Pokazuje graczowi skierowane
	 * do niego oferty handlowe (je¿eli jakieœ by³y), a nastêpnie mo¿liwoœci
	 * wyjœcia z wiêzienia (jezeli gracz jest w wiêzieniu).
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
						Okienka.WyswietlWiadomosc("Uda³o ci siê wyrzuciæ dublet, mo¿esz wyjœæ z wiêzienia.",
								"Wiêzenie");
					} else {
						probyWyjsciaZWiezienia++;
						Okienka.WyswietlWiadomosc("Nie uda³o ci siê wyrzuciæ dubletu.", "Wiêzienie");
					}
				} else {
					this.odejmijPieniadze(50);
					this.czyWWiezieniu = false;
				}
			}
			// gracz musi zap³aciæ 50 z³
			else {
				Okienka.WyswietlWiadomosc(
						"Wykorzysta³eœ próby wyrzucenia dubletu. Zap³aæ" + "50 z³ za wyjœcie z wiêzienia", "Wiêzienie");
				this.odejmijPieniadze(50);
				this.czyWWiezieniu = false;
			}
		}
	}

	/**
	 * Losuje o ile gracz ma siê ruszyæ i wykonuje ruch.
	 */
	public void wykonajRuch() {
		int oczka1 = Kostka.Rzuc();
		int oczka2 = Kostka.Rzuc();
		Okienka.WyswietlKostke(oczka1, oczka2);
		this.sumaWyrzuconychOczek = oczka1 + oczka2;
		this.wykonajRuch(sumaWyrzuconychOczek);
	}

	/**
	 * Wykonuje ruch gracza o zadan¹ liczbê pól.
	 * 
	 * @param oIle
	 *            o ile pól przesun¹æ gracza
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
	 * Zwraca iloœæ dworców posiadanych przez gracz.
	 *
	 * @return liczba dworców posiadanych przez gracza
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
	 * Zwraca iloœæ obiektów u¿ytecznoœci publicznej posiadanych przez gracza.
	 *
	 * @return iloœæ obiektów u¿ytecznoœci publicznej posiadanych przez gracza
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
	 * Zwraca sume oczek, któr¹ gracz wyrzuci³ w danej turze.
	 * 
	 * @return ile oczek gracz wyrzuci³ w tej turze
	 */
	public int getSumaWyrzuconychOczek() {
		return this.sumaWyrzuconychOczek;
	}
}
