package com.tcs.tool.dao;

import java.util.List;

import javax.validation.Valid;

import com.tcs.tool.model.Account;
import com.tcs.tool.model.Employee;

public interface AccountDao {

	List<Account> findAllAccount();

	Account addAccount(Account account);

	Account editAccount(@Valid Account account);

	List<Employee> findAccountManager(long accId);

	void deleteAccount(@Valid Account account);

}