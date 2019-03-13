package com.tcs.tool.service;

import java.util.List;

import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Team;

public interface TeamService {

	List<Team> getAllTeams();

	Team addTeam(Team team);

	Team editTeam(Team team);

	void deleteTeam(Team team);

	Team findByTeamId(Long teamId) throws ResourceNotFoundException;
}
