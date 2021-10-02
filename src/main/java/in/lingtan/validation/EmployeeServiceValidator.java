package in.lingtan.validation;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.lingtan.dao.EmployeeRepository;
import in.lingtan.exceptions.ExistingEmployeeException;
import in.lingtan.exceptions.InvalidEmployeeIdFormatException;
import in.lingtan.model.Employee;


@Service
public class EmployeeServiceValidator {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/**
	 * This method verifies whether an employee is already registered or not.
	 * 
	 * @param l
	 * @return
	 * @throws ExistingEmployeeException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public boolean isEmployeeNotAvailable(Employee employee) throws ExistingEmployeeException {
		boolean isAvailable = true;
		
		Iterable<Employee> employeeMap = employeeRepository.checkForExistingEmployee();
		
		for (Employee employeeData : employeeMap) {

			if (employeeData.getMobileNumber() == (employee.getMobileNumber())
					&& (employeeData.getLastName().toLowerCase().replaceAll("\\s", "")
					.equalsIgnoreCase(employee.getLastName().toLowerCase().replaceAll("\\s", "")))
					) {
				if
					(employeeData.getActiveStatus() == 1) {
					throw new ExistingEmployeeException(employee.getName() + " - Already registered");
				
				} else {
					throw new ExistingEmployeeException(employee.getName() + " - Already available - employeeId="+employeeData.getEmployeeID());
				}
			} else {
				isAvailable = true;
			}
		}
		return isAvailable;
	}
	
	/**
	 * This method validates whether the employeeId is in valid Format.
	 * i.e) valid id : Ling12007.
	 * @param employeeId
	 * @return
	 * @throws InvalidEmployeeIdFormatException 
	 */
	
	public boolean isValidEmployeeIdFormat(String employeeId,String message) throws  InvalidEmployeeIdFormatException {

		String digitsOfId = employeeId.replaceAll("\\D", "");
		String stringOfId = employeeId.replaceAll("\\d", "");
		if ((stringOfId.length() == 4) && (digitsOfId.length() == 5)) {
			return true;
		}
		throw new InvalidEmployeeIdFormatException(message);
	}
	
}	

