package com.revature.controllers;

import java.util.List;

import com.revature.models.Login;
import com.revature.services.LoginService;
import com.revature.util.promptUtil;
import com.revature.util.queryUtil;

public class LoginController {

	private LoginService loginservice = new LoginService();
	
	private GardenAccountController gardenaccountcontroller = new GardenAccountController();
	
	public boolean createAccount() {
	
		echo("Welcome To Account Creation!");
		
		String username = promptUtil.setUsernamePrompt();
		String password = promptUtil.setPasswordPrompt();
		String firstname = promptUtil.setFirstNamePrompt();
		String lastname = promptUtil.setLastNamePrompt();
		
		boolean success = loginservice.createAccount(username, password, firstname, lastname);
		
		return success;
		
	}
	
	public void logIn() {
	
		echo("Attempting To Log In!");
		
		String username = promptUtil.loginUsernamePrompt();
		String password = promptUtil.loginPasswordPrompt();
		
		boolean success = loginservice.logIn(username, password);
		
		if (success) {
		
			int account = loginservice.getAccount(username);
		
			gardenaccountcontroller.accountTypeFilter(account);
		
		}
	
	}
	
	
	
	/*
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
	
	public void getPassword() {
	
		echo ("Fetching Password");
		
		int queryResult = loginservice.getPassword();
		
		switch (queryResult) {
		
		case 0:
		case 2:
			echo("    [Password Query Failed]");
			echo("    [Provided User Not In Database]");
			break;
		case 1:
			echo("Sucessfully Obtained Password");
			break;
		
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
	
	public void updatePassword() {
	
		echo ("Updating Password");
		
		int updateResult = loginservice.updatePassword();
		
		switch (updateResult) {
		
		case 0:
			echo ("Failed To Update Password");
			echo ("Provided Username Not Found Inside Database");
			break;
		case 1:
			echo ("Successfully Updated Password");
			break;
		case 2:
			echo ("Failed To Update Password");
			echo ("New Password Is Identical To Old Password");
			break;
			
		}
		
		return;
	
	}
	
	*/
	
	public void echo(String toPrint) {
	
		System.out.println(toPrint);
	
	}

}
