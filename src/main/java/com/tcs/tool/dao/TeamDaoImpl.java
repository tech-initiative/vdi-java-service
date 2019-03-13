package com.tcs.tool.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Team;
import com.tcs.tool.repository.TeamRepository;

@Repository
public class TeamDaoImpl implements TeamDao {
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Team addTeam(@Valid Team project) {
		return teamRepository.save(project);
	}

	@Override
	public Team editTeam(@Valid Team project) {
		return teamRepository.save(project);
	}

	@Override
	public void deleteTeam(@Valid Team project) {
		teamRepository.delete(project);
	}

	@Override
	public List<Team> findAllTeam() {
		return teamRepository.findAll();
	}

	/*
	 * @Override public Optional<Team> findById(Long Id) { return
	 * teamRepository.findById(Id); }
	 */

	@Override
	public Team findByTeamId(Long projectId) throws ResourceNotFoundException {
		Team project = teamRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + projectId));
		// teamRepository.findById(projectId);
		return project;
	}
}
