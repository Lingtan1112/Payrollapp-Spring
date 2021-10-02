package in.lingtan.controller;



import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.lingtan.dao.EmployeeRepository;
import in.lingtan.model.Employee;
import in.lingtan.model.EmployeeError;
import in.lingtan.service.EmployeeService;


@RestController
@Controller
public class EmployeeController{
	
	@Autowired 
	private EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@PostMapping("RegisterEmployee")
	@ResponseBody
	public Employee registerEmployee(@Valid @RequestBody Employee employee, EmployeeError employeeError) throws Exception{
		employeeService.addEmployee(employee);		
		return employee;
	}
	
	@GetMapping("GetEmployeeList")
	public Iterable<Employee> getEmployeeList() {
		return employeeService.displayAllEmployees();
	
	}
	
	@GetMapping("GetEmployeeData")
	public Optional<Employee> getEmployeeData(@RequestParam("employeeID") String employeeID) {
		System.out.println(employeeID);
		return employeeService.displayIndividualEmployeeData(employeeID);
	}
	
	@PutMapping("DeleteEmployeeId")
	public void deleteEmployeeId(@RequestParam("employeeID") String employeeID) {
		try {
			employeeService.deleteEmployeeFromTheDataBase(employeeID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@PutMapping("ActivateEmployee")
	
	public boolean activateEmployee( @RequestParam("employeeID") String employeeID, @RequestParam(required=false,name="views") Employee employee) throws Exception {
		System.out.println("Hello");
		return employeeService.activateDeletedEmployee(employeeID);
		
	}
		
	
}