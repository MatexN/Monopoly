package pola;

import monopoly.Gracz;

/**
 * Pole planszy, z którym nie jest zwi¹zana ¿adna akcja po zatrzymaniu.
 * Takie pola to: Start, Wiêzienie i Parking.
 */
public class PoleSpecjalne extends PoleGry implements Pole
{

	/**
	 * Konstruktor pola specjalnego
	 * @param nazwa Nazwa Pola specjalnego
	 */
    public PoleSpecjalne(String nazwa) {
        super(nazwa);
    }

    /**
     * Nie wykonuje ¿adnej akcji.
     *
     * @param gracz, który wszed³ na pole
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz) {}
}
