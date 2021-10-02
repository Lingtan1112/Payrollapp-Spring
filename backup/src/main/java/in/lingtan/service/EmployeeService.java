package in.lingtan.service;

import java.sql.SQLException;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.lingtan.dao.EmployeeRepository;
import in.lingtan.exceptions.CannotRegisterEmployeeException;

import in.lingtan.model.Employee;

import in.lingtan.util.EmailValidator;
import in.lingtan.validation.EmployeeServiceValidator;
import in.lingtan.validation.UserServiceValidator;




@Service
public class EmployeeService {



	public EmployeeService() {
		// Default constructor.
	}
	@Autowired
	EmployeeRepository employeeRepository;
	


	/**
	 * To add the details of an Employee into a hashmap where the employeeId is the
	 * key for the employee
	 * @param employee
	 * @return
	 * @throws Exception 
	 */
	public boolean addEmployee(Employee employee) throws Exception {
		
		boolean isAdded = false;
		long employeeTableSize = employeeRepository.count();
		employee.setName(employee.getFirstName() + " " + employee.getLastName());
		
		EmployeeServiceValidator employeeServiceValidator  = new EmployeeServiceValidator();
		//boolean isEmployeeAvailable = employeeServiceValidator.isEmployeeNotAvailable(employee);
		
		String generatedEmployeeId = generateEmployeeId(employee, employeeTableSize);
		UserServiceValidator.isValidEmployeeId(generatedEmployeeId, "Invalid Employee ID");
		employee.setEmployeeID(generatedEmployeeId);

		String generatedEmailId = generateEmail(employee);
		EmailValidator.isValidEmailId(generatedEmailId, "Invalid Email-ID");
		
		employee.setEmail(generatedEmailId);
		employee.setPassword("@Password123");
		employee.setActiveStatus(1);
		
		System.out.println(employee);
		
		//if (isEmployeeAvailable) {
			//throw new CannotRegisterEmployeeException("Employee Already Available");
			
		//} else {
			try {
				employeeRepository.save(employee);
				isAdded=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Cannot Register Employee");
			
		}
		//}
		return isAdded;
	}
	


	/**
	 * this will create an unique employeeId with a combo of 4 letters of name and 4
	 * numbers of unique pattern
	 * 
	 * employeeIdCharacters - creates a string of length 4, which has the employee
	 * Name with the first character capitalized.
	 * 
	 * employeeIdDigits - The employee digits creates a unique pattern of number of
	 * length four where the first 2 digits are their date of birth the -next two
	 * numbers are the order of their joining list of employees and the last number
	 * is the employee name's length.
	 * @param employeeTableSize 
	 * 
	 * @param name
	 * @param dob
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public String generateEmployeeId(Employee employee, long employeeTableSize) {

		String employeeIdCharacters;
		String generatedEmployeeId;
		String employeeIdDigits;
		String firstName = employee.getFirstName().trim();
		

		if (firstName.length() <= 3) {
			employeeIdCharacters = firstName.substring(0, 1).toUpperCase()
					+ firstName.substring(1, 3) + employee.getLastName().trim().substring(0, 1)
					+ employee.getDob().toString().substring(8, 10);
		}else {
			employeeIdCharacters = firstName.substring(0, 1).toUpperCase()
					+ firstName.substring(1, 4) + employee.getDob().toString().substring(8, 10);
		} 
		if ((employeeTableSize == 0)) {
			employeeIdDigits = "00" + Long.toString(firstName.length());
		} else if ((employeeTableSize < 10) && (employeeTableSize > 0)) {
			employeeIdDigits = "0" + Long.toString(employeeTableSize)
					+ Integer.toString(firstName.length());
		} else {
			employeeIdDigits = Long.toString(employeeTableSize)
					+ Integer.toString(firstName.length());
		}
		generatedEmployeeId = employeeIdCharacters + employeeIdDigits;
		return generatedEmployeeId;
	}

	/**
	 * This method generates a unique mail id for the employee using the employee
	 * name and their employeeID.
	 * 
	 * This method uses the employee's first name and last name where the last name
	 * is free from inbetween spaces and all the string is made to lowercase
	 * 
	 * @param firstName
	 * @param employeeId
	 * @param lastName
	 * @param dob
	 * @return
	 */

	public String generateEmail(Employee employee) {
		String firstName = employee.getFirstName().trim();
		String lastName = employee.getLastName().trim();
		return firstName.toLowerCase() + "." + lastName.toLowerCase().replaceAll("\\s", "")
				+ employee.getEmployeeID().substring(4, 9) + ("@companyname.com");
	
	}
	
	/**
	 * This method deletes("makes the employee inactive") from viewing screen
	 * @param employeeId
	 * @return 
	 * @throws Exception 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean deleteEmployeeFromTheDataBase(String employeeId) throws Exception{ 
		boolean isDeactivated = false;
		 Optional<Employee> employeeData = employeeRepository.findById(employeeId);
		 System.out.println(employeeData);
		 boolean isPresent = employeeData.isPresent();	
		 if(isPresent) {
			 Employee employee = employeeData.get();
			 employee.setActiveStatus(0);
			 employeeRepository.save(employee);
			 isDeactivated = true;
		 }
		 else {
			 throw new Exception("Employee Not Found");
		 }
		 
		 return isDeactivated;
	}
			
		
		
	
	
	/**
	 * This method returns a hashmap of allt the employee names and their employee ID available in the database.
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public Iterable<Employee> displayAllEmployees(){
		return employeeRepository.findByActiveStatus(1);
		
	}
	
	/** 
	 * This Method gets individual data from database for a specific employeeId.
	 * @param employeeId
	 * @return
	 */
	public Optional<Employee> displayIndividualEmployeeData(String employeeId){
		
		return employeeRepository.findById(employeeId);
	}

	/**
	 * This Method activates the employee
	 * @param employeeIdToActivate
	 * @return
	 * @throws Exception
	 */
	public boolean activateDeletedEmployee(String employeeIdToActivate) throws Exception {
		
		 boolean isActivated = false;
		 Optional<Employee> employeeData = employeeRepository.findById(employeeIdToActivate);
		 System.out.println(employeeData);
		 boolean isPresent = employeeData.isPresent();	
		 if(isPresent) {
			 Employee employee = employeeData.get();
			 employee.setActiveStatus(1);
			 employeeRepository.save(employee);
			 isActivated = true;
		 }
		 else {
			 throw new Exception("Employee Not Found");
		 }
		 
		 return isActivated;
	}


	
	
	


}