package pola;

import monopoly.Gracz;
import util.Okienka;

/**
 * Pole planszy będące dowolną nieruchomością. Klasa przeznaczona do rozszerzenia przez konkretne nieruchomosci,
 * (Ulica, Dworzec, pole użyteczności publicznej) implementujące metodę liczCzynsz().
 */
public abstract class PoleNieruchomosc extends PoleGry implements Pole
{
    /** Cena zakupu pola.*/
    protected int cena;
    /** Właściciel danego pola. */
    protected Gracz wlasciciel;
    /** Informacja, czy pole zostało zastawione. */
    protected boolean czyZastawione;

    /**
     * Tworzy pole o zadanej nazwie i cenie zakupu. Domyslnie pole nie jest zastawione i nie ma wlasciciela.
     * @param nazwa nazwa pola (np. ulica Radzymińśka)
     * @param cena cena zakupu danego pola
     */
    public PoleNieruchomosc(String nazwa, int cena) {
        super(nazwa);
        this.cena = cena;
        this.wlasciciel = null;
        this.czyZastawione = false;
    }

    /**
     * Zwraca wartość czynszy, który musi zapłacić osoba wchodząca na dane pole.
     * @param gracz osoba, która musi zapłacić czynsz
     * @return wartość czynszu
     */
    public abstract int liczCzynsz(Gracz gracz);

    /**
     * {@inheritDoc}
     * Jeśli pole nie ma właściciela gracz może je kupić, w przeciwnym wypadku pole trafia na licytację.
     * Jeżeli pole ma właściciela (i nie jest to gracz, który właśnie na nie wszedł0 gracz musi zapłacić
     * właścicielowi czynsz.
     * @param gracz gracz, który wszedł na pole
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
            Okienka.WyswietlWiadomosc("Wszedłeś na pole należace do innego gracza. Zapłac mu " + czynsz
                                        + " zł.", "Płać");
            gracz.odejmijPieniadze(czynsz);
            wlasciciel.dodajPieniadze(czynsz);
        }
    }
}
