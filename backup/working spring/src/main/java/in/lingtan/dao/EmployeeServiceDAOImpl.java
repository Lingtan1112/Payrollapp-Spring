package in.lingtan.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import in.lingtan.dao.impl.EmployeeServiceDAO;
import in.lingtan.exceptions.CannotActivateEmployeeException;
import in.lingtan.exceptions.CannotRegisterEmployeeException;
import in.lingtan.model.Employee;
import in.lingtan.util.ConnectionUtil;

@Repository
public class EmployeeServiceDAOImpl implements EmployeeServiceDAO {
	
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	private static final String NAME = "name";
	private static final String EMPLOYEE_ID = "employee_id";
	private static final String ROLE = "role";
	private static final String MOBILE_NUMBER = "mobile_number";
	private static final String GENDER = "gender";
	private static final String EMPLOYEE_EMAIL_ID = "email_id";
	private static final String JOINED_DATE = "joined_date";
	private static final String DOB = "dob";
	private static final String ACTIVE_STATUS = "active_status";
	private static final String INSERT_EMPLOYEE_DATA_QUERY = "insert into employee_data (first_name,last_name,name,role ,mobile_number,email_id,employee_id,dob,joined_date,password,gender,active_status) values (?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String IS_EMPLOYEE_AVAILABLE_QUERY = "select last_name,mobile_number,active_status,employee_id from employee_data";
	private static final String DISPLAY_ALL_EMPLOYEES_QUERY = "select first_name,employee_id from employee_data where active_status=1";
	private static final String DISPLAY_INDIVIDUAL_EMPLOYEES_DATA_QUERY = "select first_name,name,employee_id,mobile_number,email_id,gender,role,dob,joined_date from employee_data where employee_id=?";
	private static final String DELETE_EMPLOYEE_QUERY = "update employee_data set active_status=0 where employee_id=?";
	private static final String SET_EMPLOYEE_ACTIVE_QUERY = "update employee_data set active_status=1 where employee_id=?";
	
	
	/**
	 * This Method Registers a new employee into a Database with their data.
	 * 
	 * @param employee
	 * @return 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws CannotRegisterEmployeeException 
	 */
	@Override
	public boolean addEmployee(Employee employee) throws ClassNotFoundException, SQLException, CannotRegisterEmployeeException {
		boolean isAdded = false;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = INSERT_EMPLOYEE_DATA_QUERY;

			pst = connection.prepareStatement(sql);

			pst.setString(1, employee.getFirstName());
			pst.setString(2, employee.getLastName());
			pst.setString(3, employee.getName());
			pst.setString(4, employee.getRole());
			pst.setLong(5, employee.getMobileNumber());
			pst.setString(6, employee.getEmail());
			pst.setString(7, employee.getEmployeeID());
			pst.setObject(8, employee.getDob());
			pst.setObject(9, employee.getJoiningDate());
			pst.setString(10, employee.getPassword());
			pst.setString(11, employee.getGender());
			pst.setInt(12, 1);

			int rs = pst.executeUpdate();
			if(rs==1) {
				isAdded = true;
			}
			else {
				throw new CannotRegisterEmployeeException("Cannot add Employee to the database");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isAdded;
	}

	/**
	 * This Method calculates the number of rows in the table
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	@Override
	public int tableSize() throws ClassNotFoundException, SQLException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "select count(*) from employee_data";

			pst = connection.prepareStatement(str);
			rs = pst.executeQuery();

			rs.next();
			count = rs.getInt(1);
		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}

		return count;
	}

	/**
	 * This Method returns a Map of mobile number and employee's last name of all
	 * the employees in the table. This map is used for the purpose of checking
	 * whether an employee is already registered or not
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	@Override
	public Map<Long, Employee> isEmployeeNotAvailableInDAO() throws ClassNotFoundException, SQLException {
		
		
		Connection connection = null;
		Map<Long, Employee> existingEmployeeCheck = new HashMap<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			existingEmployeeCheck = new HashMap<>();

			String str = IS_EMPLOYEE_AVAILABLE_QUERY;
			pst = connection.prepareStatement(str);
			rs = pst.executeQuery();

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setLastName(rs.getString(LAST_NAME));
				employee.setMobileNumber(rs.getLong(MOBILE_NUMBER));
				employee.setActiveStatus(rs.getInt(ACTIVE_STATUS));
				employee.setEmployeeID(rs.getString(EMPLOYEE_ID));
				
				existingEmployeeCheck.put(employee.getMobileNumber(), employee);
				
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
		}

		finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		
		return existingEmployeeCheck;

	}

	/**
	 * This Method returns a HashMap of employeeId and their corressponding employee
	 * Name for the purpose of displaying to the admin.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public List<Employee> displayAllEmployees() throws ClassNotFoundException, SQLException {
		
		List<Employee> allEmployeeDataToDisplay = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst1 = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();

			String str = DISPLAY_ALL_EMPLOYEES_QUERY;
			pst1 = connection.prepareStatement(str);
			rs = pst1.executeQuery();

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setName(rs.getString(FIRST_NAME));
				employee.setEmployeeID(rs.getString(EMPLOYEE_ID));
				allEmployeeDataToDisplay.add(employee);
				}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst1, connection);
		}
	
		return allEmployeeDataToDisplay;
	}
	
	/**
	 * This method gives a map of individual employee data of a particular employee in the database.
	 * @param employeeId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public List<Employee> displayDetailOfAnIndividualEmployee(String employeeId) throws ClassNotFoundException, SQLException {
		List<Employee> allEmployeeDataToDisplay = new ArrayList<>(); 
		
		Employee employee = new Employee();
		Connection connection = ConnectionUtil.getConnection();
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String str = DISPLAY_INDIVIDUAL_EMPLOYEES_DATA_QUERY;
			pst = connection.prepareStatement(str);	
			pst.setString(1, employeeId);
			rs = pst.executeQuery();
			while(rs.next()) {
				employee.setFirstName(rs.getString(FIRST_NAME));
				employee.setName(rs.getString(NAME));
				employee.setEmployeeID(rs.getString(EMPLOYEE_ID));
				employee.setMobileNumber(rs.getLong(MOBILE_NUMBER));
				employee.setEmail(rs.getString(EMPLOYEE_EMAIL_ID));
				employee.setGender(rs.getString(GENDER));
				employee.setRole(rs.getString(ROLE));
				employee.setDob(LocalDate.parse(rs.getString(DOB)));
				employee.setJoiningDate(LocalDate.parse(rs.getString(JOINED_DATE)));
				
				allEmployeeDataToDisplay.add(employee);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return allEmployeeDataToDisplay;
	}

	/**
	 * This method is used to make an employee inactive thereby not getting displayed in the screen in the list of employees.
	 * @param employeeId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public boolean deleteEmployeeFromTable(String employeeId) throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		PreparedStatement pst = null;
		
		boolean isDeleted = false;
		try {
			connection = ConnectionUtil.getConnection();

			String str = DELETE_EMPLOYEE_QUERY;
			pst = connection.prepareStatement(str);
			pst.setString(1, employeeId);
			int rs = pst.executeUpdate();
			if(rs==1) {
				isDeleted = true;
			}
			else {
				isDeleted = false;
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDeleted;
		
	}	
	
	@Override
	public boolean activateDeletedEmployee(String employeeIdToActivate) throws ClassNotFoundException, SQLException, CannotActivateEmployeeException {
		
		
			Connection connection = null;
			PreparedStatement pst = null;
			boolean isActivated = false;
			
			try {
				connection = ConnectionUtil.getConnection();
				
				String str = SET_EMPLOYEE_ACTIVE_QUERY;
				pst = connection.prepareStatement(str);
				pst.setString(1, employeeIdToActivate);
				int rs = pst.executeUpdate();
				if(rs==1) {
					isActivated = true;
				}
				else {
					throw new CannotActivateEmployeeException("Cannot Activate Employee");
				}
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		
			finally {
				ConnectionUtil.close(pst, connection);
			}
			return isActivated;
	}
	


}
