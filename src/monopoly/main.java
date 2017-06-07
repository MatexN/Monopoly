package monopoly;

import util.Okienka;
import wyjatki.BoardCreatingException;

/**
 * G³ówna klasa programu
 */
public class main {
	public static void main(String[] args) throws BoardCreatingException {
		try {
			GlowneOkno okno = new GlowneOkno();
			okno.setVisible(true);
		} catch (BoardCreatingException e) {
			Okienka.WyswietlWiadomosc("Wyst¹pi³ b³¹d podczas tworzenia planszy. Uruchom grê ponownie", "B³¹d");
		}
	}

}
