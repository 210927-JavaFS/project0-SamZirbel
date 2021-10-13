package com.revature.procedures;

import java.util.Scanner;

import com.revature.models.Login;

public class UserCredentialProcedure {

	static Scanner scanin = new Scanner(System.in);

	public static Login getCredentials() {
	
		echo("Initiating User Credential Procedure");
		
		Login user = new Login();
		
		String username = QueryUsernameProcedure.queryUsername();
		String password = QueryPasswordProcedure.queryPassword();
		
		user.setUsername(username);
		user.setPassword(password);
		
		return user;
		
	}
	
	public static void echo(String toprint) {
	
		System.out.println(toprint);
	
	}

}
