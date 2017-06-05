package wyjatki;

/**
 * Wyjatek rzucany w przypadku wystapienia bledu podczas tworzenia planszy
 */
public class BoardCreatingException extends Exception
{
    public BoardCreatingException() { }

    public BoardCreatingException(String message) {
        super(message);
    }

    public BoardCreatingException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
