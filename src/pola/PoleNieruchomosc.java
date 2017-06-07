package pola;

import monopoly.Gracz;
import util.Okienka;

/**
 * Pole planszy bêd¹ce dowoln¹ nieruchomoœci¹. Klasa przeznaczona do rozszerzenia przez konkretne nieruchomosci,
 * (Ulica, Dworzec, pole u¿ytecznoœci publicznej) implementuj¹ce metodê liczCzynsz().
 */
public abstract class PoleNieruchomosc extends PoleGry implements Pole
{
    /** Cena zakupu pola.*/
    protected int cena;
    /** W³aœciciel danego pola. */
    protected Gracz wlasciciel;
    /** Informacja, czy pole zosta³o zastawione. */
    protected boolean czyZastawione;

    /**
     * Tworzy pole o zadanej nazwie i cenie zakupu. Domyslnie pole nie jest zastawione i nie ma wlasciciela.
     * @param nazwa nazwa pola (np. ulica Radzymiñœka)
     * @param cena cena zakupu danego pola
     */
    public PoleNieruchomosc(String nazwa, int cena) {
        super(nazwa);
        this.cena = cena;
        this.wlasciciel = null;
        this.czyZastawione = false;
    }

    /**
     * Zwraca wartoœæ czynszy, który musi zap³aciæ osoba wchodz¹ca na dane pole.
     * @param gracz osoba, która musi zap³aciæ czynsz
     * @return wartoœæ czynszu
     */
    public abstract int liczCzynsz(Gracz gracz);

    /**
     * Jeœli pole nie ma w³aœciciela gracz mo¿e je kupiæ, w przeciwnym wypadku pole trafia na licytacjê.
     * Je¿eli pole ma w³aœciciela (i nie jest to gracz, który w³aœnie na nie wszed³0 gracz musi zap³aciæ
     * w³aœcicielowi czynsz.
     * @param gracz gracz, który wszed³ na pole
     */
    @Override
    public void PodejmijCzynnosc(Gracz gracz)
    {
        //pole nie ma wlasciciela
        if (wlasciciel == null)
        {
            if (gracz.czyMaPieniadze(this.cena))
            {
                //wyswietlenie opcji zakupu
                int decyzja = Okienka.WyswietlOknoZakupu(this.nazwa, this.cena);
                if (decyzja == 0)
                {
                    //gracz postanowil kupic pole
                    gracz.odejmijPieniadze(this.cena);
                    this.wlasciciel = gracz;
                    gracz.dodajNieruchomosc(this);
                }
            }
        }

        // gracz wszedl na pole nalezace do innego gracza i pole nie jest zastawione
        // gracz musi zaplacic czynsz wlascicielowi pola
        else if ((wlasciciel != gracz) && !this.czyZastawione )
        {
            int czynsz = this.liczCzynsz(gracz);
            Okienka.WyswietlWiadomosc("Wszed³eœ na pole nale¿ace do innego gracza. Zap³ac mu " + czynsz
                                        + " z³.", "P³aæ");
            gracz.odejmijPieniadze(czynsz);
            wlasciciel.dodajPieniadze(czynsz);
        }
    }
}
