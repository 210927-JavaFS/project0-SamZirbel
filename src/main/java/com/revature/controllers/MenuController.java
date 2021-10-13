package com.revature.controllers;

import java.util.Scanner;

import com.revature.subservices.UserCredentialSubservice;

public class MenuController {

	Scanner scanin = new Scanner(System.in);
	
	LoginController logincontroller = new LoginController();
	
	public void startupMenu(){
	
		echo("Welcome To Super Forrest");
		
		String response = "A";
		
		while (!response.equals("0")){
		
			echo("What Would You Like To Do");
			
			echo("0 : Exit");
			echo("1 : View All User Information");
			echo("2 : Add User");
			echo("3 : Delete User");
			echo("4 : Find A User");
			echo("5 : Update Username");
			
			response = scanin.nextLine();
		
			switch(response) {
				case "1" :
					logincontroller.listAllUsers();
					break;
				case "2" :
					logincontroller.addUser();
					break;
				case "3" :
					logincontroller.deleteUser();
					break;
				case "4" :
					logincontroller.findUser();
					break;
				case "5" :
					logincontroller.updateUsername();
					break;
				default :
					break;
					
			} // << End Startup Menu Switch Case
		
		} // << End Startup Menu While
	
	}
	
	public void echo(String toPrint) {
	
		System.out.println(toPrint);
	
	}

}
