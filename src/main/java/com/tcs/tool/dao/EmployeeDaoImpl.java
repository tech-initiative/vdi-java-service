package com.tcs.tool.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Employee;
import com.tcs.tool.model.Users;
import com.tcs.tool.repository.AccountRepository;
import com.tcs.tool.repository.EmployeeRepository;
import com.tcs.tool.repository.UserRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public Users findUserByCredential(EmployeeRequest employeeRequest) {
		// TODO Auto-generated method stub
		return userRepository.findByEmployeeCredential(employeeRequest.getEmployeeId(), employeeRequest.getPassword(),
				employeeRequest.getIsAdmin());
	}

	@Override
	public Users addUser(@Valid Users user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
