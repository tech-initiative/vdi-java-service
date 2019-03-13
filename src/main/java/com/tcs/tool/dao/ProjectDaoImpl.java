package com.tcs.tool.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Project;
import com.tcs.tool.repository.ProjectRepository;

@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project addProject(@Valid Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project editProject(@Valid Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void deleteProject(@Valid Project project) {
		projectRepository.delete(project);
	}

	@Override
	public List<Project> findAllProject() {
		return projectRepository.findAll();
	}

	/*
	 * @Override public Optional<Project> findById(Long Id) { return
	 * projectRepository.findById(Id); }
	 */

	@Override
	public Project findByProjectId(Long projectId) throws ResourceNotFoundException {
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + projectId));
		// projectRepository.findById(projectId);
		return project;
	}
}
