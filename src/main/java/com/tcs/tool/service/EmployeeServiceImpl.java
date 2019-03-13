package com.tcs.tool.service;

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
	EmployeeDao vdiCommonDao;
	
	@Override
	public Employee getUserByCredential(EmployeeRequest employeeRequest) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return vdiCommonDao.findUserByCredential(employeeRequest);
	}

	@Override
	public Employee addUser(@Valid Employee user) {
		// TODO Auto-generated method stub
		return vdiCommonDao.addUser(user);
	}

	
	@Override
	public Employee findByUserId(String employeeId) throws ResourceNotFoundException {
		return vdiCommonDao.findByUserId(employeeId);
	}
}
