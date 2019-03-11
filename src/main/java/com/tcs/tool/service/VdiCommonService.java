package com.tcs.tool.service;

import java.util.List;

import javax.validation.Valid;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Project;
import com.tcs.tool.model.Users;

public interface VdiCommonService {

	List<Account> findAllAccount();

	Account addAccount(Account account);

	Users getUserByCredential(@Valid EmployeeRequest employeeRequest) throws ResourceNotFoundException;

	Users addUser(@Valid Users user);
	
	List<Project> getAllProjects();
	
	Project addProject(Project project);
	
	Project editProject(Project project);
	
	void deleteProject(Project project);

	Project findById(Long projectId) throws ResourceNotFoundException;
}
