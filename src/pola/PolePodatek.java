package pola;

import monopoly.Gracz;
import util.Okienka;

/**
 * Pole planszy, po wej�ciu na kt�re gracz musi zap�aci� okre�lony podatek.
 */
public class PolePodatek extends PoleGry implements Pole
{
	/**
	 * Pole przechowuj�ce kwot� do zap�aty po stani�ciu na Polu Podatku.
	 */
    private int kwotaPodatku;

    /**
     * Konstruktor Pola Podatku
     * @param nazwa pola
     * @param kwotaPodatku Kwota Podatku do zap�aty
     */
    public PolePodatek(String nazwa, int kwotaPodatku) {
        super(nazwa);
        this.kwotaPodatku = kwotaPodatku;
    }

    /**
     * Odejmuje graczowi ilo�� pieni�dzy r�wn� podatkowi, kt�ry
     * musi on zap�aci�. Ilo�� pieni�dzy posiadana przez gracza mo�e sta� si� ujemna,
     * jest to sprawdzane dopiero pod koniec tury.
     * @param gracz gracz, kt�ry wszed� na pole
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz)
    {
        String wiadomosc = "Zap�a� " + kwotaPodatku + " podatku.";
        Okienka.WyswietlWiadomosc(wiadomosc, "Podatek");
        gracz.odejmijPieniadze(kwotaPodatku);
    }
}
