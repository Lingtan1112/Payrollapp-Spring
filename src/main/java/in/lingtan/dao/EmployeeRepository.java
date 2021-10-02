package in.lingtan.dao;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.lingtan.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	@Query("select * from employee_list_view")
	Iterable<Employee> findByActiveStatus();

	@Query(value="SELECT last_name,mobile_number,employee_id,active_status FROM employee_data")
	Iterable<Employee> checkForExistingEmployee();

	@Query(value="select s_no,first_name,name,employee_id,mobile_number,email_id,gender,role,dob,joined_date from employee_data where employee_id=:employee_id")
	Optional<Employee> getEmployeeData(@Param(value = "employee_id") String employeeID);

	@Query("select s_no from employee_data where employee_id=:employee_id")
	int getIdOfEmployee(@Param(value = "employee_id") String employeeID);

}
