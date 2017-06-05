package pola;

import monopoly.Gracz;

/**
 * Pole planszy będące ulicą. Na ulicy można stawiać domy i hotele, a czynsz płacony przez gracza po wejściu
 * na to pole jest zależny od ich ilości.
 */
public class PoleUlica extends PoleNieruchomosc implements Pole
{
    private int[] tablicaCzyszy;
    private int iloscDomow;
    private int cenaDomu;

    public PoleUlica(String nazwa, int cena, int[] tablicaCzyszy, int cenaDomu) {
        super(nazwa, cena);
        this.tablicaCzyszy = tablicaCzyszy;
        this.iloscDomow = 0;
        this.cenaDomu = cenaDomu;
    }

    /**
     * {@inheritDoc}
     * Czynsz jest zależny od ilościu domów (hotelu) zbudowanych na danym polu.
     */
    @Override
    public int liczCzynsz(Gracz gracz) {
        return tablicaCzyszy[iloscDomow];
    }

    /**
     * Metoda pozwalająca na zakup domu na danym polu.
     * Do zakupu domu gracz musi być właścicielem pola, mieć wszystkie pola z danej dzielnicy (ten sam kolor),
     * mieć na to pieniądze a w banku muszą być dostępne domy.
     * Dodatkowo na jednym polu mogą stać maksymalnie 4 domy.
     *
     * @param gracz gracz, który próbuje kupić dom na danym polu
     */
    public void kupDom(Gracz gracz)
    {
        //TODO: sprawdzic, czy gracz ma cala dzielnice
        //TODO: sprawdzic, czy jest dostepny dom i zabrac go z banku
        if ((this.wlasciciel == gracz) && gracz.czyMaPieniadze(cenaDomu) && this.iloscDomow < 4)
        {
            gracz.odejmijPieniadze(cenaDomu);
            this.iloscDomow++;
        }
    }

    /**
     * Metoda pozwalająca na zakup hotelu na danym polu.
     * Aby kupić hotel gracz musi być właścicielem pola, muszą być na nim zbudowane 4 domy, w banku musi być
     * dostępny hotel i gracz musi mieć pieniądze na zakup hotelu. Po zakupie hotelu domy są zwracane do banku.
     *
     * @param gracz gracz, który próbuje kupić hotel na danym polu
     */
    public void kupHotel(Gracz gracz)
    {
        //TODO: zwrócić domy do banku
        if(this.wlasciciel == gracz && gracz.czyMaPieniadze(cenaDomu) && this.iloscDomow == 4)
        {
            gracz.odejmijPieniadze(cenaDomu);
            this.iloscDomow = 5;
        }
    }
}
