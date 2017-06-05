package karty;

import monopoly.Gracz;
import util.Okienka;
import util.Ustawienia;

/**
 * Klasa reprezentująca karty Szansa typu Idź do więzienia.
 * Po jej wylosowaniu gracz trafia do więzienia.
 */
public class SzansaIdzDoWiezienia implements KartaSzansa
{
    /**
     * Metoda wykonywana po wylosowaniu karty przez gracza,
     * wyświetla okno z zawartością karty i umieszcza gracza w więzieniu.
     *
     * @param gracz  osoba, która wylosowała daną kartę
     */
    @Override
    public void WykonajCzynnosc(Gracz gracz)
    {
        String tekst = "Zostałeś aresztowany. Przejdź prosto do więzienia. " +
                "Nie przechodź przez start. Nie pobieraj " + Ustawienia.kwotaStart + " zł";
        Okienka.WyswietlWiadomosc(tekst, "Szansa");
        gracz.idzDoWiezienia();
    }
}
