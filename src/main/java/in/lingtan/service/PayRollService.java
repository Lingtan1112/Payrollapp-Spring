package in.lingtan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import in.lingtan.dao.PayRollJdbc;
import in.lingtan.dao.PayRollRepository;
import in.lingtan.dto.PayRollDTO;
import in.lingtan.model.PayRoll;

@Service
public class PayRollService {

	@Autowired
	private PayRoll payRoll;
	@Autowired
	private PayRollRepository payRollRepository;
	@Autowired
	private PayRollJdbc payRollJdbc;

	//	/**
	//	 * This method gets the form values from the servlet and send those values to
	//	 * the DAO class to update in the database.
	//	 *
	//	 * @param payRollDTO
	//	 * @return
	//	 * @throws ClassNotFoundException
	//	 * @throws SQLException
	//	 */
	//	public boolean updatePayRollData(PayRollDTO payRollDTO) throws ClassNotFoundException, SQLException {
	//
	//		PayRollService payRollService = new PayRollService();
	//		int calculatedPf = payRollService.caluculatePf(payRollDTO);
	//		int calculatedSalary = payRollService.calculateSalary(payRollDTO);
	//		int calculatedCtc = payRollService.calculateCtc(payRollDTO);
	//
	//		payRoll.setRole(payRollDTO.getRole());
	//		payRoll.setBasicPay(payRollDTO.getBasicPay());
	//		payRoll.setHraAllowance(payRollDTO.getHraAllowance());
	//		payRoll.setFoodAllowance(payRollDTO.getFoodAllowance());
	//		payRoll.setPfAllowance(calculatedPf);
	//		payRoll.setPfPercentage(payRollDTO.getPfPercentage());
	//		payRoll.setTravelAllowance(payRollDTO.getTravelAllowance());
	//		payRoll.setMedicalAllowance(payRollDTO.getMedicalAllowance());
	//		payRoll.setSalary(calculatedSalary);
	//		payRoll.setCtc(calculatedCtc);
	//
	//		return payRollRepository.update(payRoll);
	//
	//	}
	//
	//	/**
	//	 * This Method gets an array of individual role's payroll data from the dao
	//	 * class.
	//	 *
	//	 * @param role
	//	 * @return
	//	 * @throws ClassNotFoundException
	//	 * @throws SQLException
	//	 */
	//	public List<PayRollDTO> getPayRoleData(String role) throws ClassNotFoundException, SQLException {
	//		PayRollDTO payRollDTO = new PayRollDTO();
	//
	//		List<PayRollDTO> payRollDataArrayForServlet = new ArrayList<>();
	//		List<PayRoll> payRollDataFromDAO = payRollRepository.get(role);
	//
	//		for (PayRoll payRollData : payRollDataFromDAO) {
	//			payRollDTO.setBasicPay(payRollData.getBasicPay());
	//			payRollDTO.setHraAllowance(payRollData.getHraAllowance());
	//			payRollDTO.setPfAllowance(payRollData.getPfAllowance());
	//			payRollDTO.setMedicalAllowance(payRollData.getMedicalAllowance());
	//			payRollDTO.setTravelAllowance(payRollData.getTravelAllowance());
	//			payRollDTO.setFoodAllowance(payRollData.getFoodAllowance());
	//			payRollDTO.setPfPercentage(payRollData.getPfPercentage());
	//			payRollDTO.setRole(payRollData.getRole());
	//			payRollDTO.setSalary(payRollData.getSalary());
	//			payRollDTO.setCtc(payRollData.getCtc());
	//
	//			payRollDataArrayForServlet.add(payRollDTO);
	//
	//		}
	//
	//		return payRollDataArrayForServlet;
	//	}
	//
	//	/**
	//	 * This method gets all the required payroll data from the database class for
	//	 * generating a payslip.
	//	 *
	//	 * @param role
	//	 * @return
	//	 * @throws ClassNotFoundException
	//	 * @throws SQLException
	//	 */
	//	public List<PayRoll> getPayRollDataForEmployee(String role) throws ClassNotFoundException, SQLException {
	//
	//		List<PayRoll> payRollDataForEmployeeToServlet = new ArrayList<>();
	//
	//		Employee employee = new Employee();
	//		PayRoll payRollDTO = new PayRoll();
	//		Optional<PayRoll> payRollDataForEmployee = payRollRepository.payRollData(role);
	//
	//		for (PayRoll payRollData : payRollDataForEmployee) {
	//
	//			employee.setName(payRollData.getEmployee().getName());
	//
	//			employee.setMobileNumber(payRollData.getEmployee().getMobileNumber());
	//			employee.setEmployeeID(payRollData.getEmployee().getEmployeeID());
	//			employee.setRole(payRollData.getEmployee().getRole());
	//
	//			payRollDTO.setEmployee(employee);
	//			payRollDTO.setBasicPay(payRollData.getBasicPay());
	//			payRollDTO.setHraAllowance(payRollData.getHraAllowance());
	//			payRollDTO.setPfAllowance(payRollData.getPfAllowance());
	//			payRollDTO.setMedicalAllowance(payRollData.getMedicalAllowance());
	//			payRollDTO.setTravelAllowance(payRollData.getTravelAllowance());
	//			payRollDTO.setFoodAllowance(payRollData.getFoodAllowance());
	//			payRollDTO.setSalary(payRollData.getSalary());
	//			payRollDTO.setCtc(payRollData.getCtc());
	//
	//			payRollDTO.setAnnualBasicPay(payRollData.getAnnualBasicPay());
	//			payRollDTO.setAnnualHraAllowance(payRollData.getAnnualHraAllowance());
	//			payRollDTO.setAnnualPfAllowance(payRollData.getAnnualPfAllowance());
	//			payRollDTO.setAnnualMedicalAllowance(payRollData.getAnnualMedicalAllowance());
	//			payRollDTO.setAnnualTravelAllowance(payRollData.getAnnualTravelAllowance());
	//			payRollDTO.setAnnualFoodAllowance(payRollData.getAnnualFoodAllowance());
	//
	//			payRollDTO.setAnnualSalary(payRollData.getAnnualSalary());
	//			payRollDTO.setAnnualCtc(payRollData.getAnnualCtc());
	//
	//			payRollDataForEmployeeToServlet.add(payRollDTO);
	//
	//		}
	//		return payRollDataForEmployeeToServlet;
	//	}
	/**
	 * This method calculates the pf amount from the basic pay using the alloted pf
	 * percentage.
	 *
	 * @param payRollDTO
	 * @return
	 */

	public Iterable<PayRoll> getRoles() {
		Iterable<PayRoll> roles = payRollRepository.getRoles();
		return roles;
	}

	public boolean addRole(String role) throws Exception {
		boolean isAdded = false;
		int result;
		try {
			result = payRollRepository.addRole(role);
			if (result == 1) {
				isAdded = true;
			}

		} catch (DuplicateKeyException e) {
			throw new DuplicateKeyException(role + " Already Exists");
		} catch (Exception e) {
			throw new Exception("Cannot add Role" + e.getMessage());
		}
		return isAdded;
	}

	public List<Object> getPaySlip(String employeeId) {
		return payRollJdbc.getPaySilp(employeeId);
	}


	public int caluculatePf(PayRollDTO payRollDTO) {

		payRollDTO.setPfAllowance((payRollDTO.getBasicPay() * payRollDTO.getPfPercentage()) / 100);

		return payRollDTO.getPfAllowance();
	}

	/**
	 * This method calculates the estimated gross compensation for a specified role.
	 *
	 * @param payRollDTO
	 * @return
	 */
	private int calculateSalary(PayRollDTO payRollDTO) {
		payRollDTO.setSalary((payRollDTO.getBasicPay() + payRollDTO.getHraAllowance() + payRollDTO.getMedicalAllowance()
		+ payRollDTO.getFoodAllowance() + payRollDTO.getTravelAllowance()) - payRollDTO.getPfAllowance());
		return payRollDTO.getSalary();
	}

	/**
	 * This method calculates the cost to company for a specified role.
	 *
	 * @param payRollDTO
	 * @return
	 */
	private int calculateCtc(PayRollDTO payRollDTO) {
		payRollDTO.setCtc((payRollDTO.getBasicPay() + payRollDTO.getHraAllowance() + payRollDTO.getMedicalAllowance()
		+ payRollDTO.getFoodAllowance() + payRollDTO.getTravelAllowance()));
		return payRollDTO.getCtc();
	}

	public Optional<PayRoll> getPayRollDataForRole(int id) {
		Optional<PayRoll> payRollData = payRollRepository.findByRole(id);
		return payRollData;
	}


}
