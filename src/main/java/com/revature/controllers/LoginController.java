package com.revature.controllers;

import java.util.List;

import com.revature.models.Login;
import com.revature.services.LoginService;

public class LoginController {

	private LoginService loginservice = new LoginService();
	
	public void listAllUsers() {
	
		echo("These Are The Currently Registered Users: ");
		
		List<Login> userlist = loginservice.listAllUsers();
		
		for (Login L : userlist) {
		
			System.out.println(L);
		
		}
		
		return;
	
	}
	
	public void addUser() {
		
		echo("Adding New User");
		
		if (loginservice.addUser()) {
		
			echo("User Successfully Added");
		
		}
		else {
		
			echo("Failed To Add User");
		
		}
		
		return;
	
	}
	
	public void echo(String toPrint) {
	
		System.out.println(toPrint);
	
	}

}
