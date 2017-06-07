package pola;

import monopoly.Gracz;

/**
 * Pole planszy, z kt�rym nie jest zwi�zana �adna akcja po zatrzymaniu.
 * Takie pola to: Start, Wi�zienie i Parking.
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
     * Nie wykonuje �adnej akcji.
     *
     * @param gracz, kt�ry wszed� na pole
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz) {}
}
