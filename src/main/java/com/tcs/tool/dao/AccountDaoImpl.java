package com.tcs.tool.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.tool.model.Account;
import com.tcs.tool.model.Employee;
import com.tcs.tool.repository.AccountRepository;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> findAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account editAccount(@Valid Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Employee> findAccountManager(long accId) {
		return accountRepository.findAccountManager(accId);
	}
}
