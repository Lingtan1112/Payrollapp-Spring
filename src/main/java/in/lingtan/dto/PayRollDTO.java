package in.lingtan.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@Component
public class PayRollDTO {

	private Long id;
	private int basicPay;
	private int ctc;
	private int pfPercentage;
	private int salary;
	private String role;
	private int pfAllowance ;
	private int medicalAllowance;
	private int travelAllowance;
	private int hraAllowance;
	private int foodAllowance;
	private int annualPfPercentage;
	private int annualSalary;
	private int annualCtc;
	private int annualPfAllowance ;
	private int annualMedicalAllowance ;
	private int annualTravelAllowance ;
	private int annualHraAllowance ;
	private int annualFoodAllowance ;
}
