package pola;

import monopoly.Gracz;

/**
 * Pole planszy, po wej�ciu na kt�re gracz trafia do wi�zienia.
 */
public class PoleIdzDoWiezienia extends PoleGry implements Pole
{
	/**
	 * Konstruktor pola Idz Do Wi�zienia
	 * @param nazwa pola
	 */
    public PoleIdzDoWiezienia(String nazwa) {
        super(nazwa);
    }

    /**
     * Umieszcza gracza w wi�zieniu.
     * @param gracz gracz, kt�ry wszed� na pole
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz)
    {
        gracz.idzDoWiezienia();
    }
}
