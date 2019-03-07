package com.tcs.tool.dao;

import java.util.List;

import javax.validation.Valid;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Employee;
import com.tcs.tool.model.Users;

public interface EmployeeDao {
	List<Employee> findAllEmployee();
	List<Account> findAllAccount();
	Account addAccount(Account account);
	Users findUserByCredential(EmployeeRequest employeeRequest);
	Users addUser(@Valid Users user);
	
}
