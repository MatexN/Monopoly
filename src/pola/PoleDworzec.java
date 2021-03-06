package pola;

import monopoly.Gracz;

/**
 * Pole nieruchomości typu dworzec.
 */
public class PoleDworzec extends PoleNieruchomosc implements Pole
{
	/**
	 * Konstruktor klasy PoleDworzec
	 * @param nazwa nieruchomości
	 * @param cena nieruchomości
	 */
    public PoleDworzec(String nazwa, int cena) {
        super(nazwa, cena);
    }

    /**
     * Czynsz dla pola typu Dworzec to 50 * razy dworców posiadanych przez własciela danego dworca.
     * @return czynsz za stanięcie na polu
     */
    @Override
    public int liczCzynsz(Gracz gracz)
    {
        return (wlasciciel.liczbaDworcow() * 50);
    }
}
