package com.tcs.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcs.tool.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("FROM Employee E WHERE E.id > ?1")
	public List<Employee> getEmployeeUsingQuery(Long employeeId);
}
