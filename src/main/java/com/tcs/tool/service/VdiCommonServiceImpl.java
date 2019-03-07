package com.tcs.tool.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.dao.VdiCommonDao;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Users;

@Service
public class VdiCommonServiceImpl implements VdiCommonService {

	@Autowired
	VdiCommonDao employeeDao;
	
	@Override
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return employeeDao.findAllAccount();
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return employeeDao.addAccount(account);
	}

	@Override
	public Users getUserByCredential(EmployeeRequest employeeRequest) {
		// TODO Auto-generated method stub
		return employeeDao.findUserByCredential(employeeRequest);
	}

	@Override
	public Users addUser(@Valid Users user) {
		// TODO Auto-generated method stub
		return employeeDao.addUser(user);
	}

}
