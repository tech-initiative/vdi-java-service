package com.tcs.tool.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.tool.angular.model.EmployeeAddRequest;
import com.tcs.tool.angular.model.EmployeeLoginRequest;
import com.tcs.tool.dao.EmployeeDao;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee getUserByCredential(EmployeeLoginRequest employeeRequest) throws ResourceNotFoundException {
		return employeeDao.findUserByCredential(employeeRequest);
	}

	@Override
	public Employee addUser(@Valid EmployeeAddRequest employeeAddRequest) {
		Employee addUser = employeeDao.addUser(employeeAddRequest.getEmployee());

		if(employeeAddRequest.getIsAccountManager() == true){
			for (String accountId : employeeAddRequest.getAccountIdList()) {
				employeeDao.insertAccontMangerRole(accountId, employeeAddRequest.getEmployee().getTcsEmployeeId());
			}
		}
		
		if(employeeAddRequest.getIsProjectManager() == true){
			for (String projectId : employeeAddRequest.getProjectIdList()) {
				employeeDao.insertProjectMangerRole(projectId, employeeAddRequest.getEmployee().getTcsEmployeeId());
			}
		}
		return addUser;
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
