package util;

/**
 * Klasa reprezentuj�c� 6-cio �cienn� kostk�.
 */
public class Kostka 
{
    /**
     * Losuje liczb� z kostki.
     * @return liczba ca�kowita z zakresu 1-6
     */
	public static int Rzuc()
	{
		return (int)(Math.random() * 6) + 1;
	}
}
