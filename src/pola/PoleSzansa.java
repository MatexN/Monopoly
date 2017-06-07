package pola;

import karty.KartaSzansa;
import karty.TaliaKartSzansa;
import monopoly.Gracz;
import wyjatki.BoardCreatingException;

/**
 * Pole planszy typu Szansa. Po wejœciu na pole gracz losuje kartê
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
     * Losuje kartê Szansa z talii
     * i wykonuje polecenie na wylosowanej karcie.
     *
     * @param gracz gracz, który wszed³ na pole
     * @throws BoardCreatingException je¿eli próba utworzenia jakiegoœ elementu siê nie powiedzie
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz) throws BoardCreatingException
    {
        KartaSzansa wylosowanaKarta = TaliaKartSzansa.LosujKarte();
        wylosowanaKarta.WykonajCzynnosc(gracz);
    }
}
