package com.tcs.tool.dao;

import java.util.List;

import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Team;

public interface TeamDao {

	Team addTeam(Team team);

	Team editTeam(Team team);

	void deleteTeam(Team team);

	List<Team> findAllTeam();

	Team findByTeamId(Long teamId) throws ResourceNotFoundException;

}