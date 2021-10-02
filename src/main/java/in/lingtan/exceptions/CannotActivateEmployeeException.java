package in.lingtan.exceptions;

public class CannotActivateEmployeeException extends Exception{
	private static final long serialVersionUID = 1L;

	public CannotActivateEmployeeException(String message) {
        super(message);
    }
}
