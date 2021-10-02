package in.lingtan.validation;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


import in.lingtan.dao.EmployeeRepository;

import in.lingtan.exceptions.ExistingEmployeeException;
import in.lingtan.model.Employee;





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
		System.out.println("Hello");
		List<Employee> employeeMap = employeeRepository.checkForExistingEmployee();
		System.out.println(employeeMap.size());
		for (Employee employeeData : employeeMap) {

			if (employeeData.getMobileNumber() == (employee.getMobileNumber())
					&& (employeeData.getLastName().toLowerCase().replaceAll("\\s", "")
					.equalsIgnoreCase(employee.getLastName().toLowerCase().replaceAll("\\s", "")))
					) {
				if
					(employeeData.getActiveStatus() == 1) {
					throw new ExistingEmployeeException(employee.getName() + " - Already registered");
				
				} else {
					throw new ExistingEmployeeException(employee.getName() + " - Already available - "+"&employeeId="+employeeData.getEmployeeID());
				}
			} else {
				isAvailable = true;
			}
		}
		return isAvailable;
	}
}	

