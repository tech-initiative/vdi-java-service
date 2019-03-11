package com.tcs.tool.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.dao.VdiCommonDao;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Project;
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

	@Override
	public Project addProject(Project project) {
		return employeeDao.addProject(project);
	}

	@Override
	public List<Project> getAllProjects() {
		return employeeDao.findAllProject();
	}

	@Override
	public Project editProject(Project project) {
		return employeeDao.editProject(project);
	}

	@Override
	public void deleteProject(Project project) {
		 employeeDao.deleteProject(project);
	}

	@Override
	public Project findById(Long projectId) throws ResourceNotFoundException {
		return employeeDao.findById(projectId);
	}

}
