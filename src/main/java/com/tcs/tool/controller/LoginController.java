package com.tcs.tool.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.tool.angular.model.EmployeeRequest;
import com.tcs.tool.model.Users;
import com.tcs.tool.service.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class LoginController {

	@Autowired
	private EmployeeService employeeservice;
	
	@PostMapping("/login")
	public Users login(@Valid @RequestBody EmployeeRequest employeeRequest) {
		//validateRequest(employeeRequest);
		Users user = employeeservice.getUserByCredential(employeeRequest);
		return user;
	}

	
}
