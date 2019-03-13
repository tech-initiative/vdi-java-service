package com.tcs.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.tool.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	@Query("From Employee u where u.tcsEmployeeId= ?1 and u.password= ?2 and u.isAdmin= ?3")
	Employee findByEmployeeCredential(String tcsEmployeeId, String password, boolean isAdmin);

	@Query("From Employee u where u.email = ?1")
	List<Employee> findByUserEmail(String employeeEmail);

	@Query("From Employee u where u.locationId = ?1")
	List<Employee> findByUserLocation(String locationId);

	@Query("From Employee u where u.tcsEmployeeId = ?1")
	List<Employee> findByEmployeeId(String employeeId);

}
