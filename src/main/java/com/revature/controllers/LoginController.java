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
	
	
	}
	
	public void echo(String toPrint) {
	
		System.out.println(toPrint);
	
	}

}
