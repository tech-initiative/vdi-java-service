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
	VdiCommonDao vdiCommonDao;
	
	@Override
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return vdiCommonDao.findAllAccount();
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return vdiCommonDao.addAccount(account);
	}

	@Override
	public Users getUserByCredential(EmployeeRequest employeeRequest) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return vdiCommonDao.findUserByCredential(employeeRequest);
	}

	@Override
	public Users addUser(@Valid Users user) {
		// TODO Auto-generated method stub
		return vdiCommonDao.addUser(user);
	}

	@Override
	public Project addProject(Project project) {
		return vdiCommonDao.addProject(project);
	}

	@Override
	public List<Project> getAllProjects() {
		return vdiCommonDao.findAllProject();
	}

	@Override
	public Project editProject(Project project) {
		return vdiCommonDao.editProject(project);
	}

	@Override
	public void deleteProject(Project project) {
		 vdiCommonDao.deleteProject(project);
	}

	@Override
	public Project findByProjectId(Long projectId) throws ResourceNotFoundException {
		return vdiCommonDao.findByProjectId(projectId);
	}

	@Override
	public Users findByUserId(String employeeId) throws ResourceNotFoundException {
		return vdiCommonDao.findByUserId(employeeId);
	}

}
