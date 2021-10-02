package in.lingtan.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.lingtan.dto.PayRollDTO;
import in.lingtan.service.PayRollService;

@RestController
@Controller
public class PayRollController {
	
	@Autowired
	private PayRollService payRollService;
	
	@GetMapping("Hello")
	public String hello() {
		return "hello world";
	}
	
	@GetMapping("GetEmployeePaySlip")
	public List<PayRollDTO> getPayRollData(@RequestParam("employeeId") String employeeId) throws ClassNotFoundException, SQLException{
		System.out.println("EmployeeID--"+employeeId);
		return payRollService.getPayRollDataForEmployee(employeeId);
	}
	@GetMapping("Get")
	public List<PayRollDTO> getAllPayRollData(@RequestParam("role") String role) throws ClassNotFoundException, SQLException{
		System.out.println("Role--"+role);
		return payRollService.getPayRoleData(role);
	}
	
	@GetMapping("GetValue")
	public String get() {
		return payRollService.test();
	}

}
