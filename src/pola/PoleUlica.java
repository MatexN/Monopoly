package pola;

import monopoly.Gracz;

/**
 * Pole planszy bêd¹ce ulic¹. Na ulicy mo¿na stawiaæ domy i hotele, a czynsz p³acony przez gracza po wejœciu
 * na to pole jest zale¿ny od ich iloœci.
 */
public class PoleUlica extends PoleNieruchomosc implements Pole
{
	/**
	 * Pole przechowuj¹ce tablicê wysokoœci op³at po staniêciu obcego gracza na nim.
	 */
    private int[] tablicaCzyszy;
    /**
     * Pole przechowuj¹ce iloœæ domków stoj¹cych na nim.
     */
    private int iloscDomow;
    /**
     * Pole przechowuj¹ce cenê zakupu domku.
     */
    private int cenaDomu;

    /**
     * Konstruktor tworz¹cy obiekt klasy PoleUlica.
     * Przypisuje wartoœci parametrów do swoich wartoœci.
     * Iloœæ domków ustawiam na pocz¹tku na 0.
     * @param nazwa Nazwa nieruchomoœci
     * @param cena Cena zakupu nieruchomoœci
     * @param tablicaCzyszy Tablica Czynszy za nieruchomoœæ
     * @param cenaDomu Cena zakupu domku na nieruchomoœci
     */
    public PoleUlica(String nazwa, int cena, int[] tablicaCzyszy, int cenaDomu) {
        super(nazwa, cena);
        this.tablicaCzyszy = tablicaCzyszy;
        this.iloscDomow = 0;
        this.cenaDomu = cenaDomu;
    }

    /**
     * Czynsz jest zale¿ny od iloœciu domów (hotelu) zbudowanych na danym polu.
     * @return Tablica z wysokoœci¹ czynszu do zap³aty
     */
    @Override
    public int liczCzynsz(Gracz gracz) {
        return tablicaCzyszy[iloscDomow];
    }

    /**
     * Metoda pozwalaj¹ca na zakup domu na danym polu.
     * Do zakupu domu gracz musi byæ w³aœcicielem pola, mieæ wszystkie pola z danej dzielnicy (ten sam kolor),
     * mieæ na to pieni¹dze a w banku musz¹ byæ dostêpne domy.
     * Dodatkowo na jednym polu mog¹ staæ maksymalnie 4 domy.
     *
     * @param gracz gracz, który próbuje kupiæ dom na danym polu
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
     * Metoda pozwalaj¹ca na zakup hotelu na danym polu.
     * Aby kupiæ hotel gracz musi byæ w³aœcicielem pola, musz¹ byæ na nim zbudowane 4 domy, w banku musi byæ
     * dostêpny hotel i gracz musi mieæ pieni¹dze na zakup hotelu. Po zakupie hotelu domy s¹ zwracane do banku.
     *
     * @param gracz gracz, który próbuje kupiæ hotel na danym polu
     */
    public void kupHotel(Gracz gracz)
    {
        //TODO: zwróciæ domy do banku
        if(this.wlasciciel == gracz && gracz.czyMaPieniadze(cenaDomu) && this.iloscDomow == 4)
        {
            gracz.odejmijPieniadze(cenaDomu);
            this.iloscDomow = 5;
        }
    }
}
