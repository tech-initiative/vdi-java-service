package com.tcs.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.tool.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
