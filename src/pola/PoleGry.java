package pola;

/**
 * Klasa przeznaczona do dziedzieczenia p�l gry.
 */

public class PoleGry
{
	/**
	 * Pole przechowuj�ce nazw� pola.
	 */
    protected String nazwa;
    /**
     * Konstruktor klasy PoleGry.
     * @param nazwa pola gry
     */
    public PoleGry(String nazwa) {
        this.nazwa = nazwa;
    }
    /**
     * Metoda zwracaj�ca nazw� pola.
     * @return nazwa pola gry
     */
    public String GetNazwa(){
    	return this.nazwa;
    }
}
