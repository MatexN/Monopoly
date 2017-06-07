package karty;

import monopoly.Gracz;
import util.Okienka;
import util.Ustawienia;

/**
 * Klasa reprezentuj¹ca karty Szansa typu IdŸ do wiêzienia. Po jej wylosowaniu
 * gracz trafia do wiêzienia.
 */
public class SzansaIdzDoWiezienia implements KartaSzansa {

	/**
	 * Metoda wykonywana po wylosowaniu karty przez gracza, wyœwietla okno z
	 * zawartoœci¹ karty i umieszcza gracza w wiêzieniu.
	 * @param gracz dla którego ma byæ wykonana czynnoœæ
	 */
	@Override
	public void WykonajCzynnosc(Gracz gracz) {
		String tekst = "Zosta³eœ aresztowany. PrzejdŸ prosto do wiêzienia. "
				+ "Nie przechodŸ przez start. Nie pobieraj " + Ustawienia.kwotaStart + " z³";
		Okienka.WyswietlWiadomosc(tekst, "Szansa");
		gracz.idzDoWiezienia();
	}
}
