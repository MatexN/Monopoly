package monopoly;

import util.Okienka;
import wyjatki.BoardCreatingException;

/**
 * Główna klasa programu
 */
public class main {
	public static void main(String[] args) throws BoardCreatingException {
		try {
			GlowneOkno okno = new GlowneOkno();
			okno.setVisible(true);
		} catch (BoardCreatingException e) {
			Okienka.WyswietlWiadomosc("Wystąpił błąd podczas tworzenia planszy. Uruchom grę ponownie", "Błąd");
		}
	}

}
