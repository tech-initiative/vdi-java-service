package com.tcs.tool.service;

import java.util.List;

import javax.validation.Valid;

import com.tcs.tool.angular.model.EmployeeAddRequest;
import com.tcs.tool.angular.model.EmployeeLoginRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Employee;

public interface EmployeeService {

	Employee getUserByCredential(@Valid EmployeeLoginRequest employeeRequest) throws ResourceNotFoundException;

	Employee addUser(@Valid EmployeeAddRequest employeeAddRequest);

	List<Employee> findByUserEmail(String employeeEmail);

	List<Employee> findByUserLocation(String locationId);

	Employee findByEmployeeId(long employeeId) throws ResourceNotFoundException;

	Employee editUser(@Valid Employee user);

	void deleteUser(@Valid Employee user);

	List<Employee> findAllUsers();
}
