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
import com.tcs.tool.model.Employee;
import com.tcs.tool.service.AccountService;
import com.tcs.tool.service.ProjectService;
import com.tcs.tool.service.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ReportController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts")
	public List<Account> listAccount() {
		return accountService.findAllAccount();
	}
	
	@PostMapping("/accounts")
	public Account addAccount(@Valid @RequestBody Account account){
		return accountService.addAccount(account);
	}

	@PostMapping("/users/save")
	public Employee addUser(@Valid @RequestBody Employee user){
		return employeeService.addUser(user);
	}
	
	@GetMapping("/users")
	public Employee listUser(@Valid @RequestBody EmployeeRequest employeeRequest) throws ResourceNotFoundException{
		return employeeService.findByUserId(employeeRequest.getEmployeeId());
	}
	
	@GetMapping("/projects")
	public List<Project> listProject() {
		return projectService.getAllProjects();
	}
	
	@PostMapping("/projects/save")
	public Project addProject(@Valid @RequestBody Project project) {
		Project projectDetails = projectService.addProject(project);
		return projectDetails;
	}

	@PutMapping("/projects/{id}")
	public <ResponseEntity> Project editProject(@PathVariable(value = "id") Long projectId,
			@Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
		Project project =  projectService.findByProjectId(projectId);
		project.setName(projectDetails.getName());
		project.setAccountId(projectDetails.getAccountId());
		project.setStatus(projectDetails.getStatus());
		return projectService.editProject(project);
	}

	@DeleteMapping("/projects/{id}")
	public Boolean deleteProject(@PathVariable(value = "id") Long projectId,
			@Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
		Project project =  projectService.findByProjectId(projectId);
		projectService.deleteProject(project);
		return true;
	}
	
}
