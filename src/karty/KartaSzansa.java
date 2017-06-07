package karty;

import monopoly.Gracz;

/**
 * Interfejs KartaSzansa dostarcza metodê wykonywan¹ przez gracza po wylosowaniu
 * danej karty.
 */
public interface KartaSzansa {
	/**
	 * Metoda wykonuj¹ca czynnoœæ przypisan¹ do wylosowanej karty.
	 * @param gracz dla którego ma byæ wykonana czynnoœæ
	 */
	void WykonajCzynnosc(Gracz gracz);
}
