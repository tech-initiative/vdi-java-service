package com.tcs.tool.dao;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Employee;
import com.tcs.tool.repository.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository userRepository;

	@Override
	public Employee findUserByCredential(EmployeeRequest employeeRequest) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Employee findByEmployeeCredential = userRepository.findByEmployeeCredential(employeeRequest.getEmployeeId(),
				employeeRequest.getPassword(), employeeRequest.getIsAdmin());

		return Optional.ofNullable(findByEmployeeCredential)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credential"));
	}

	@Override
	public Employee addUser(@Valid Employee user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Employee findByUserId(String employeeId) throws ResourceNotFoundException {
		return userRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	}

}
