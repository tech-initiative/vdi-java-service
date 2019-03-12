package com.tcs.tool.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Project;
import com.tcs.tool.model.Users;
import com.tcs.tool.service.VdiCommonService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ReportController {
	
	@Autowired
	private VdiCommonService employeeservice;
	
	@GetMapping("/accounts")
	public List<Account> listAccount() {
		return employeeservice.findAllAccount();
	}
	
	@PostMapping("/accounts")
	public Account addAccount(@Valid @RequestBody Account account){
		return employeeservice.addAccount(account);
	}

	@PostMapping("/users/save")
	public Users addUser(@Valid @RequestBody Users user){
		return employeeservice.addUser(user);
	}
	
	@GetMapping("/users")
	public Users listUser(@Valid @RequestBody EmployeeRequest employeeRequest) throws ResourceNotFoundException{
		return employeeservice.findByUserId(employeeRequest.getEmployeeId());
	}
	
	@GetMapping("/projects")
	public List<Project> listProject() {
		return employeeservice.getAllProjects();
	}
	
	@PostMapping("/projects/save")
	public Project addProject(@Valid @RequestBody Project project) {
		Project projectDetails = employeeservice.addProject(project);
		return projectDetails;
	}

	@PutMapping("/projects/{id}")
	public <ResponseEntity> Project editProject(@PathVariable(value = "id") Long projectId,
			@Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
		Project project =  employeeservice.findByProjectId(projectId);
		project.setName(projectDetails.getName());
		project.setAccountId(projectDetails.getAccountId());
		project.setStatus(projectDetails.getStatus());
		return employeeservice.editProject(project);
	}

	@DeleteMapping("/projects/{id}")
	public Boolean deleteProject(@PathVariable(value = "id") Long projectId,
			@Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
		Project project =  employeeservice.findByProjectId(projectId);
		employeeservice.deleteProject(project);
		return true;
	}
	
}
