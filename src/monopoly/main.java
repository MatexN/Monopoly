package monopoly;

import util.Okienka;
import wyjatki.BoardCreatingException;

/**
 * G��wna klasa programu
 */
public class main {
	public static void main(String[] args) throws BoardCreatingException {
		try {
			GlowneOkno okno = new GlowneOkno();
			okno.setVisible(true);
		} catch (BoardCreatingException e) {
			Okienka.WyswietlWiadomosc("Wyst�pi� b��d podczas tworzenia planszy. Uruchom gr� ponownie", "B��d");
		}
	}

}
