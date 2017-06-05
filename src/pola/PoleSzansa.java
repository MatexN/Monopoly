package pola;

import karty.KartaSzansa;
import karty.TaliaKartSzansa;
import monopoly.Gracz;
import wyjatki.BoardCreatingException;

/**
 * Pole planszy typu Szansa. Po wejściu na pole gracz losuje kartę
 * Szansa i wykonuje zawarte na niej polecenie.
 */
public class PoleSzansa extends PoleGry implements Pole
{
    public PoleSzansa(String nazwa) {
        super(nazwa);
    }

    /**
     * {@inheritDoc}
     * Losuje kartę Szansa z talii
     * i wykonuje polecenie na wylosowanej karcie.
     *
     * @param gracz gracz, który wszedł na pole
     * @throws BoardCreatingException jeżeli próba utworzenia jakiegoś elementu się nie powiedzie
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz) throws BoardCreatingException
    {
        KartaSzansa wylosowanaKarta = TaliaKartSzansa.LosujKarte();
        wylosowanaKarta.WykonajCzynnosc(gracz);
    }
}
