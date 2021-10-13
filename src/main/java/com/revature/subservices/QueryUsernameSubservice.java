package com.revature.subservices;

import java.util.Scanner;

public class QueryUsernameSubservice {

	static Scanner scanin = new Scanner(System.in);

	public static String queryUsername() {
		
		echo("Defining Username");
		
		String username = null;
		
		while (username == null) {

			echo("What Is The Pertinent Username?");
			
			username = scanin.nextLine();
		
		}
		
		return username;
	
	}
	
	public static void echo(String toprint) {
		
		System.out.println(toprint);
	
	}

}
