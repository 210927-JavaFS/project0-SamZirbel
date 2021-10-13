package com.revature.procedures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Login;

public class UserCredentialProcedure {

	static Scanner scanin = new Scanner(System.in);

	public static Login getCredentials() {
	
		echo("Initiating User Credential Procedure");
		
		Login user = new Login();
		
		user.setUsername(queryUsername());
		user.setPassword(queryPassword());
		
		return user;
		
	}
	
	public static String queryUsername() {
	
		echo("Defining Username");
		
		String username = null;
		
		while (username == null) {

			echo("What Is The Pertinent Username?");
			
			username = scanin.nextLine();
		
		}
		
		return username;
	
	}
	
	public static String queryPassword() {
	
		echo("Defining Password");
		
		String password = null;
		
		while (password == null) {
		
			echo("What Is The Pertinent Password?");
			
			password = scanin.nextLine();
			
		}
		
		return password;
	
	}
	
	public static void echo(String toprint) {
	
		System.out.println(toprint);
	
	}

}
