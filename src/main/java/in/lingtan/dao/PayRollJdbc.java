package in.lingtan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.lingtan.model.Employee;
import in.lingtan.model.PayRoll;

@Repository
public class PayRollJdbc {
	private static final String BASIC_PAY = "basic_pay";
	private static final String HRA = "hra";
	private static final String FOOD_ALLOWANCE = "food_allowance";
	private static final String TRAVEL_ALLOWANCE = "travel_allowance";
	private static final String MEDICAL_ALLOWANCE = "medical_allowance";
	private static final String PF = "pf";
	private static final String ROLE = "role";
	private static final String PF_PERCENTAGE = "pf_percentage";
	private static final String SALARY = "salary";
	private static final String CTC = "ctc";
	private static final String ANNUAL_BASIC_PAY = "annual_basic_pay";
	private static final String ANNUAL_HRA = "annual_hra";
	private static final String ANNUAL_FOOD_ALLOWANCE = "annual_food_allowance";
	private static final String ANNUAL_MEDICAL_ALLOWANCE = "annual_medical_allowance";
	private static final String ANNUAL_PF = "annual_pf";
	private static final String ANNUAL_TRAVEL_ALLOWANCE = "annual_travel_allowance";
	private static final String ANNUAL_SALARY = "annual_salary";
	private static final String ANNUAL_CTC = "annual_ctc";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Object> getPaySilp(String employeeId) {

		String sql = "select* from employee_payslip where employee_id=?";

		Object[] params = { employeeId};

		return jdbcTemplate.query(sql, (rs, rowNo) -> {
			return mapResultSet(rs);
		}, params);

	}

	private List<PayRoll> mapResultSet(ResultSet rs) throws SQLException {

		List<PayRoll> payRollDataForAnEmployee = new ArrayList<>();
		PayRoll payRoll = new PayRoll();
		Employee employee = new Employee();
		employee.setName(rs.getString("name"));
		employee.setMobileNumber(rs.getLong("mobile_number"));
		employee.setEmployeeID(rs.getString("employee_id"));
		employee.setRole(rs.getString("role"));

		payRoll.setEmployee(employee);
		payRoll.setBasicPay(rs.getInt(BASIC_PAY));
		payRoll.setHraAllowance(rs.getInt(HRA));
		payRoll.setFoodAllowance(rs.getInt(FOOD_ALLOWANCE));
		payRoll.setMedicalAllowance(rs.getInt(MEDICAL_ALLOWANCE));
		payRoll.setPfAllowance(rs.getInt(PF));
		payRoll.setTravelAllowance(rs.getInt(TRAVEL_ALLOWANCE));
		payRoll.setAnnualBasicPay(rs.getInt(ANNUAL_BASIC_PAY));
		payRoll.setAnnualHraAllowance(rs.getInt(ANNUAL_HRA));
		payRoll.setAnnualFoodAllowance(rs.getInt(ANNUAL_FOOD_ALLOWANCE));
		payRoll.setAnnualMedicalAllowance(rs.getInt(ANNUAL_MEDICAL_ALLOWANCE));
		payRoll.setAnnualPfAllowance(rs.getInt(ANNUAL_PF));
		payRoll.setAnnualTravelAllowance(rs.getInt(ANNUAL_TRAVEL_ALLOWANCE));
		payRoll.setAnnualSalary(rs.getInt(ANNUAL_SALARY));
		payRoll.setAnnualCtc(rs.getInt(ANNUAL_CTC));

		payRoll.setSalary(rs.getInt(SALARY));
		payRoll.setCtc(rs.getInt(CTC));

		payRollDataForAnEmployee.add(payRoll);
		return payRollDataForAnEmployee;
	}


}
