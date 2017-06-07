package karty;

import monopoly.Gracz;

/**
 * Interfejs KartaSzansa dostarcza metod� wykonywan� przez gracza po wylosowaniu
 * danej karty.
 */
public interface KartaSzansa {
	/**
	 * Metoda wykonuj�ca czynno�� przypisan� do wylosowanej karty.
	 * @param gracz dla kt�rego ma by� wykonana czynno��
	 */
	void WykonajCzynnosc(Gracz gracz);
}
