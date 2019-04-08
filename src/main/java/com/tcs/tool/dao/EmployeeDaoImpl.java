package com.tcs.tool.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.tool.angular.model.EmployeeLoginRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Employee;
import com.tcs.tool.repository.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository userRepository;

	@Override
	public Employee findUserByCredential(EmployeeLoginRequest employeeRequest) throws ResourceNotFoundException {
		Employee findByEmployeeCredential = userRepository.findByEmployeeCredential(employeeRequest.getEmployeeId(),
				employeeRequest.getPassword(), employeeRequest.getIsAdmin());

		return Optional.ofNullable(findByEmployeeCredential)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credential"));
	}

	@Override
	public Employee addUser(@Valid Employee user) {
		return userRepository.save(user);
	}

	@Override
	public List<Employee> findByUserEmail(String employeeEmail) {
		return userRepository.findByUserEmail(employeeEmail);
	}

	@Override
	public List<Employee> findByUserLocation(String locationId) {
		return userRepository.findByUserLocation(locationId);
	}

	@Override
	public Employee findByEmployeeId(long employeeId) throws ResourceNotFoundException {
		return userRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Invalid credential"));
	}

	@Override
	public Employee editUser(@Valid Employee user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(@Valid Employee user) {
		userRepository.delete(user);;
	}

	@Override
	public void insertAccontMangerRole(String accountId, long tcsEmployeeId) {
		userRepository.insertAccontMangerRole(new Long(accountId), tcsEmployeeId);
	}

	@Override
	public void insertProjectMangerRole(String projectId, long tcsEmployeeId) {
		userRepository.insertProjectMangerRole(new Long(projectId), tcsEmployeeId);
	}

	@Override
	public List<Employee> findAllUser() {
		return userRepository.findAll();
	}


}
