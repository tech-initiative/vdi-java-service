package com.tcs.tool.service;

import java.util.List;

import javax.validation.Valid;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Users;

public interface VdiCommonService {

	List<Account> findAllAccount();

	Account addAccount(Account account);

	Users getUserByCredential(@Valid EmployeeRequest employeeRequest);

	Users addUser(@Valid Users user);
}
