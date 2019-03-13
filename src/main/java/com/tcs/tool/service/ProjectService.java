package com.tcs.tool.service;

import java.util.List;

import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	Project addProject(Project project);

	Project editProject(Project project);

	void deleteProject(Project project);

	Project findByProjectId(Long projectId) throws ResourceNotFoundException;
}
