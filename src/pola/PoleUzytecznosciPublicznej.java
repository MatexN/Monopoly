package pola;

import monopoly.Gracz;

/**
 * Pole użyteczności publicznej. Na planszy znajdują się 2 takie pola.
 */
public class PoleUzytecznosciPublicznej extends PoleNieruchomosc implements Pole
{
    public PoleUzytecznosciPublicznej(String nazwa, int cena) {
        super(nazwa, cena);
    }

    /**
     * {@inheritDoc}
     * Czynsz jest zależny od tego ile obiektów użyteczności publicznej posiada właściciel pola.
     * Jezeli właściciel posiada jedno takie pole gracz płaci trzykrotność sumy wyrzuconych przez siebie oczek,
     * jeżeli posiada obydwa gracz płaci siedmiokrotność sumy wyrzuconych oczek.
     *
     * @param gracz osoba, która musi zapłacić czynsz
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
