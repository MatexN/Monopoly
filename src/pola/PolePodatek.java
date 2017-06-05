package pola;

import monopoly.Gracz;
import util.Okienka;

/**
 * Pole planszy, po wejściu na które gracz musi zapłacić określony podatek.
 */
public class PolePodatek extends PoleGry implements Pole
{
    private int kwotaPodatku;

    public PolePodatek(String nazwa, int kwotaPodatku) {
        super(nazwa);
        this.kwotaPodatku = kwotaPodatku;
    }

    /**
     * {@inheritDoc}
     * Odejmuje graczowi ilość pieniędzy równą podatkowi, który
     * musi on zapłacić. W wyniku tej akcji ilość pieniędzy posiadana przez gracza może stać się ujemna,
     * jest to sprawdzane dopiero pod koniec tury.
     * @param gracz gracz, który wszedł na pole
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz)
    {
        String wiadomosc = "Zapłać " + kwotaPodatku + " podatku.";
        Okienka.WyswietlWiadomosc(wiadomosc, "Podatek");
        gracz.odejmijPieniadze(kwotaPodatku);
    }
}
