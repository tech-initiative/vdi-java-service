package com.tcs.tool.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.dao.EmployeeDao;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee getUserByCredential(EmployeeRequest employeeRequest) throws ResourceNotFoundException {
		return employeeDao.findUserByCredential(employeeRequest);
	}

	@Override
	public Employee addUser(@Valid Employee user) {
		return employeeDao.addUser(user);
	}

	@Override
	public List<Employee> findByUserEmail(String employeeEmail) {
		return employeeDao.findByUserEmail(employeeEmail);
	}

	@Override
	public List<Employee> findByUserLocation(String locationId) {
		return employeeDao.findByUserLocation(locationId);
	}

	@Override
	public Employee findByEmployeeId(long employeeId) throws ResourceNotFoundException {
		return employeeDao.findByEmployeeId(employeeId);
	}

	@Override
	public Employee editUser(@Valid Employee user) {
		return employeeDao.editUser(user);
	}

	@Override
	public void deleteUser(@Valid Employee user) {
		employeeDao.deleteUser(user);
	}
}
