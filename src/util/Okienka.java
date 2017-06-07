package util;

import java.util.LinkedList;
import javax.swing.*;

/**
 * Klasa zawieraj�ca zbi�r okienek wykorzystywanych w programie.
 */
public class Okienka {
	/**
	 * Wy�wietla okno pytaj�ce gracza czy chce kupi� dane pole za okre�lon�
	 * kwot�.
	 * 
	 * @param nazwaPola
	 *            nazwa pola, kt�re gracz mo�e kupi�
	 * @param cena
	 *            cena, kt�r� gracz musi zap�aci� za pole
	 * @return 0 je�eli gracz postanowi kupi� pole, 1 w przeciwnym przypadku
	 */
	public static int WyswietlOknoZakupu(String nazwaPola, int cena) {
		Object[] options = { "Tak", "Nie" };
		int ret = JOptionPane.showOptionDialog(null, "Czy chcesz kupi� pole " + nazwaPola + " za " + cena + " z�?",
				"Zakup pola", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		return ret;
	}

	/**
	 * Wy�wietla graczowi okno z opcj� wyboru sposobu wyj�cia z wi�zienia. Gracz
	 * mo�e spr�bowa� wyrzuci� dublet i wyj�� je�eli mu si� uda lub zap�aci� 50
	 * z� i wyj�� natychmiast.
	 *
	 * @return 0 w przypadku pr�by wyrzucenia dubletu, 1 po wybraniu opcji
	 *         zap�a�
	 */
	public static int WyswietlWyjscieZWiezienia() {
		Object[] options = { "Spr�buj wyrzuci� dublet", "Zap�a� 50 zl" };

		int ret = JOptionPane.showOptionDialog(null, "Jeste� w wi�zieniu. Wybierz opcj� wyj�cia:", "Wi�zienie",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		return ret;
	}

	/**
	 * Wy�wietla wynik rzutu dwoma kostkami.
	 * 
	 * @param oczka1
	 *            wynik rzutu pierwsz� kostk�
	 * @param oczka2
	 *            wynik rzutu drug� kostk�
	 */
	public static void WyswietlKostke(int oczka1, int oczka2) {
		JOptionPane.showMessageDialog(null,
				"Kostka 1: " + oczka1 + "\nKostka 2: " + oczka2 + "\nSuma oczek: " + (oczka1 + oczka2), "Kostka",
				JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Wy�wietla przekazan� wiadomo�� w oknie o danym tytule.
	 * 
	 * @param wiadomosc
	 *            tekst do wy�wietlenia
	 * @param tytul
	 *            nazwa okna
	 */
	public static void WyswietlWiadomosc(String wiadomosc, String tytul) {
		JOptionPane.showMessageDialog(null, wiadomosc, tytul, JOptionPane.PLAIN_MESSAGE);
	}
	/**
	 * Wy�wietla graczowi okno z opcj� wyboru ilo�ci graczy bior�cych udzia� w grze.
	 * @return ilo�� graczy wybran� przez u�ytkownika
	 */

	public static int WyswietlWyborIlosciGraczy() {
		Object[] options = { "2", "3", "4" };

		int ret = JOptionPane.showOptionDialog(null, "Wybierz ilo�� graczy:", "Ilosc Graczy", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		return ret + 2;
	}

	/**
	 * Wy�wietla graczowi okno z nazwami posiadanych przez niego nieruchomo�ci.
	 * @param nieruchomosci posiadane przez aktualnego gracza.
	 */
	public static void WyswietlListePosiadanychNieruchomosci(LinkedList<String> nieruchomosci) {
		JOptionPane.showMessageDialog(null, nieruchomosci.toString(), "Lista Nieruchomosci", JOptionPane.PLAIN_MESSAGE);
	}
}
