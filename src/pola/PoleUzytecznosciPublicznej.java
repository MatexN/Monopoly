package pola;

import monopoly.Gracz;

/**
 * Pole u¿ytecznoœci publicznej. Na planszy znajduj¹ siê 2 takie pola.
 */
public class PoleUzytecznosciPublicznej extends PoleNieruchomosc implements Pole
{
	/**
	 * Konstruktor obiektu klasy Pole U¿ytecznoœci Publicznej.
	 * @param nazwa Pola U¿ytecznoœci Publicznej
	 * @param cena pola
	 */
    public PoleUzytecznosciPublicznej(String nazwa, int cena) {
        super(nazwa, cena);
    }

    /**
     * Czynsz jest zale¿ny od tego ile obiektów u¿ytecznoœci publicznej posiada w³aœciciel pola.
     * Jezeli w³aœciciel posiada jedno takie pole gracz p³aci trzykrotnoœæ sumy wyrzuconych przez siebie oczek,
     * je¿eli posiada obydwa gracz p³aci siedmiokrotnoœæ sumy wyrzuconych oczek.
     *
     * @param gracz osoba, która musi zap³aciæ czynsz
     * 
     * @return Zwracam kwotê do zap³aty przez gracza.
     */
    @Override
    public int liczCzynsz(Gracz gracz)
    {
        if (wlasciciel.liczbaObiektowUzytecznosciPublicznej() == 1)
            return gracz.getSumaWyrzuconychOczek() * 3;
        else if (wlasciciel.liczbaObiektowUzytecznosciPublicznej() == 2)
            return gracz.getSumaWyrzuconychOczek() * 7;
        return 0;
    }
}
