package in.lingtan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.lingtan.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
