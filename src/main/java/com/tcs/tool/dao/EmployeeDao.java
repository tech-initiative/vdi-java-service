package com.tcs.tool.dao;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Employee;

public interface EmployeeDao {

	Employee findUserByCredential(EmployeeRequest employeeRequest) throws ResourceNotFoundException;

	Employee addUser(Employee user);

	Employee findByUserId(String employeeId) throws ResourceNotFoundException;

}