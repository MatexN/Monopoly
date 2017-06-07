package pola;

import karty.KartaSzansa;
import karty.TaliaKartSzansa;
import monopoly.Gracz;
import wyjatki.BoardCreatingException;

/**
 * Pole planszy typu Szansa. Po wej�ciu na pole gracz losuje kart�
 * Szansa i wykonuje zawarte na niej polecenie.
 */
public class PoleSzansa extends PoleGry implements Pole
{
	/**
	 * Konstruktor Pola Szansa
	 * @param nazwa pola
	 */
    public PoleSzansa(String nazwa) {
        super(nazwa);
    }

    /**
     * Losuje kart� Szansa z talii
     * i wykonuje polecenie na wylosowanej karcie.
     *
     * @param gracz gracz, kt�ry wszed� na pole
     * @throws BoardCreatingException je�eli pr�ba utworzenia jakiego� elementu si� nie powiedzie
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz) throws BoardCreatingException
    {
        KartaSzansa wylosowanaKarta = TaliaKartSzansa.LosujKarte();
        wylosowanaKarta.WykonajCzynnosc(gracz);
    }
}
