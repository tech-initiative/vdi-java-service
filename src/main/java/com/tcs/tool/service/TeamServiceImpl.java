package com.tcs.tool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.tool.dao.TeamDao;
import com.tcs.tool.exception.ResourceNotFoundException;
import com.tcs.tool.model.Team;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDao teamDao;
	
	@Override
	public Team addTeam(Team team) {
		return teamDao.addTeam(team);
	}

	@Override
	public List<Team> getAllTeams() {
		return teamDao.findAllTeam();
	}

	@Override
	public Team editTeam(Team team) {
		return teamDao.editTeam(team);
	}

	@Override
	public void deleteTeam(Team team) {
		 teamDao.deleteTeam(team);
	}

	@Override
	public Team findByTeamId(Long teamId) throws ResourceNotFoundException {
		return teamDao.findByTeamId(teamId);
	}
}
