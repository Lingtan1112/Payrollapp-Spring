package in.lingtan.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.lingtan.model.Employee;

@Repository

public interface EmployeeRepository extends CrudRepository<Employee, String>{
//public interface EmployeeRepository extends JpaRepository<Employee, String>{

	@Query(value="SELECT * FROM employee_data where active_status=:active_status")
	Iterable<Employee> findByActiveStatus(@Param(value = "active_status") int activeStatus);
	
	boolean existsByMobileNumber(@Param(value="mobile_number") long mobileNumber);
	
		
	@Query(value="SELECT last_name FROM employee_data")
	List<Employee> checkForExistingEmployee();
	
	
	
}