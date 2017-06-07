package karty;

import monopoly.Gracz;
import util.Okienka;
import util.Ustawienia;

/**
 * Klasa reprezentuj�ca karty Szansa typu Id� do wi�zienia. Po jej wylosowaniu
 * gracz trafia do wi�zienia.
 */
public class SzansaIdzDoWiezienia implements KartaSzansa {

	/**
	 * Metoda wykonywana po wylosowaniu karty przez gracza, wy�wietla okno z
	 * zawarto�ci� karty i umieszcza gracza w wi�zieniu.
	 * @param gracz dla kt�rego ma by� wykonana czynno��
	 */
	@Override
	public void WykonajCzynnosc(Gracz gracz) {
		String tekst = "Zosta�e� aresztowany. Przejd� prosto do wi�zienia. "
				+ "Nie przechod� przez start. Nie pobieraj " + Ustawienia.kwotaStart + " z�";
		Okienka.WyswietlWiadomosc(tekst, "Szansa");
		gracz.idzDoWiezienia();
	}
}
