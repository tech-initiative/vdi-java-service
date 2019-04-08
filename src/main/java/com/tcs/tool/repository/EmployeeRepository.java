package com.tcs.tool.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tcs.tool.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("From Employee u where u.tcsEmployeeId= ?1 and u.password= ?2 and u.isAdmin= ?3")
	Employee findByEmployeeCredential(long tcsEmployeeId, String password, boolean isAdmin);

	@Query("From Employee u where u.email = ?1")
	List<Employee> findByUserEmail(String employeeEmail);

	@Query("From Employee u where u.locationId = ?1")
	List<Employee> findByUserLocation(String locationId);

	@Modifying
	@Transactional
	@Query(value="INSERT INTO USER_ROLE_MAPPING (USER_ID, ROLE_ID, ACCOUNT_ID) VALUES (?2, 1, ?1)", nativeQuery = true)
	void insertAccontMangerRole(long accountId, long tcsEmployeeId);

	@Modifying
	@Transactional
	@Query(value="INSERT INTO USER_ROLE_MAPPING (USER_ID, ROLE_ID, PROJECT_ID) VALUES (?2, 2, ?1)", nativeQuery = true)
	void insertProjectMangerRole(long projectId, long tcsEmployeeId);

	@Query(value="select e.* From EMPLOYEE e join USER_ROLE_MAPPING m on e.tcs_employee_id=m.user_id where m.role_id = 1 and m.account_id = ?1", nativeQuery=true)
	List<Employee> findAccountManager(long accId);
	
}
