package com.tcs.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.tool.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	@Query("From Employee u where u.tcsEmployeeId= ?1 and u.password= ?2 and u.isAdmin= ?3")
	Employee findByEmployeeCredential(String tcsEmployeeId, String password, boolean isAdmin);

}
