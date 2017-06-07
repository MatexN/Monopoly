package karty;

import monopoly.Gracz;
import util.Okienka;

/**
 * Klasa reprezentuj�ca karty Szansa zmieniaj�cej warto�� konta.
 */
public class SzansaPieniadze implements KartaSzansa
{
	/**
	 * Pole przechowuj�ce kwote z karty Szansa
	 */
    int kwota;
    /**
     * Pole przechowuj�ce tekst karty Szansa
     */
    String tekst;

    /**
     * Konstruktor klasy
     *
     * @param kwota ilo�� pieni�dzy, kt�r� zyska/straci gracz. Warto�� ujemna
     *              oznacza, �e dana kwota zostanie zabrana graczowi.
     * @param tekst tekst karty wy�wietlany graczowi
     */
    public SzansaPieniadze(int kwota, String tekst)
    {
        this.kwota = kwota;
        this.tekst = tekst;
    }

    /**
     * Metoda wykonywana po wylosowaniu karty przez gracza.
     * Wy�wietla okno z zawarto�ci� karty i dodaje/odejmuje graczowi
     * ilo�� pieni�dzy zawart� w polu kwota.
     *
     * @param gracz dla kt�rego ma by� wykonana czynno��
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
