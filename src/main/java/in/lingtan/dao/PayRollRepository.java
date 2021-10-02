package in.lingtan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.lingtan.model.PayRoll;

@Repository
public interface PayRollRepository extends CrudRepository<PayRoll, Integer>{

}
