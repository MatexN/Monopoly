package karty;

import monopoly.Gracz;
import util.Okienka;
import util.Ustawienia;

/**
 * Klasa reprezentuj�ca karty Szansa typu Id� na pole.
 */
public class SzansaIdzDo implements KartaSzansa {
	/**
	 * Zmienna przechowuj�ca wylosowany indeks pola.
	 */
	private int idzDo;

	/**
	 * Konstruktor klasy. Losuje i ustawia indeks pola, na kt�re b�dzie musia�
	 * p�j�� gracz po wylosowaniu tej karty.
	 */
	public SzansaIdzDo() {
		this.idzDo = (int) (Math.random() * 40);
	}

	/**
	 * Metoda wykonywana po wylosowaniu karty przez gracza, wy�wietla informacj�
	 * o przeskoku na pole o wylosowanym indeksie, je�eli gracz przeszed� przez
	 * start dodaje mu premi�. Nast�pnie zmienia pozycj� gracza na wylosowany
	 * indeks.
	 * @param gracz dla kt�rego ma by� wykonana czynno��
	 */
	@Override
	public void WykonajCzynnosc(Gracz gracz) {
		String tekst = "Udaj si� na pole " + idzDo + ". Je�eli przechodzisz " + "przez start pobierz 200z�.";

		Okienka.WyswietlWiadomosc(tekst, "Szansa");

		if (gracz.getPozycja() > idzDo)
			gracz.dodajPieniadze(Ustawienia.kwotaStart);

		gracz.setPozycja(idzDo);
	}
}
