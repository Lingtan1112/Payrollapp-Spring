package in.lingtan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.lingtan.dao.PayRollJdbc;
import in.lingtan.dao.PayRollRepository;
import in.lingtan.model.PayRoll;


@RestController
@RequestMapping("payroll/v1")
public class PayrollController {

	//	@Autowired
	//	private PayRollService payrollService;
	//
	@Autowired
	private PayRollRepository payRollRepository;

	@Autowired
	private PayRoll payroll;

	@Autowired
	private PayRollJdbc payRollJdbc;

	@GetMapping("GetPaySlip")
	public List<Object> getPaySlip(@RequestParam("employeeId") String employeeId) {

		List<Object> payRollDataForEmployee = payRollJdbc.getPaySilp(employeeId);
		// Optional<PayRoll> payRollDataForEmployee =
		// payRollRepository.payRollData(employeeId);
		// System.out.println(payRollDataForEmployee);
		// return payRollDataForEmployee;
		return payRollDataForEmployee;

	}

}
