package pola;

import monopoly.Gracz;

/**
 * Pole planszy, po wejściu na które gracz trafia do więzienia.
 */
public class PoleIdzDoWiezienia extends PoleGry implements Pole
{
    public PoleIdzDoWiezienia(String nazwa) {
        super(nazwa);
    }

    /**
     * {@inheritDoc}
     * Umieszcza gracza w więzieniu.
     * @param gracz gracz, który wszedł na pole
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz)
    {
        gracz.idzDoWiezienia();
    }
}
