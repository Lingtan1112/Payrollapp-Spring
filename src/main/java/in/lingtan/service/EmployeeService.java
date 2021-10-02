package in.lingtan.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.stereotype.Service;

import in.lingtan.dao.EmployeeRepository;
import in.lingtan.dto.EmployeeDTO;
import in.lingtan.exceptions.EmployeeAlreadyActiveException;
import in.lingtan.exceptions.EmployeeInactiveException;
import in.lingtan.exceptions.EmployeeNotFoundException;
import in.lingtan.exceptions.ExistingEmployeeException;
import in.lingtan.exceptions.InvalidEmployeeIdException;
import in.lingtan.exceptions.InvalidEmployeeIdFormatException;
import in.lingtan.model.Employee;
import in.lingtan.validation.EmployeeServiceValidator;


@Service
public class EmployeeService {

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Autowired
	private final EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeServiceValidator employeeServiceValidator;

	@Autowired
	private ModelMapper modelMapper;



	/**
	 * To add the details of an Employee into a hashmap where the employeeId is the
	 * key for the employee
	 *
	 * @param employee
	 * @return
	 * @throws ExistingEmployeeException
	 * @throws InvalidEmployeeIdException
	 * @throws InvalidEmployeeIdFormatException
	 * @throws Exception
	 */
	public boolean addEmployee(Employee employee) throws ExistingEmployeeException,  InvalidEmployeeIdFormatException {

		boolean isAdded = false;

		long employeeTableSize = employeeRepository.count();

		employee.setName(employee.getFirstName() + " " + employee.getLastName());

		boolean isEmployeeAvailable = employeeServiceValidator.isEmployeeNotAvailable(employee);

		String generatedEmployeeId = generateEmployeeId(employee, employeeTableSize);

		employeeServiceValidator.isValidEmployeeIdFormat(generatedEmployeeId, "Invalid Employee ID");
		employee.setEmployeeID(generatedEmployeeId);
		

		String generatedEmailId = generateEmail(employee);

		employee.setEmail(generatedEmailId);
		employee.setPassword("@Password123");
		employee.setActiveStatus(1);

		if (isEmployeeAvailable) {
			try {
				employeeRepository.save(employee);
			}catch(DuplicateKeyException | DbActionExecutionException e) {
				throw new DuplicateKeyException("Mobile number already registered");
			}
			isAdded = true;
		}
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
	 *
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
			employeeIdCharacters = firstName.substring(0, 1).toUpperCase() + firstName.substring(1, 3)
			+ employee.getLastName().trim().substring(0, 1) + employee.getDob().toString().substring(8, 10);
		} else {
			employeeIdCharacters = firstName.substring(0, 1).toUpperCase() + firstName.substring(1, 4)
			+ employee.getDob().toString().substring(8, 10);
		}
		if ((employeeTableSize == 0)) {
			employeeIdDigits = "00" + Long.toString(firstName.length());
		} else if ((employeeTableSize < 10) && (employeeTableSize > 0)) {
			employeeIdDigits = "0" + Long.toString(employeeTableSize) + Integer.toString(firstName.length());
		} else {
			employeeIdDigits = Long.toString(employeeTableSize) + Integer.toString(firstName.length());
		}
		generatedEmployeeId = employeeIdCharacters + employeeIdDigits;
		return generatedEmployeeId;
	}

	/**
	 * This method generates a unique mail id for the employee using the employee
	 * name and their employeeID.
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
	 *
	 * @param employeeId
	 * @return
	 * @throws EmployeeInactiveException
	 * @throws EmployeeNotFoundException
	 * @throws InvalidEmployeeIdException
	 * @throws Exception
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean deleteEmployeeFromTheDataBase(String employeeId)
			throws EmployeeInactiveException, EmployeeNotFoundException, InvalidEmployeeIdException {
		boolean isDeactivated = false;
		int getId;
		try {
			getId = employeeRepository.getIdOfEmployee(employeeId);
		}catch(Exception e) {
			throw new InvalidEmployeeIdException("Invalid Employee-ID-"+employeeId);
		}
		Optional<Employee> employeeData = employeeRepository.findById(getId);

		boolean isPresent = employeeData.isPresent();
		if (isPresent) {
			Employee employee = employeeData.get();
			if (employee.getActiveStatus() == 1) {
				employee.setActiveStatus(0);
				employeeRepository.save(employee);
				isDeactivated = true;
			} else {
				throw new EmployeeInactiveException("Employee Already Deleted");
			}
		} else {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		return isDeactivated;
	}



	/**
	 * This method returns a hashmap of allt the employee names and their employee
	 * ID available in the database.
	 *
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public List<EmployeeDTO> displayAllEmployees() {

		Iterable<Employee> employeeList = employeeRepository.findByActiveStatus();
		List<EmployeeDTO> employeeListDTO = new ArrayList<>();
		for(Employee employee : employeeList) {
			EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
			employeeListDTO.add(employeeDTO);
		}
		return employeeListDTO;
	}


	/**
	 * This Method gets individual data from database for a specific employeeId.
	 * @param employeeId
	 * @return
	 * @throws EmployeeNotFoundException
	 */
	public List<EmployeeDTO> displayIndividualEmployeeData(String employeeId) throws EmployeeNotFoundException {
		Optional<Employee> employeeData = employeeRepository.getEmployeeData(employeeId);
		List<EmployeeDTO> employeeDataDTO = new ArrayList<>();
		boolean isPresent = employeeData.isPresent();
		if(isPresent) {
			Employee employee = employeeData.get();
			EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
			employeeDataDTO.add(employeeDTO);
			return employeeDataDTO;
		}else {
			throw new EmployeeNotFoundException("Employee Not Found");
		}

	}


	/**
	 * This Method activates the employee
	 *
	 * @param employeeIdToActivate
	 * @return
	 * @throws EmployeeNotFoundException
	 * @throws EmployeeAlreadyActiveException
	 * @throws Exception
	 */
	public boolean activateDeletedEmployee(String employeeIdToActivate)
			throws EmployeeNotFoundException, EmployeeAlreadyActiveException {

		boolean isActivated = false;
		int getId;

		try {
			getId = employeeRepository.getIdOfEmployee(employeeIdToActivate);
		}catch(Exception e) {
			throw new EmployeeAlreadyActiveException("Invalid Employee-ID");
		}
		Optional<Employee> employeeData = employeeRepository.findById(getId);
		System.out.println(employeeData);
		boolean isPresent = employeeData.isPresent();
		if (isPresent) {
			Employee employee = employeeData.get();
			if (employee.getActiveStatus() == 1) {
				throw new EmployeeAlreadyActiveException("The Employee is already active");
			} else {
				employee.setActiveStatus(1);
				employeeRepository.save(employee);
				isActivated = true;
			}
		} else {
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		return isActivated;
	}

}