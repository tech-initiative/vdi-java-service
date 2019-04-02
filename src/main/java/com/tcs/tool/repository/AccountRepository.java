package com.tcs.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcs.tool.model.Account;
import com.tcs.tool.model.Employee;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query(value="select * From EMPLOYEE e join USER_ROLE_MAPPING  m on e.tcs_employee_id=m.user_id where m.role_id = 1 and m.account_id = ?1", nativeQuery=true)
	List<Employee> findAccountManager(long accId);

}
