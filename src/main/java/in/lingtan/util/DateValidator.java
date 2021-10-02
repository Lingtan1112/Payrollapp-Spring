package in.lingtan.util;

import java.time.LocalDate;

import in.lingtan.exceptions.InvalidDateException;




public class DateValidator {

	private DateValidator() {
		
		//Default Constructor
	}

	/**
	 * This method checks whether the date is not a future date or not This method
	 * 
	 * @param date
	 * @return
	 * @throws InvalidDateException 
	 */
	
	
	public static boolean isNotAFutureDate(LocalDate date, String errorMessage) throws InvalidDateException {

		if (date.isAfter(LocalDate.now())) {
			throw new InvalidDateException(errorMessage);
		}
		return true;
	}
	
	/**
	 * This method checks whether a date is in date format or not and returns the date if in date format.
	 * @param dateToCheck
	 * @param errorMessage
	 * @return
	 * @throws InvalidDateException
	 */

	public static LocalDate isDateFormatOrNot(String dateToCheck, String errorMessage) throws InvalidDateException {
		try {
			
			return LocalDate.parse(dateToCheck);
		} catch (Exception e) {
			throw new InvalidDateException(errorMessage);
		}
	}

}
