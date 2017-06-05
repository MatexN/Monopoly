package pola;

import monopoly.Gracz;
import wyjatki.BoardCreatingException;

/**
 * Interfejs reprezentujacy pojedyncze pole na planszy.
 */
public interface Pole 
{
	/** Metoda uruchamiana po wejściu przez gracza na dane pole.
	 * @param gracz osoba, która weszła na pole
     * @throws BoardCreatingException jeżeli wystąpi błąd podczas tworzenia jakiegoś elementu planszy
     * */
	void PodejmijCzynnosc(Gracz gracz) throws BoardCreatingException;
}
