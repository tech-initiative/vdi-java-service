package com.tcs.tool.service;

import java.util.List;

import com.tcs.tool.model.Account;

public interface AccountService {

	List<Account> findAllAccount();

	Account addAccount(Account account);

}
