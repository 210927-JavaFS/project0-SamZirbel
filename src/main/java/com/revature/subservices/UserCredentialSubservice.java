package com.revature.subservices;

import java.util.Scanner;

import com.revature.models.Login;

public class UserCredentialSubservice {

	static Scanner scanin = new Scanner(System.in);

	public static Login getCredentials() {
	
		echo("Initiating User Credential Subservice");
		
		Login user = new Login();
		
		String username = QueryUsernameSubservice.queryUsername();
		String password = QueryPasswordSubservice.queryPassword();
		
		user.setUsername(username);
		user.setPassword(password);
		
		return user;
		
	}
	
	public static void echo(String toprint) {
	
		System.out.println(toprint);
	
	}

}
