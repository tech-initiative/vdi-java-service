package com.tcs.tool.dao;

import java.util.List;

import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Project;

public interface ProjectDao {

	Project addProject(Project project);

	Project editProject(Project project);

	void deleteProject(Project project);

	List<Project> findAllProject();

	Project findByProjectId(Long projectId) throws ResourceNotFoundException;

}