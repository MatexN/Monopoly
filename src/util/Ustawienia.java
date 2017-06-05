package util;

import java.awt.*;

/**
 * Klasa zawierająca ustawienia aplikacji.
 */
public class Ustawienia
{
    /** Ilość graczy */
    public static int iloscGraczy = 2;
    /** Kwota, którą gracz otrzymuje przy przejściu przez pole Start.*/
    public static int kwotaStart = 200;
    /** Ilość kart Szansa typu {@link karty.SzansaIdzDoWiezienia}.*/
    public static int iloscSzansaDoWiezienia = 2;
    /** Ilość kart Szansa typu {@link karty.SzansaIdzDo}.*/
    public static int iloscSzansaIdzDo = 10;
    /** Scieżka do pliku xml z kartami Szansa typu {@link karty.SzansaPieniadze}.*/
    public static String plikKartSzansa = "config/szansa.xml";
    /** Scieżka do pliku xml opisującego pola na planszy.*/
    public static String plikPlansza = "config/plansza.xml";
    /** Tablica zawierająca kolory poszczególnych graczy */
    public static Color[] koloryGraczy = {Color.blue, Color.orange, Color.red, Color.black};
}
