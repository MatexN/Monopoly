package pola;

/**
 * Klasa przeznaczona do dziedzieczenia pól gry.
 */

public class PoleGry
{
	/**
	 * Pole przechowuj¹ce nazwê pola.
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
     * Metoda zwracaj¹ca nazwê pola.
     * @return nazwa pola gry
     */
    public String GetNazwa(){
    	return this.nazwa;
    }
}
