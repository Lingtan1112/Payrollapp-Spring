package in.lingtan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.lingtan.exceptions.InValidEmailIDException;



public class EmailValidator {
	
	private EmailValidator() {
		//Defaut constructor
	}

	public static boolean isValidEmailId(String emailId, String errorMessage) throws InValidEmailIDException {
		if (emailId == null || emailId.isEmpty()) {
			throw new NullPointerException(errorMessage);
		}

		else {
			String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			Pattern regexEmailFormat = Pattern.compile(regex);
			Matcher matchEmailPattern = regexEmailFormat.matcher(emailId);
			if (matchEmailPattern.matches()) {
				return matchEmailPattern.matches();
			}
			throw new InValidEmailIDException(errorMessage);

		}

	}
}
