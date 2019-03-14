package com.tcs.tool.controller;

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

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Employee;
import com.tcs.tool.model.Project;
import com.tcs.tool.model.Team;
import com.tcs.tool.repository.AccountRepository;
import com.tcs.tool.service.AccountService;
import com.tcs.tool.service.EmployeeService;
import com.tcs.tool.service.ProjectService;
import com.tcs.tool.service.TeamService;

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

	@GetMapping("/accounts")
	public List<Account> listAccount() {
		return accountService.findAllAccount();
	}

	@PostMapping("/accounts")
	public Account addAccount(@Valid @RequestBody Account account) {
		return accountService.addAccount(account);
	}

	@PostMapping("/users/save")
	public Employee addUser(@Valid @RequestBody Employee user) {
		return employeeService.addUser(user);
	}

	@PostMapping("/users")
	public List<Employee> listUser(@Valid @RequestBody EmployeeRequest employeeRequest)
			throws ResourceNotFoundException {
		List<Employee> employeeList = null;
		if (Optional.ofNullable(employeeRequest.getEmployeeId()).isPresent()) {
			employeeList = employeeService.findByEmployeeId(employeeRequest.getEmployeeId());
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

	@GetMapping("/projects")
	public List<Project> listProject() {
		return projectService.getAllProjects();
	}

	@PostMapping("/projects")
	public Project addProject(@Valid @RequestBody Project project) {
		accountrep.findById(new Long(1));

		Account account = accountrep.findById(new Long(1)).get();
		//account.getProjectList().add(project);
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
