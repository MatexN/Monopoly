package pola;

import monopoly.Gracz;
import wyjatki.BoardCreatingException;

/**
 * Interfejs reprezentujacy pojedyncze pole na planszy.
 */
public interface Pole 
{
	/** Metoda uruchamiana po wej�ciu przez gracza na dane pole.
	 * @param gracz osoba, kt�ra wesz�a na pole
     * @throws BoardCreatingException je�eli wyst�pi b��d podczas tworzenia jakiego� elementu planszy
     * */
	void PodejmijCzynnosc(Gracz gracz) throws BoardCreatingException;
}
