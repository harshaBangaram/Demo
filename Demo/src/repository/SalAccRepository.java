package repository;



import org.springframework.data.repository.CrudRepository;

import entity.SalaryAccount;

public interface SalAccRepository extends CrudRepository<SalaryAccount, Long> {

}