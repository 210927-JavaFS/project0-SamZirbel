package com.revature.controllers;

import java.util.List;

import com.revature.models.Login;
import com.revature.services.LoginService;

public class LoginController {

	private LoginService loginservice = new LoginService();
	
	public void listAllUsers() {
	
		echo("These Are The Currently Registered Users: ");
		
		List<Login> userlist = loginservice.listAllUsers();
		
		// VV What To Print If Database Is Empty
		if (userlist.size() == 0) {
		
			echo("");
			echo("    [No Users Found Within Database]    ");
			echo("");
			
		}
		// VV Otherwise Print Out THe Users
		else {
		
			for (Login L : userlist) {
			
				System.out.println(L);
			
			}
		
		}
		
		return;
	
	}
	
	public void findUser() {
	
		echo("Finding Specific User");
		
		List<Login> matches = loginservice.findUser();
		
		if (matches.size() == 0) {
		
			echo ("No Match Found For Username");
			
		}
		else {
		
			if (matches.size() != 1) {
		
			echo ("Warning : Found Multiple Matches For Username");
			
			}
			

			for (Login L : matches) {
			
				System.out.println(L);
		
			}
			
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
			echo("This Username Is Username Taken");
		
		}
		
		return;
	
	}
	
	public void deleteUser() {
	
		echo("User Deletion Process Initiated");
		
		if (loginservice.deleteUser()) {
		
			echo("User Sucessfully Deleted");
			
		}
		else {
			
			echo("Unable To Delete User");
			echo("Provided User Does Not Exist In Database");
			
		}
		
		return;
	
	}
	
	public void updateUsername() {
	
		echo ("Updating User");
		
		int updateResult = loginservice.updateUsername();
		
		switch (updateResult) {
		
			case 0:
				echo ("Failed To Update Username");
				echo ("Old And New Provided Usernames Match");
				break;
			case 1:
				echo ("Successfully Updated Username");
				break;
			case 2:
				echo ("Failed To Update Username");
				echo ("New Username Already Within Database");
				break;
			case 3:
				echo ("Failed To Update Username");
				echo ("Old Username Is Not Found Within Database");
				break;
		
		} // << End Result Switch Case
		
		return;
	
	}
	
	public void echo(String toPrint) {
	
		System.out.println(toPrint);
	
	}

}
