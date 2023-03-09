package handleException;

public class InvalidInputCustomException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidInputCustomException(String message)
    {
        super(message);
    }

}
