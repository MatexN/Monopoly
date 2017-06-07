package util;

import java.awt.*;

/**
 * Klasa zawieraj¹ca ustawienia aplikacji.
 */
public class Ustawienia
{
    /** Kwota, któr¹ gracz otrzymuje przy przejœciu przez pole Start.*/
    public static int kwotaStart = 200;
    /** Iloœæ kart Szansa typu Idz do wiêzienia.*/
    public static int iloscSzansaDoWiezienia = 2;
    /** Iloœæ kart Szansa typu Idz do.*/
    public static int iloscSzansaIdzDo = 10;
    /** Scie¿ka do pliku xml z kartami Szansa typu Pieni¹dze.*/
    public static String plikKartSzansa = "config/szansa.xml";
    /** Scie¿ka do pliku xml opisuj¹cego pola na planszy.*/
    public static String plikPlansza = "config/plansza.xml";
    /** Tablica zawieraj¹ca kolory poszczególnych graczy */
    public static Color[] koloryGraczy = {Color.blue, Color.orange, Color.red, Color.black};
}
