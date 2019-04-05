package com.tcs.tool.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.tool.angular.model.AccountDto;
import com.tcs.tool.angular.model.ProjectDto;
import com.tcs.tool.model.Account;
import com.tcs.tool.model.Employee;
import com.tcs.tool.model.Project;
import com.tcs.tool.service.AccountService;

@Component
public class AccountTransformer {

	@Autowired
	private AccountService accountService;

	public List<AccountDto> transformAccountResponse(List<Account> accountList) {
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

}
