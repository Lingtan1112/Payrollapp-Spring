package in.lingtan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.lingtan.model.PayRoll;
import in.lingtan.service.PayRollService;


@RestController
@RequestMapping("payroll/v1")
public class PayrollController {

	@Autowired
	private PayRollService payRollService;

	@GetMapping("GetPaySlip")
	public List<Object> getPaySlip(@RequestParam("employeeId") String employeeId) {
		List<Object> payRollDataForEmployee = payRollService.getPaySlip(employeeId);
		return payRollDataForEmployee;
	}

	@GetMapping("GetRoles")
	public Iterable<PayRoll> getPayRoles() {
		return payRollService.getRoles();
	}

	@GetMapping("GetPayDataToDisplay")
	public Optional<PayRoll> getPayDataToDisplay(@RequestParam("id") int id) {
		Optional<PayRoll> payRollData = payRollService.getPayRollDataForRole(id);
		return payRollData;
	}

	@PostMapping("AddRole")
	public boolean addRole(@RequestParam String role) throws Exception {
		return payRollService.addRole(role);
	}

}
