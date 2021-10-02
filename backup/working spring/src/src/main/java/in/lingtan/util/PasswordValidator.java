package in.lingtan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.lingtan.exceptions.InvalidPasswordFormatException;




public class PasswordValidator {
	
	private PasswordValidator() {
		//Default constructor
	}

	/**
	 * This method verifies whether the password is in valid format or not
	 * 
	 * @param password
	 * @return
	 * @throws InvalidPasswordFormatException 
	 */
	public static boolean isValidPasswordFormat(String password, String errorMessage) throws InvalidPasswordFormatException {
		boolean isValidFormat = false;
		if (password != null) {
			String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,15}$";
			Pattern regexPattern = Pattern.compile(regex);
			Matcher matchCheck = regexPattern.matcher(password);
			isValidFormat = matchCheck.matches();
			if (isValidFormat) {
				return isValidFormat;
			}
			throw new InvalidPasswordFormatException(errorMessage);
		}
		return isValidFormat;

	}
}
