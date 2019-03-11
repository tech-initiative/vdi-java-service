package com.tcs.tool.dao;

import java.util.List;

import javax.validation.Valid;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Users;

public interface VdiCommonDao {
	List<Account> findAllAccount();
	Account addAccount(Account account);
	Users findUserByCredential(EmployeeRequest employeeRequest) throws ResourceNotFoundException;
	Users addUser(@Valid Users user);
	
}
