package util;

/**
 * Klasa reprezentuj¹c¹ 6-cio œcienn¹ kostkê.
 */
public class Kostka 
{
    /**
     * Losuje liczbê z kostki.
     * @return liczba ca³kowita z zakresu 1-6
     */
	public static int Rzuc()
	{
		return (int)(Math.random() * 6) + 1;
	}
}
