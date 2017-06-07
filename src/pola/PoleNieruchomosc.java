package pola;

import monopoly.Gracz;
import util.Okienka;

/**
 * Pole planszy b�d�ce dowoln� nieruchomo�ci�. Klasa przeznaczona do rozszerzenia przez konkretne nieruchomosci,
 * (Ulica, Dworzec, pole u�yteczno�ci publicznej) implementuj�ce metod� liczCzynsz().
 */
public abstract class PoleNieruchomosc extends PoleGry implements Pole
{
    /** Cena zakupu pola.*/
    protected int cena;
    /** W�a�ciciel danego pola. */
    protected Gracz wlasciciel;
    /** Informacja, czy pole zosta�o zastawione. */
    protected boolean czyZastawione;

    /**
     * Tworzy pole o zadanej nazwie i cenie zakupu. Domyslnie pole nie jest zastawione i nie ma wlasciciela.
     * @param nazwa nazwa pola (np. ulica Radzymi�ka)
     * @param cena cena zakupu danego pola
     */
    public PoleNieruchomosc(String nazwa, int cena) {
        super(nazwa);
        this.cena = cena;
        this.wlasciciel = null;
        this.czyZastawione = false;
    }

    /**
     * Zwraca warto�� czynszy, kt�ry musi zap�aci� osoba wchodz�ca na dane pole.
     * @param gracz osoba, kt�ra musi zap�aci� czynsz
     * @return warto�� czynszu
     */
    public abstract int liczCzynsz(Gracz gracz);

    /**
     * Je�li pole nie ma w�a�ciciela gracz mo�e je kupi�, w przeciwnym wypadku pole trafia na licytacj�.
     * Je�eli pole ma w�a�ciciela (i nie jest to gracz, kt�ry w�a�nie na nie wszed�0 gracz musi zap�aci�
     * w�a�cicielowi czynsz.
     * @param gracz gracz, kt�ry wszed� na pole
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
            Okienka.WyswietlWiadomosc("Wszed�e� na pole nale�ace do innego gracza. Zap�ac mu " + czynsz
                                        + " z�.", "P�a�");
            gracz.odejmijPieniadze(czynsz);
            wlasciciel.dodajPieniadze(czynsz);
        }
    }
}
