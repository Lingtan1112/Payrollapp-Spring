package in.lingtan.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.lingtan.dao.UserJdbc;
import in.lingtan.exceptions.CannotGetCredentialException;
import in.lingtan.exceptions.InvalidCredentialsException;
import in.lingtan.model.User;

@Service
public class UserService {

	private UserService() {

	}

	@Autowired
	private UserJdbc userJdbc;
	/**
	 * This method is used to validate the admin credentials that he is a valid
	 * admin or not
	 *
	 * @param adminUsername
	 * @param adminPassword
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws CannotGetCredentialException
	 * @throws InvalidCredentialsException
	 */

	//	public static boolean adminValidation(String adminUsername, String adminPassword) throws ClassNotFoundException, SQLException, CannotGetCredentialException  {
	//
	//		boolean isValidCredentials = false;
	//		Map<String, String> userCredetials = userJdbc.adminCredentialData();
	//		if (userCredetials.containsKey(adminUsername) && adminPassword.equals(userCredetials.get(adminUsername))) {
	//			isValidCredentials = true;
	//		}
	//		return isValidCredentials;
	//	}

	/**
	 * This method validates the employee username and password and returns true if credentials are valid else raises an exception.
	 * @param employeeId
	 * @param password
	 * @return
	 * @throws InvalidCredentialsException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws CannotGetCredentialException
	 */
	public boolean employeeLoginValidation(User user) {

		boolean isValidCredentials = false;

		List<User> userCredentials = userJdbc.getCredentialData();

		for (User userData : userCredentials) {
			if (userData.getUserName().equals(user.getUserName())
					&& userData.getPassword().equals(user.getPassword())) {

				isValidCredentials = true;
			}
		}
		return isValidCredentials;
	}

	/**
	 * This method compares the whether the employee Id is available and the user entered password matches
	 * the old password and if satisfies the data is sent to the dao class.
	 * @param employeeId
	 * @param newPassword
	 * @param oldPassword
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws CannotGetCredentialException
	 * @throws EmployeeNotFoundException
	 * @throws PasswordDoNotMatchWithOldPasswordException
	 * @throws CannotChangePasswordException
	 */
	//	public static boolean changePassword(String employeeId, String newPassword, String oldPassword) throws ClassNotFoundException, SQLException, CannotGetCredentialException, EmployeeNotFoundException, PasswordDoNotMatchWithOldPasswordException, CannotChangePasswordException {
	//		UserServiceDAO userServiceDAO = new UserServiceDAO();
	//		Map<String, String> employeeCredentials = userServiceDAO.employeeCredentialData();
	//
	//		if(employeeCredentials.containsKey(employeeId)) {
	//			if(oldPassword.equals(employeeCredentials.get(employeeId))){
	//				return userServiceDAO.changePassword(employeeId, newPassword);
	//			}else {
	//				throw new PasswordDoNotMatchWithOldPasswordException("Password Does not match with existing password");
	//			}
	//		}else {
	//			throw new EmployeeNotFoundException("User Not Found");
	//		}
	//
	//	}

}
