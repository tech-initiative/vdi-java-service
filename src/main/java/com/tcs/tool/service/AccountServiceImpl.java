package com.tcs.tool.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.tool.dao.AccountDao;
import com.tcs.tool.model.Account;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDao accountDao;
	
	@Override
	public List<Account> findAllAccount() {
		return accountDao.findAllAccount();
	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.addAccount(account);
	}

	@Override
	public Account editAccount(@Valid Account account) {
		return accountDao.editAccount(account);
	}
}
