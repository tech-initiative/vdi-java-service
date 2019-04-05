package com.tcs.tool.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tcs.tool.angular.model.AccountDto;
import com.tcs.tool.angular.model.ProjectDto;
import com.tcs.tool.model.Project;

@Component
public class ProjectTransformer {

	public List<ProjectDto> transformProjectResponse(List<Project> projects) {
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
