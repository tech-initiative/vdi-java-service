package com.tcs.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.tool.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	@Query("From Users u where u.tcsEmployeeId= ?1 and u.password= ?2 and u.isAdmin= ?3")
	Users findByEmployeeCredential(Long tcsEmployeeId, String password, boolean isAdmin);

}
