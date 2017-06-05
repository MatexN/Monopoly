package karty;

import monopoly.Gracz;
import util.Okienka;

/**
 * Klasa reprezentująca karty Szansa typu Zyskaj/Strać x zł
 */
public class SzansaPieniadze implements KartaSzansa
{
    int kwota;
    String tekst;

    /**
     * Konstruktor klasy
     *
     * @param kwota ilość pieniędzy, którą zyska/straci gracz. Wartość ujemna
     *              oznacza, że dana kwota zostanie zabrana graczowi.
     * @param tekst tekst karty wyświetlany graczowi
     */
    public SzansaPieniadze(int kwota, String tekst)
    {
        this.kwota = kwota;
        this.tekst = tekst;
    }

    /**
     * Metoda wykonywana po wylosowaniu karty przez gracza.
     * Wyświetla okno z zawartością karty i dodaje/odejmuje graczowi
     * ilość pieniędzy zawartą w polu kwota.
     *
     * @param gracz  osoba, która wylosowała daną kartę
     */
    @Override
    public void WykonajCzynnosc(Gracz gracz)
    {
        Okienka.WyswietlWiadomosc(tekst, "Szasna");
        if (kwota < 0)
            gracz.odejmijPieniadze((-1) * kwota);
        else
            gracz.dodajPieniadze(kwota);
    }
}
