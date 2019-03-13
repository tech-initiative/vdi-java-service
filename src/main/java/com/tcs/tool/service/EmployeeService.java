package com.tcs.tool.service;

import javax.validation.Valid;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Employee;

public interface EmployeeService {

	Employee getUserByCredential(@Valid EmployeeRequest employeeRequest) throws ResourceNotFoundException;

	Employee addUser(@Valid Employee user);

	Employee findByUserId(String employeeId) throws ResourceNotFoundException;
}
