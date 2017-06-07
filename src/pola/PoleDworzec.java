package pola;

import monopoly.Gracz;

/**
 * Pole nieruchomo�ci typu dworzec.
 */
public class PoleDworzec extends PoleNieruchomosc implements Pole
{
	/**
	 * Konstruktor klasy PoleDworzec
	 * @param nazwa nieruchomo�ci
	 * @param cena nieruchomo�ci
	 */
    public PoleDworzec(String nazwa, int cena) {
        super(nazwa, cena);
    }

    /**
     * Czynsz dla pola typu Dworzec to 50 * razy dworc�w posiadanych przez w�asciela danego dworca.
     * @return czynsz za stani�cie na polu
     */
    @Override
    public int liczCzynsz(Gracz gracz)
    {
        return (wlasciciel.liczbaDworcow() * 50);
    }
}
