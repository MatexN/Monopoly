package util;

/**
 * Klasa reprezentującą 6-cio ścienną kostkę.
 */
public class Kostka 
{
    /**
     * Losuje liczbę z kostki.
     * @return liczba całkowita z zakresu 0-6
     */
	public static int Rzuc()
	{
		return (int)(Math.random() * 6) + 1;
	}
}
