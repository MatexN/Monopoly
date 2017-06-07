package pola;

import monopoly.Gracz;
import wyjatki.BoardCreatingException;

/**
 * Interfejs reprezentujacy pojedyncze pole na planszy.
 */
public interface Pole 
{
	/** Metoda uruchamiana po wejœciu przez gracza na dane pole.
	 * @param gracz osoba, która wesz³a na pole
     * @throws BoardCreatingException je¿eli wyst¹pi b³¹d podczas tworzenia jakiegoœ elementu planszy
     * */
	void PodejmijCzynnosc(Gracz gracz) throws BoardCreatingException;
}
