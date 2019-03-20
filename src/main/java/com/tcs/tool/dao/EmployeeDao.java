package com.tcs.tool.dao;

import java.util.List;

import javax.validation.Valid;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Employee;

public interface EmployeeDao {

	Employee findUserByCredential(EmployeeRequest employeeRequest) throws ResourceNotFoundException;

	Employee addUser(Employee user);

	List<Employee> findByUserEmail(String employeeEmail);

	List<Employee> findByUserLocation(String locationId);

	List<Employee> findByEmployeeId(String employeeId);

	Employee editUser(@Valid Employee user);

	void deleteUser(@Valid Employee user);

}