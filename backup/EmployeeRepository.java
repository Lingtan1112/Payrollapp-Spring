package in.lingtan.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import in.lingtan.model.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	boolean deleteById(String employeeId);

	List<Employee> displayDetailOfAnIndividualEmployee(String employeeId);

	boolean activateDeletedEmployee(String employeeIdToActivate);

	Iterable<Employee> findById(String employeeId);
	
}


