package com.tcs.tool.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.tool.model.Account;
import com.tcs.tool.model.Users;
import com.tcs.tool.service.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ReportController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/accounts")
	public List<Account> listAccount() {
		return employeeservice.findAllAccount();
	}
	
	@PostMapping("/accounts")
	public Account addAccount(@Valid @RequestBody Account account){
		return employeeservice.addAccount(account);
	}

	@PostMapping("/users/save")
	public Users addUser(@Valid @RequestBody Users user){
		return employeeservice.addUser(user);
	}

	
}
