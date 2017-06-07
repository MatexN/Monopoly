package wyjatki;

/**
 * Wyjatek rzucany w przypadku wystapienia bledu podczas tworzenia planszy
 */
public class BoardCreatingException extends Exception
{
    /**
	 * Domyœlny numer seryjny
	 */
	private static final long serialVersionUID = 1L;

	public BoardCreatingException() { }

    public BoardCreatingException(String message) {
        super(message);
    }

    public BoardCreatingException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
