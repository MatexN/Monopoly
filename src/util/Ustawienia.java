package util;

import java.awt.*;

/**
 * Klasa zawieraj�ca ustawienia aplikacji.
 */
public class Ustawienia
{
    /** Kwota, kt�r� gracz otrzymuje przy przej�ciu przez pole Start.*/
    public static int kwotaStart = 200;
    /** Ilo�� kart Szansa typu Idz do wi�zienia.*/
    public static int iloscSzansaDoWiezienia = 2;
    /** Ilo�� kart Szansa typu Idz do.*/
    public static int iloscSzansaIdzDo = 10;
    /** Scie�ka do pliku xml z kartami Szansa typu Pieni�dze.*/
    public static String plikKartSzansa = "config/szansa.xml";
    /** Scie�ka do pliku xml opisuj�cego pola na planszy.*/
    public static String plikPlansza = "config/plansza.xml";
    /** Tablica zawieraj�ca kolory poszczeg�lnych graczy */
    public static Color[] koloryGraczy = {Color.blue, Color.orange, Color.red, Color.black};
}
