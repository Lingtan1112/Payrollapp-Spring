package in.lingtan.model;




import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@Table(value="payroll_data")
@JsonInclude(value = Include.NON_NULL)
public class PayRoll {

	@Column("role_id")
	private int roleId;

	@Column("id")
	private int id;

	@Column("created_date")
	private LocalDate createdDate;

	@Column("ctc")
	private int ctc;

	@Column("salary")
	private int salary;

	@Autowired
	private Employee employee;

	@Column("basic_pay")
	private int basicPay ;

	@Column("pf_percentage")
	private int pfPercentage;

	@Column("pf_allowance")
	private int pfAllowance ;

	@Column("medical_allowance")
	private int medicalAllowance ;

	@Column("travel_allowance")
	private int travelAllowance ;

	@Column("hra")
	private int hraAllowance ;

	@Column("food_allowance")
	private int foodAllowance ;

	@Column("role")
	private String role;

	private int annualBasicPay;
	private int annualPfPercentage;
	private int annualSalary;
	private int annualCtc;
	private int annualPfAllowance;
	private int annualMedicalAllowance;
	private int annualTravelAllowance;
	private int annualHraAllowance;
	private int annualFoodAllowance;
}
