package pola;

import monopoly.Gracz;

/**
 * Pole u�yteczno�ci publicznej. Na planszy znajduj� si� 2 takie pola.
 */
public class PoleUzytecznosciPublicznej extends PoleNieruchomosc implements Pole
{
	/**
	 * Konstruktor obiektu klasy Pole U�yteczno�ci Publicznej.
	 * @param nazwa Pola U�yteczno�ci Publicznej
	 * @param cena pola
	 */
    public PoleUzytecznosciPublicznej(String nazwa, int cena) {
        super(nazwa, cena);
    }

    /**
     * Czynsz jest zale�ny od tego ile obiekt�w u�yteczno�ci publicznej posiada w�a�ciciel pola.
     * Jezeli w�a�ciciel posiada jedno takie pole gracz p�aci trzykrotno�� sumy wyrzuconych przez siebie oczek,
     * je�eli posiada obydwa gracz p�aci siedmiokrotno�� sumy wyrzuconych oczek.
     *
     * @param gracz osoba, kt�ra musi zap�aci� czynsz
     * 
     * @return Zwracam kwot� do zap�aty przez gracza.
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
