package karty;

import monopoly.Gracz;
import util.Okienka;

/**
 * Klasa reprezentuj¹ca karty Szansa zmieniaj¹cej wartoœæ konta.
 */
public class SzansaPieniadze implements KartaSzansa
{
	/**
	 * Pole przechowuj¹ce kwote z karty Szansa
	 */
    int kwota;
    /**
     * Pole przechowuj¹ce tekst karty Szansa
     */
    String tekst;

    /**
     * Konstruktor klasy
     *
     * @param kwota iloœæ pieniêdzy, któr¹ zyska/straci gracz. Wartoœæ ujemna
     *              oznacza, ¿e dana kwota zostanie zabrana graczowi.
     * @param tekst tekst karty wyœwietlany graczowi
     */
    public SzansaPieniadze(int kwota, String tekst)
    {
        this.kwota = kwota;
        this.tekst = tekst;
    }

    /**
     * Metoda wykonywana po wylosowaniu karty przez gracza.
     * Wyœwietla okno z zawartoœci¹ karty i dodaje/odejmuje graczowi
     * iloœæ pieniêdzy zawart¹ w polu kwota.
     *
     * @param gracz dla którego ma byæ wykonana czynnoœæ
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
