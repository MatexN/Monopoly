package pola;

import monopoly.Gracz;

/**
 * Pole planszy b�d�ce ulic�. Na ulicy mo�na stawia� domy i hotele, a czynsz p�acony przez gracza po wej�ciu
 * na to pole jest zale�ny od ich ilo�ci.
 */
public class PoleUlica extends PoleNieruchomosc implements Pole
{
	/**
	 * Pole przechowuj�ce tablic� wysoko�ci op�at po stani�ciu obcego gracza na nim.
	 */
    private int[] tablicaCzyszy;
    /**
     * Pole przechowuj�ce ilo�� domk�w stoj�cych na nim.
     */
    private int iloscDomow;
    /**
     * Pole przechowuj�ce cen� zakupu domku.
     */
    private int cenaDomu;

    /**
     * Konstruktor tworz�cy obiekt klasy PoleUlica.
     * Przypisuje warto�ci parametr�w do swoich warto�ci.
     * Ilo�� domk�w ustawiam na pocz�tku na 0.
     * @param nazwa Nazwa nieruchomo�ci
     * @param cena Cena zakupu nieruchomo�ci
     * @param tablicaCzyszy Tablica Czynszy za nieruchomo��
     * @param cenaDomu Cena zakupu domku na nieruchomo�ci
     */
    public PoleUlica(String nazwa, int cena, int[] tablicaCzyszy, int cenaDomu) {
        super(nazwa, cena);
        this.tablicaCzyszy = tablicaCzyszy;
        this.iloscDomow = 0;
        this.cenaDomu = cenaDomu;
    }

    /**
     * Czynsz jest zale�ny od ilo�ciu dom�w (hotelu) zbudowanych na danym polu.
     * @return Tablica z wysoko�ci� czynszu do zap�aty
     */
    @Override
    public int liczCzynsz(Gracz gracz) {
        return tablicaCzyszy[iloscDomow];
    }

    /**
     * Metoda pozwalaj�ca na zakup domu na danym polu.
     * Do zakupu domu gracz musi by� w�a�cicielem pola, mie� wszystkie pola z danej dzielnicy (ten sam kolor),
     * mie� na to pieni�dze a w banku musz� by� dost�pne domy.
     * Dodatkowo na jednym polu mog� sta� maksymalnie 4 domy.
     *
     * @param gracz gracz, kt�ry pr�buje kupi� dom na danym polu
     */
    public void kupDom(Gracz gracz)
    {
        if ((this.wlasciciel == gracz) && gracz.czyMaPieniadze(cenaDomu) && this.iloscDomow < 4)
        {
            gracz.odejmijPieniadze(cenaDomu);
            this.iloscDomow++;
        }
    }

    /**
     * Metoda pozwalaj�ca na zakup hotelu na danym polu.
     * Aby kupi� hotel gracz musi by� w�a�cicielem pola, musz� by� na nim zbudowane 4 domy, w banku musi by�
     * dost�pny hotel i gracz musi mie� pieni�dze na zakup hotelu. Po zakupie hotelu domy s� zwracane do banku.
     *
     * @param gracz gracz, kt�ry pr�buje kupi� hotel na danym polu
     */
    public void kupHotel(Gracz gracz)
    {
        //TODO: zwr�ci� domy do banku
        if(this.wlasciciel == gracz && gracz.czyMaPieniadze(cenaDomu) && this.iloscDomow == 4)
        {
            gracz.odejmijPieniadze(cenaDomu);
            this.iloscDomow = 5;
        }
    }
}
