package util;

import java.util.LinkedList;
import javax.swing.*;

/**
 * Klasa zawieraj¹ca zbiór okienek wykorzystywanych w programie.
 */
public class Okienka {
	/**
	 * Wyœwietla okno pytaj¹ce gracza czy chce kupiæ dane pole za okreœlon¹
	 * kwotê.
	 * 
	 * @param nazwaPola
	 *            nazwa pola, które gracz mo¿e kupiæ
	 * @param cena
	 *            cena, któr¹ gracz musi zap³aciæ za pole
	 * @return 0 je¿eli gracz postanowi kupiæ pole, 1 w przeciwnym przypadku
	 */
	public static int WyswietlOknoZakupu(String nazwaPola, int cena) {
		Object[] options = { "Tak", "Nie" };
		int ret = JOptionPane.showOptionDialog(null, "Czy chcesz kupiæ pole " + nazwaPola + " za " + cena + " z³?",
				"Zakup pola", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		return ret;
	}

	/**
	 * Wyœwietla graczowi okno z opcj¹ wyboru sposobu wyjœcia z wiêzienia. Gracz
	 * mo¿e spróbowaæ wyrzuciæ dublet i wyjœæ je¿eli mu siê uda lub zap³aciæ 50
	 * z³ i wyjœæ natychmiast.
	 *
	 * @return 0 w przypadku próby wyrzucenia dubletu, 1 po wybraniu opcji
	 *         zap³aæ
	 */
	public static int WyswietlWyjscieZWiezienia() {
		Object[] options = { "Spróbuj wyrzuciæ dublet", "Zap³aæ 50 zl" };

		int ret = JOptionPane.showOptionDialog(null, "Jesteœ w wiêzieniu. Wybierz opcjê wyjœcia:", "Wiêzienie",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		return ret;
	}

	/**
	 * Wyœwietla wynik rzutu dwoma kostkami.
	 * 
	 * @param oczka1
	 *            wynik rzutu pierwsz¹ kostk¹
	 * @param oczka2
	 *            wynik rzutu drug¹ kostk¹
	 */
	public static void WyswietlKostke(int oczka1, int oczka2) {
		JOptionPane.showMessageDialog(null,
				"Kostka 1: " + oczka1 + "\nKostka 2: " + oczka2 + "\nSuma oczek: " + (oczka1 + oczka2), "Kostka",
				JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Wyœwietla przekazan¹ wiadomoœæ w oknie o danym tytule.
	 * 
	 * @param wiadomosc
	 *            tekst do wyœwietlenia
	 * @param tytul
	 *            nazwa okna
	 */
	public static void WyswietlWiadomosc(String wiadomosc, String tytul) {
		JOptionPane.showMessageDialog(null, wiadomosc, tytul, JOptionPane.PLAIN_MESSAGE);
	}
	/**
	 * Wyœwietla graczowi okno z opcj¹ wyboru iloœci graczy bior¹cych udzia³ w grze.
	 * @return iloœæ graczy wybran¹ przez u¿ytkownika
	 */

	public static int WyswietlWyborIlosciGraczy() {
		Object[] options = { "2", "3", "4" };

		int ret = JOptionPane.showOptionDialog(null, "Wybierz iloœæ graczy:", "Ilosc Graczy", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		return ret + 2;
	}

	/**
	 * Wyœwietla graczowi okno z nazwami posiadanych przez niego nieruchomoœci.
	 * @param nieruchomosci posiadane przez aktualnego gracza.
	 */
	public static void WyswietlListePosiadanychNieruchomosci(LinkedList<String> nieruchomosci) {
		JOptionPane.showMessageDialog(null, nieruchomosci.toString(), "Lista Nieruchomosci", JOptionPane.PLAIN_MESSAGE);
	}
}
