package com.tcs.tool.dao;

import java.util.List;

import javax.validation.Valid;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Project;
import com.tcs.tool.model.Users;

public interface VdiCommonDao {
	List<Account> findAllAccount();
	Account addAccount(Account account);
	Users findUserByCredential(EmployeeRequest employeeRequest) throws ResourceNotFoundException;
	Users addUser(@Valid Users user);
	Project addProject(@Valid Project project);
	Project editProject(@Valid Project project);
	void deleteProject(@Valid Project project);
	List<Project> findAllProject();
	Project findByProjectId(Long projectId) throws ResourceNotFoundException;
	Users findByUserId(long employeeId) throws ResourceNotFoundException;
}
