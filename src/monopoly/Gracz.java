package monopoly;

import java.util.LinkedList;
import java.util.List;

import pola.Pole;
import util.Kostka;
import util.Okienka;
import util.Ustawienia;

/**
 * Klasa reprezentujaca gracza.
 */
public class Gracz {
	private int iloscPieniedzy;
	private boolean czyWWiezieniu;
	private List<Pole> posiadaneNieruchomosci;
	private int pozycja;
	private int probyWyjsciaZWiezienia;
	private int ofertyHandlu;
	private Pole obecnePole;
	private int sumaWyrzuconychOczek;

	/**
	 * Tworzy obiekt klasy z zadaną ilością pieniędzy na start.
	 *
	 * @param iloscPieniedzy
	 *            startowa kwota pieniędzy.
	 */
	public Gracz(int iloscPieniedzy) {
		this.iloscPieniedzy = iloscPieniedzy;
		czyWWiezieniu = false;
		posiadaneNieruchomosci = new LinkedList<>();
		pozycja = 0;
		probyWyjsciaZWiezienia = 0;
		ofertyHandlu = 0;
	}

	/**
	 * Dodaje graczowi podaną kwotę.
	 * 
	 * @param iloscPieniedzy
	 *            ilość pieniędzy do dodania
	 * @throws IllegalArgumentException
	 *             jeżeli przekazano ujemną kwotę
	 */
	public void dodajPieniadze(int iloscPieniedzy) throws IllegalArgumentException {
		if (iloscPieniedzy < 0)
			throw new IllegalArgumentException("Próba dodania ujemnej ilości pieniedzy");
		this.iloscPieniedzy += iloscPieniedzy;
	}

	/**
	 * Odejmuje graczowi pieniądze.
	 * 
	 * @param iloscPieniedzy
	 *            ilość pieniędzy do odjęcia
	 */
	public void odejmijPieniadze(int iloscPieniedzy) {
		this.iloscPieniedzy -= iloscPieniedzy;
	}

	/**
	 * Zwraca ilość pieniędzy posiadanych przez gracza.
	 * 
	 * @return ile pieniędzy posiada gracz
	 */
	public int getIloscPieniedzy() {
		return iloscPieniedzy;
	}

	/**
	 * Sprawdza, czy gracz znajduje się w więzieniu.
	 *
	 * @return true jeżeli gracz jest w więzieniu, false w przeciwnym wypadku
	 */
	public boolean czyWWiezieniu() {
		return this.czyWWiezieniu;
	}

	/**
	 * Sprawdza, czy gracz posiada daną kwotę pieniędzy.
	 * 
	 * @param ilosc
	 *            ilość pieniędzy
	 * @return true jeżeli gracz posiada daną kwotę, false w przeciwnym wypadku
	 */
	public boolean czyMaPieniadze(int ilosc) {
		if (this.iloscPieniedzy < ilosc)
			return false;
		else
			return true;
	}

	/**
	 * Dodaje nieruchomość graczowi
	 *
	 * @param nieruchomosc
	 *            pole, które zostanie dodane graczowi
	 */
	public void dodajNieruchomosc(Pole nieruchomosc) {
		this.posiadaneNieruchomosci.add(nieruchomosc);
	}

	/**
	 * Ustawia pozycję gracza
	 * 
	 * @param pozycja
	 *            zadana pozycja gracza
	 */
	public void setPozycja(int pozycja) {
		this.pozycja = pozycja;
	}

	/**
	 * Zwraca pozycję gracza.
	 * 
	 * @return pozycja gracza
	 */
	public int getPozycja() {
		return this.pozycja;
	}

	/**
	 * Wysyła gracza do więzienia.
	 */
	public void idzDoWiezienia() {
		this.czyWWiezieniu = true;
		this.pozycja = 10;
	}

	/**
	 * Metoda wywoływana na początku tury gracza. Pokazuje graczowi skierowane
	 * do niego oferty handlowe (jeżeli jakieś były), a następnie możliwości
	 * wyjścia z więzienia (jezeli gracz jest w więzieniu).
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
					if (kostka1 == kostka2) {
						this.sumaWyrzuconychOczek = kostka1 + kostka2;
						this.czyWWiezieniu = false;
						Okienka.WyswietlWiadomosc("Udało ci się wyrzucić dublet, możesz wyjść z więzienia.",
								"Więzenie");
					} else {
						probyWyjsciaZWiezienia++;
						Okienka.WyswietlWiadomosc("Nie udało ci się wyrzucić dubletu.", "Więzienie");
					}
				} else {
					this.odejmijPieniadze(50);
					this.czyWWiezieniu = false;
				}
			}
			// gracz musi zapłacić 50 zł
			else {
				Okienka.WyswietlWiadomosc(
						"Wykorzystałeś próby wyrzucenia dubletu. Zapłać" + "50 zł za wyjście z więzienia", "Więzienie");
				this.odejmijPieniadze(50);
				this.czyWWiezieniu = false;
			}
		}
	}

	/**
	 * Losuje o ile gracz ma się ruszyć i wykonuje ruch.
	 */
	public void wykonajRuch() {
		this.sumaWyrzuconychOczek = Kostka.Rzuc() + Kostka.Rzuc();
		this.wykonajRuch(sumaWyrzuconychOczek);
	}

	/**
	 * Wykonuje ruch gracza o zadaną liczbę pól.
	 * 
	 * @param oIle
	 *            o ile pól przesunąć gracza
	 */
	public void wykonajRuch(int oIle) {
		this.sumaWyrzuconychOczek = oIle;
		int dokad = this.pozycja + this.sumaWyrzuconychOczek;
		if (dokad > 39 && dokad == 0)
			this.dodajPieniadze(Ustawienia.kwotaStart);
		dokad %= 40;

		this.pozycja = dokad;
	}

	/**
	 * Zwraca ilość dworców posiadanych przez gracz.
	 *
	 * @return licz dworców posiadanych przez gracza
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
	 * Zwraca ilość obiektów użyteczności publicznej posiadanych przez gracza.
	 *
	 * @return ilość obiektów użyteczności publicznej posiadanych przez gracza
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
	 * Zwraca sume oczek, którą gracz wyrzucił w danej turze.
	 * 
	 * @return ile oczek gracz wyrzucił w tej turze
	 */
	public int getSumaWyrzuconychOczek() {
		return this.sumaWyrzuconychOczek;
	}
}
