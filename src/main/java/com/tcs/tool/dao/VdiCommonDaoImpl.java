package com.tcs.tool.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Users;
import com.tcs.tool.repository.AccountRepository;
import com.tcs.tool.repository.UserRepository;

@Repository
public class VdiCommonDaoImpl implements VdiCommonDao {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

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
	public Users findUserByCredential(EmployeeRequest employeeRequest) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Users findByEmployeeCredential = userRepository.findByEmployeeCredential(employeeRequest.getEmployeeId(), employeeRequest.getPassword(),
				employeeRequest.getIsAdmin());
		
		return Optional.ofNullable(findByEmployeeCredential).orElseThrow(() ->new ResourceNotFoundException("Invalid credential"));
	}

	@Override
	public Users addUser(@Valid Users user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
