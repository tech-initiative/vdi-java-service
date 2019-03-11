package com.tcs.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.tool.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
