package in.lingtan.exceptions;

public class PasswordDoNotMatchWithOldPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordDoNotMatchWithOldPasswordException(String message) {
		super(message);
	}

}
