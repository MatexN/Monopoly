package pola;

import monopoly.Gracz;
import util.Okienka;

/**
 * Pole planszy, po wejœciu na które gracz musi zap³aciæ okreœlony podatek.
 */
public class PolePodatek extends PoleGry implements Pole
{
	/**
	 * Pole przechowuj¹ce kwotê do zap³aty po staniêciu na Polu Podatku.
	 */
    private int kwotaPodatku;

    /**
     * Konstruktor Pola Podatku
     * @param nazwa pola
     * @param kwotaPodatku Kwota Podatku do zap³aty
     */
    public PolePodatek(String nazwa, int kwotaPodatku) {
        super(nazwa);
        this.kwotaPodatku = kwotaPodatku;
    }

    /**
     * Odejmuje graczowi iloœæ pieniêdzy równ¹ podatkowi, który
     * musi on zap³aciæ. Iloœæ pieniêdzy posiadana przez gracza mo¿e staæ siê ujemna,
     * jest to sprawdzane dopiero pod koniec tury.
     * @param gracz gracz, który wszed³ na pole
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz)
    {
        String wiadomosc = "Zap³aæ " + kwotaPodatku + " podatku.";
        Okienka.WyswietlWiadomosc(wiadomosc, "Podatek");
        gracz.odejmijPieniadze(kwotaPodatku);
    }
}
