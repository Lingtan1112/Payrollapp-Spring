package in.lingtan.dao.impl;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import in.lingtan.model.Employee;

public interface EmployeeServiceDAOImpl {

	Optional<Employee> findByEmployeeID(String employeeID);

	int deleteByEmployeeID(String employeeID);

}