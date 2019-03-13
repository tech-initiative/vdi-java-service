package com.tcs.tool.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.tool.model.Account;
import com.tcs.tool.repository.AccountRepository;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private AccountRepository accountRepository;

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
}
