package in.lingtan.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import in.lingtan.exceptions.CannotActivateEmployeeException;
import in.lingtan.exceptions.CannotRegisterEmployeeException;
import in.lingtan.model.Employee;

public interface EmployeeServiceDAO {

	/**
	 * This Method Registers a new employee into a Database with their data.
	 * 
	 * @param employee
	 * @return 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws CannotRegisterEmployeeException 
	 */
	boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException, CannotRegisterEmployeeException;

	/**
	 * This Method calculates the number of rows in the table
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	int tableSize() throws ClassNotFoundException, SQLException;

	/**
	 * This Method returns a Map of mobile number and employee's last name of all
	 * the employees in the table. This map is used for the purpose of checking
	 * whether an employee is already registered or not
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	Map<Long, Employee> isEmployeeNotAvailableInDAO() throws ClassNotFoundException, SQLException;

	/**
	 * This Method returns a HashMap of employeeId and their corressponding employee
	 * Name for the purpose of displaying to the admin.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Employee> displayAllEmployees() throws ClassNotFoundException, SQLException;

	/**
	 * This method gives a map of individual employee data of a particular employee in the database.
	 * @param employeeId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Employee> displayDetailOfAnIndividualEmployee(String employeeId) throws ClassNotFoundException, SQLException;

	/**
	 * This method is used to make an employee inactive thereby not getting displayed in the screen in the list of employees.
	 * @param employeeId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	boolean deleteEmployeeFromTable(String employeeId) throws ClassNotFoundException, SQLException;

	boolean activateDeletedEmployee(String employeeIdToActivate)
			throws ClassNotFoundException, SQLException, CannotActivateEmployeeException;

}