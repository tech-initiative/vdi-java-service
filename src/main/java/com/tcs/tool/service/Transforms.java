package com.tcs.tool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tcs.tool.angular.model.AccountDto;
import com.tcs.tool.angular.model.ProjectDto;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Employee;
import com.tcs.tool.model.Project;

public class Transforms {
	
	@Autowired
	private AccountService accountService;

	public List<AccountDto> setAccountDetails(List<Account> accountList) {
		List<AccountDto> accountListDto = new ArrayList<>();
		for (Account account : accountList) {
			AccountDto accountDto = new AccountDto();
			accountDto.setAccId(account.getAccId());
			accountDto.setActive(account.getIsActive());
			accountDto.setLocationId(account.getLocationId());
			accountDto.setName(account.getName());
			List<ProjectDto> projectListDto = new ArrayList<>();
			for (Project project : account.getProjectList()) {
				ProjectDto projectDto = new ProjectDto();
				projectDto.setAccountId(project.getAccountId());
				projectDto.setActive(project.getIsActive());
				projectDto.setName(project.getName());
				projectDto.setProjectId(project.getProjectId());
				projectDto.setStatus(project.getStatus());
				projectListDto.add(projectDto);
			}
			accountDto.setProjectList(projectListDto);
			List<Employee> accountManagers = accountService.findAccountManager(account.getAccId());
			accountDto.setAccountManager(accountManagers);
			accountListDto.add(accountDto);
		}
		return accountListDto;
	}

	public List<ProjectDto> setProjectDetails(List<Project> projects) {
		List<ProjectDto> projectListDto = new ArrayList<>();
		for (Project project : projects) {
			ProjectDto projectDto = new ProjectDto();
			projectDto.setAccountId(project.getAccountId());
			projectDto.setActive(project.getIsActive());
			projectDto.setName(project.getName());
			projectDto.setProjectId(project.getProjectId());
			projectDto.setStatus(project.getStatus());
			AccountDto accountDto = new AccountDto();
			accountDto.setAccId(project.getAccount().getAccId());
			accountDto.setActive(project.getAccount().getIsActive());
			accountDto.setLocationId(project.getAccount().getLocationId());
			accountDto.setName(project.getAccount().getName());
			accountDto.setStatus(project.getAccount().getStatus());
			projectDto.setAccount(accountDto);
			projectListDto.add(projectDto);
		}
		return projectListDto;
	}
}
