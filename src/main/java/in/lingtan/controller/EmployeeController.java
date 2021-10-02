package in.lingtan.controller;

import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.lingtan.dao.EmployeeRepository;
import in.lingtan.dto.EmployeeDTO;
import in.lingtan.exceptions.EmployeeInactiveException;
import in.lingtan.exceptions.EmployeeNotFoundException;
import in.lingtan.exceptions.ExistingEmployeeException;
import in.lingtan.exceptions.InvalidEmployeeIdException;
import in.lingtan.exceptions.InvalidEmployeeIdFormatException;
import in.lingtan.model.Employee;
import in.lingtan.service.EmployeeService;
import io.swagger.annotations.Api;

@Api
@CrossOrigin
@RestController
@Controller
@RequestMapping("employee/v1")
public class EmployeeController{
	
	@Autowired 
	private EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("RegisterEmployee")
	@ResponseBody
	public Employee registerEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws ExistingEmployeeException, InvalidEmployeeIdException, InvalidEmployeeIdFormatException{		
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		employeeService.addEmployee(employee);	
		return employee;
	}
	
	@GetMapping("/GetEmployeeList")
	public List<EmployeeDTO> getEmployeeList() {
		return employeeService.displayAllEmployees();
	}
	
	@GetMapping("GetEmployeeData")
	public List<EmployeeDTO> getEmployeeData(@RequestParam("employeeID") String employeeID) throws EmployeeNotFoundException {
		return employeeService.displayIndividualEmployeeData(employeeID);
	}
		
	@GetMapping("DeleteEmployeeId")
	public boolean deleteEmployeeId(@RequestParam("employeeID") String employeeID) throws EmployeeInactiveException, EmployeeNotFoundException, InvalidEmployeeIdException   {
		return employeeService.deleteEmployeeFromTheDataBase(employeeID);
	}	
	
	@PutMapping("ActivateEmployee")
	public boolean activateEmployee(@RequestParam("employeeID") String employeeID, @RequestParam(required=false,name="views") Employee employee) throws Exception {
		return employeeService.activateDeletedEmployee(employeeID);
	}
		
	
}