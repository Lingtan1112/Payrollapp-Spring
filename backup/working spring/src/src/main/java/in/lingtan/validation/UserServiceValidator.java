package in.lingtan.validation;

import in.lingtan.exceptions.InvalidEmployeeIdException;
import in.lingtan.exceptions.InvalidEmployeeIdFormatException;
import in.lingtan.exceptions.InvalidEmployeeIdLengthException;
import in.lingtan.util.StringValidator;

public class UserServiceValidator {

	private UserServiceValidator() {
		// Default constructor
	}

	/**
	 * This method validates whether the employeeId is in valid Format.
	 * i.e) valid id : Ling12007.
	 * @param employeeId
	 * @return
	 * @throws InvalidEmployeeIdFormatException 
	 */

	public static boolean isValidEmployeeIdFormat(String employeeId) throws  InvalidEmployeeIdFormatException {

		String digitsOfId = employeeId.replaceAll("\\D", "");
		String stringOfId = employeeId.replaceAll("\\d", "");
		if ((stringOfId.length() == 4) && (digitsOfId.length() == 5)) {
			return true;
		}
		throw new InvalidEmployeeIdFormatException("Invalid EmployeeID Format");
	}

	/**
	 * This method verifies whether the length of the employeeID is valid or not.
	 * @param employeeId
	 * @return
	 * @throws InvalidEmployeeIdLengthException 
	 */
	public static boolean isValidEmployeeIdLength(String employeeId) throws InvalidEmployeeIdLengthException {
		
		if (employeeId == null || employeeId.length() == 9 ) {
			return true;
		}
		throw new InvalidEmployeeIdLengthException("Invalid Length");
	}

	/**
	 * This method is a combined validation method where all the validations are
	 * combined to give one result for employeeID
	 * @param employeeId
	 * @return
	 * @throws InvalidEmployeeIdException 
	 */

	public static boolean isValidEmployeeId(String employeeId, String errorMessage) throws InvalidEmployeeIdException {
		try {
			StringValidator.isStringNotNullOrEmpty(employeeId, errorMessage);
			isValidEmployeeIdFormat(employeeId);
			isValidEmployeeIdLength(employeeId);
			return true;
			
		} catch (Exception e) {
			throw new InvalidEmployeeIdException(e.getMessage());
		}
	}

}
