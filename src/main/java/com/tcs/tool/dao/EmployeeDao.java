package com.tcs.tool.dao;

import java.util.List;

import javax.validation.Valid;

import com.tcs.tool.angular.model.EmployeeLoginRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Employee;

public interface EmployeeDao {

	Employee findUserByCredential(EmployeeLoginRequest employeeRequest) throws ResourceNotFoundException;

	Employee addUser(Employee user);

	List<Employee> findByUserEmail(String employeeEmail);

	List<Employee> findByUserLocation(String locationId);

	Employee findByEmployeeId(long employeeId) throws ResourceNotFoundException;

	Employee editUser(@Valid Employee user);

	void deleteUser(@Valid Employee user);

	void insertAccontMangerRole(String accountId, long tcsEmployeeId);

	void insertProjectMangerRole(String projectId, long tcsEmployeeId);

}