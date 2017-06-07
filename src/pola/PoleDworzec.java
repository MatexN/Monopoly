package pola;

import monopoly.Gracz;

/**
 * Pole nieruchomoœci typu dworzec.
 */
public class PoleDworzec extends PoleNieruchomosc implements Pole
{
	/**
	 * Konstruktor klasy PoleDworzec
	 * @param nazwa nieruchomoœci
	 * @param cena nieruchomoœci
	 */
    public PoleDworzec(String nazwa, int cena) {
        super(nazwa, cena);
    }

    /**
     * Czynsz dla pola typu Dworzec to 50 * razy dworców posiadanych przez w³asciela danego dworca.
     * @return czynsz za staniêcie na polu
     */
    @Override
    public int liczCzynsz(Gracz gracz)
    {
        return (wlasciciel.liczbaDworcow() * 50);
    }
}
