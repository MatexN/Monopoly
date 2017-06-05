package karty;

import monopoly.Gracz;
import util.Okienka;
import util.Ustawienia;

/**
 * Klasa reprezentująca karty Szansa typu Idź na pole o indeksie idzDo.
 * Indeks jest losowany przy tworzeniu obiektu, może byc dowolnym polem na planszy.
 */
public class SzansaIdzDo implements KartaSzansa
{
    private int idzDo;

    /**
     * Konstruktor klasy. Losuje i ustawia indeks pola, na które
     * będzie musiał pójść gracz po wylosowaniu tej karty.
     */
    public SzansaIdzDo()
    {
        this.idzDo = (int)(Math.random() * 40);
    }

    /**
     * Metoda wykonywana po wylosowaniu karty przez gracza,
     * wyświetla okno z zawartością karty i zmienia pozycję gracza
     * na pozycję z karty. Jeżeli gracz musiałby przejść przez pole
     * Start, żeby dojść na zadane pole są mu dodawane pieniądze
     * za przejście przez Start.
     *
     * @param gracz osoba, która wylosowała daną kartę
     */
    @Override
    public void WykonajCzynnosc(Gracz gracz)
    {
        String tekst = "Udaj się na pole " + idzDo + ". Jeżeli przechodzisz" +
                "przez start pobierz 200zł.";

        Okienka.WyswietlWiadomosc(tekst, "Szansa");

        if (gracz.getPozycja() > idzDo)
            gracz.dodajPieniadze(Ustawienia.kwotaStart);

        gracz.setPozycja(idzDo);
    }
}
