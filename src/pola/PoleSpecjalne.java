package pola;

import monopoly.Gracz;

/**
 * Pole planszy, z którym nie jest związana żadna akcja po zatrzymaniu.
 * Takie pola to: Start, Więzienie i Parking.
 */
public class PoleSpecjalne extends PoleGry implements Pole
{

    public PoleSpecjalne(String nazwa) {
        super(nazwa);
    }

    /**
     * {@inheritDoc}
     * Nie wykonuje żadnej akcji.
     *
     * @param gracz, który wszedł na pole
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz) {}
}
