package in.lingtan.dao.impl;





import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.lingtan.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{
	Iterable<Employee> findByActiveStatus(@Param(value = "active_status") int activeStatus);
	
	
}