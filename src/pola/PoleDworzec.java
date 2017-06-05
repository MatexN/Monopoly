package pola;

import monopoly.Gracz;

/**
 * Pole nieruchomości typu dworzec.
 */
public class PoleDworzec extends PoleNieruchomosc implements Pole
{
    public PoleDworzec(String nazwa, int cena) {
        super(nazwa, cena);
    }

    /**
     * {@inheritDoc}
     * Czynsz dla pola typu Dworzec to 50 * razy dworców posiadanych przez własciela danego dworca.
     */
    @Override
    public int liczCzynsz(Gracz gracz)
    {
        return (wlasciciel.liczbaDworcow() * 50);
    }
}
