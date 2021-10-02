package in.lingtan.dao;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.lingtan.model.PayRoll;

@Repository
public interface PayRollRepository extends CrudRepository<PayRoll, Integer>{

	@Query("select id,role,created_date from roles")
	public Iterable<PayRoll> getRoles();

	@Modifying
	@Query("insert into roles (role) values (:role)")
	int addRole(@Param(value = "role") String role);

	@Query("select * from payroll_data where role_id=:role_id")
	public Optional<PayRoll> findByRole(@Param("role_id") int id);

}
