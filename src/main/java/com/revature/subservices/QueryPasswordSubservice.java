package com.revature.subservices;

import java.util.Scanner;

public class QueryPasswordSubservice {

	static Scanner scanin = new Scanner(System.in);

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
