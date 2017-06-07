package karty;

import monopoly.Gracz;
import util.Okienka;
import util.Ustawienia;

/**
 * Klasa reprezentuj¹ca karty Szansa typu IdŸ na pole.
 */
public class SzansaIdzDo implements KartaSzansa {
	/**
	 * Zmienna przechowuj¹ca wylosowany indeks pola.
	 */
	private int idzDo;

	/**
	 * Konstruktor klasy. Losuje i ustawia indeks pola, na które bêdzie musia³
	 * pójœæ gracz po wylosowaniu tej karty.
	 */
	public SzansaIdzDo() {
		this.idzDo = (int) (Math.random() * 40);
	}

	/**
	 * Metoda wykonywana po wylosowaniu karty przez gracza, wyœwietla informacjê
	 * o przeskoku na pole o wylosowanym indeksie, je¿eli gracz przeszed³ przez
	 * start dodaje mu premiê. Nastêpnie zmienia pozycjê gracza na wylosowany
	 * indeks.
	 * @param gracz dla którego ma byæ wykonana czynnoœæ
	 */
	@Override
	public void WykonajCzynnosc(Gracz gracz) {
		String tekst = "Udaj siê na pole " + idzDo + ". Je¿eli przechodzisz " + "przez start pobierz 200z³.";

		Okienka.WyswietlWiadomosc(tekst, "Szansa");

		if (gracz.getPozycja() > idzDo)
			gracz.dodajPieniadze(Ustawienia.kwotaStart);

		gracz.setPozycja(idzDo);
	}
}
