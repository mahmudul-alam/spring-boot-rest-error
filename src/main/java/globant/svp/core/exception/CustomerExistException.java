package globant.svp.core.exception;

public class CustomerExistException extends RuntimeException {
	
	private static final String defaultMessage = "Resource Already Exist"; 
	public CustomerExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerExistException(String message) {
		super(message);
	}

	public CustomerExistException() {
		super(defaultMessage);
	}
}
