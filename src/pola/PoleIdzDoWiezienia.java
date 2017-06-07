package pola;

import monopoly.Gracz;

/**
 * Pole planszy, po wejœciu na które gracz trafia do wiêzienia.
 */
public class PoleIdzDoWiezienia extends PoleGry implements Pole
{
	/**
	 * Konstruktor pola Idz Do Wiêzienia
	 * @param nazwa pola
	 */
    public PoleIdzDoWiezienia(String nazwa) {
        super(nazwa);
    }

    /**
     * Umieszcza gracza w wiêzieniu.
     * @param gracz gracz, który wszed³ na pole
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz)
    {
        gracz.idzDoWiezienia();
    }
}
