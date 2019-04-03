package com.tcs.tool.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.fasterxml.jackson.annotation.JsonView;
import com.tcs.tool.angular.model.AccountDto;
import com.tcs.tool.angular.model.EmployeeAddRequest;
import com.tcs.tool.angular.model.EmployeeLoginRequest;
import com.tcs.tool.angular.model.ProjectDto;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Employee;
import com.tcs.tool.model.Project;
import com.tcs.tool.model.Team;
import com.tcs.tool.model.View;
import com.tcs.tool.repository.AccountRepository;
import com.tcs.tool.service.AccountService;
import com.tcs.tool.service.EmployeeService;
import com.tcs.tool.service.ProjectService;
import com.tcs.tool.service.TeamService;
import com.tcs.tool.service.Transforms;

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

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private AccountRepository accountrep;
	
	@Autowired
	private Transforms transforms;

	@GetMapping("/accounts")
	public List<AccountDto> listAccount() {
		List<Account> accountList = accountService.findAllAccount();
		return transforms.setAccountDetails(accountList);		
	}

	@PostMapping("/accounts")
	public Account addAccount(@Valid @RequestBody Account account) {
		return accountService.addAccount(account);
	}

	@PutMapping("/accounts")
	public Account editAccount(@Valid @RequestBody Account account) {
		return accountService.editAccount(account);
	}
	
	@DeleteMapping("/accounts")
	public void deleteAccount(@Valid @RequestBody Account account) {
		accountService.deleteAccount(account);
	}
	
	@PostMapping("/users/save")
	public Employee addUser(@Valid @RequestBody EmployeeAddRequest employeeAddRequest) {
		Employee addUser = employeeService.addUser(employeeAddRequest);
		return addUser;
	}

	@PostMapping("/users")
	public List<Employee> listUser(@Valid @RequestBody EmployeeLoginRequest employeeRequest)
			throws ResourceNotFoundException {
		List<Employee> employeeList = null;
		if (Optional.ofNullable(employeeRequest.getEmployeeId()).isPresent()) {
			employeeList = new ArrayList<>();
			employeeList.add(employeeService.findByEmployeeId(employeeRequest.getEmployeeId()));
		} else if (Optional.ofNullable(employeeRequest.getEmailId()).isPresent()) {
			employeeList = employeeService.findByUserEmail(employeeRequest.getEmailId());
		} else if (Optional.ofNullable(employeeRequest.getLocationId()).isPresent()) {
			employeeList = employeeService.findByUserLocation(employeeRequest.getLocationId());
		}

		if (null == employeeList || employeeList.isEmpty()) {
			throw new ResourceNotFoundException("User not found");
		}

		return employeeList;
	}

	@PutMapping("/users")
	public Employee editUser(@Valid @RequestBody Employee user) {
		return employeeService.editUser(user);
	}
	
	@DeleteMapping("/users")
	public void deleteUser(@Valid @RequestBody Employee user) {
		employeeService.deleteUser(user);
	}

	@GetMapping("/projects")
	public List<ProjectDto> listProject() {
		List<Project> projects = projectService.getAllProjects();
		return transforms.setProjectDetails(projects);
	}

	@PostMapping("/projects")
	@JsonView(View.Summary.class)
	public Project addProject(@Valid @RequestBody Project project) {
		Account account = accountrep.findById(new Long(project.getAccountId())).get();
		account.getProjectList().add(project);
		project.setAccount(account);
		Project projectDetails = projectService.addProject(project);
		return projectDetails;
	}

	@PutMapping("/projects/{id}")
	public <ResponseEntity> Project editProject(@PathVariable(value = "id") Long projectId,
			@Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
		Project project = projectService.findByProjectId(projectId);
		project.setName(projectDetails.getName());
		project.setAccountId(projectDetails.getAccountId());
		project.setIsActive(projectDetails.getIsActive());
		return projectService.editProject(project);
	}

	@DeleteMapping("/projects/{id}")
	public Boolean deleteProject(@PathVariable(value = "id") Long projectId, @Valid @RequestBody Project projectDetails)
			throws ResourceNotFoundException {
		Project project = projectService.findByProjectId(projectId);
		projectService.deleteProject(project);
		return true;
	}

	@GetMapping("/teams")
	public List<Team> listTeam() {
		return teamService.getAllTeams();
	}

	@PostMapping("/teams")
	public Team addTeam(@Valid @RequestBody Team team) {
		Team teamDetails = teamService.addTeam(team);
		return teamDetails;
	}

	@PutMapping("/teams/{id}")
	public <ResponseEntity> Team editTeam(@PathVariable(value = "id") Long teamId, @Valid @RequestBody Team teamDetails)
			throws ResourceNotFoundException {
		Team team = teamService.findByTeamId(teamId);
		team.setName(teamDetails.getName());
		team.setProjectId(teamDetails.getProjectId());
		team.setIsActive(teamDetails.getIsActive());
		return teamService.editTeam(team);
	}

	@DeleteMapping("/teams/{id}")
	public Boolean deleteTeam(@PathVariable(value = "id") Long teamId, @Valid @RequestBody Team teamDetails)
			throws ResourceNotFoundException {
		Team team = teamService.findByTeamId(teamId);
		teamService.deleteTeam(team);
		return true;
	}

}
