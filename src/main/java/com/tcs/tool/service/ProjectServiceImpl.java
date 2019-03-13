package com.tcs.tool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.tool.dao.ProjectDao;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	@Override
	public Project addProject(Project project) {
		return projectDao.addProject(project);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectDao.findAllProject();
	}

	@Override
	public Project editProject(Project project) {
		return projectDao.editProject(project);
	}

	@Override
	public void deleteProject(Project project) {
		 projectDao.deleteProject(project);
	}

	@Override
	public Project findByProjectId(Long projectId) throws ResourceNotFoundException {
		return projectDao.findByProjectId(projectId);
	}
}
