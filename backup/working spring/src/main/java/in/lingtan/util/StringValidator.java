package in.lingtan.util;

import in.lingtan.exceptions.EmptyStringException;

public class StringValidator {

	private StringValidator() {
		// Default Constructor
	}
	
	/**
	 * This verifies whether the role field is filled or not
	 * 
	 * @param role
	 * @return
	 * @throws EmptyStringException 
	 */
	public static boolean isStringNotNullOrEmpty(String stringToValidate, String errorMessage) throws EmptyStringException {
		
		if (stringToValidate == null || stringToValidate.trim().isEmpty()) {
			throw new EmptyStringException(errorMessage);
		}
		return true;
	}

}
