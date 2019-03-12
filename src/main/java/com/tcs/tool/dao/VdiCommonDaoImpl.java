package com.tcs.tool.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Project;
import com.tcs.tool.model.Users;
import com.tcs.tool.repository.AccountRepository;
import com.tcs.tool.repository.ProjectRepository;
import com.tcs.tool.repository.UserRepository;

@Repository
public class VdiCommonDaoImpl implements VdiCommonDao {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;

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

	@Override
	public Users findUserByCredential(EmployeeRequest employeeRequest) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Users findByEmployeeCredential = userRepository.findByEmployeeCredential(employeeRequest.getEmployeeId(), employeeRequest.getPassword(),
				employeeRequest.getIsAdmin());
		
		return Optional.ofNullable(findByEmployeeCredential).orElseThrow(() ->new ResourceNotFoundException("Invalid credential"));
	}

	@Override
	public Users addUser(@Valid Users user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Project addProject(@Valid Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project editProject(@Valid Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void deleteProject(@Valid Project project) {
		projectRepository.delete(project);
	}

	@Override
	public List<Project> findAllProject() {
		return projectRepository.findAll();
	}

	/*@Override
	public Optional<Project> findById(Long Id) {
		return projectRepository.findById(Id);
	}*/

	@Override
	public Project findByProjectId(Long projectId) throws ResourceNotFoundException {
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + projectId));
	//	 projectRepository.findById(projectId);
		return project;
	}

	@Override
	public Users findByUserId(String employeeId) throws ResourceNotFoundException {
		return userRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	}

}
