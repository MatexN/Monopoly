package util;

import javax.swing.*;

/**
 * Klasa zawierająca zbiór okienek wykorzystywanych w programie.
 */
public class Okienka
{
    /**
     * Wyświetla okno pytające gracza czy chce kupić dane pole za określoną kwotę.
     * @param nazwaPola nazwa pola, które gracz może kupić
     * @param cena cena, którą gracz musi zapłacić za pole
     * @return 0 jeżeli gracz postanowi kupić pole, 1 w przeciwnym przypadku
     */
    public static int WyswietlOknoZakupu(String nazwaPola, int cena)
    {
        Object[] options = {"Tak", "Nie"};
        //TODO: zmienic ikone
        Icon icon = new ImageIcon("img/kalk.gif");
        int ret = JOptionPane.showOptionDialog(null,
                "Czy chcesz kupić pole " + nazwaPola + " za " + cena + " zł?",
                "Zakup pola",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                icon,           //ikona
                options,        //tablica z trescia guzikow
                options[1]);    //domyslnie zaznaczony guzik

        return ret;
    }

    /**
     * Wyświetla graczowi okno z opcją wyboru sposobu wyjścia z więzienia.
     * Gracz może spróbować wyrzucić dublet i wyjść jeżeli mu się uda
     * lub zapłacić 50 zł i wyjść natychmiast.
     *
     * @return 0 w przypadku próby wyrzucenia dubletu, 1 po wybraniu opcji zapłać
     */
    public static int WyswietlWyjscieZWiezienia()
    {
        Object[] options = {"Spróbuj wyrzucić dublet", "Zapłać 50 zl"};

        int ret = JOptionPane.showOptionDialog(null,
                "Jesteś w więzieniu. Wybierz opcję wyjścia:",
                "Więzienie",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,           //ikona
                options,        //tablica z trescia guzikow
                options[0]);    //domyslnie zaznaczony guzik

        return ret;
    }


    /**
     * Wyświetla wynik rzutu dwoma kostkami.
     * @param oczka1 wynik rzutu pierwszą kostką
     * @param oczka2 wynik rzutu drugą kostką
     */
    public static void WyswietlKostke(int oczka1, int oczka2)
    {
        JOptionPane.showMessageDialog(null,
                "Kostka 1: " + oczka1 + ", kostka 2: " + oczka2 + ".",
                "Kostka",
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Wyświetla przekazaną wiadomość w oknie o danym tytule.
     * @param wiadomosc tekst do wyświetlenia
     * @param tytul nazwa okna
     */
    public static void WyswietlWiadomosc(String wiadomosc, String tytul)
    {
        JOptionPane.showMessageDialog(null,
                wiadomosc,
                tytul,
                JOptionPane.PLAIN_MESSAGE);
    }
}
