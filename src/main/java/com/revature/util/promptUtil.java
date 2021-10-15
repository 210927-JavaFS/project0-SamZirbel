package com.revature.util;

import com.revature.models.FullJoin;

public class promptUtil {

	public static int accountNumberSingularPrompt() {
	
		echo ("What Is The Account Number Which You intend to perform this operation on?");
		
		int response = queryUtil.queryAccount();
		
		return response;
	
	}

	public static String accountTypeResetPrompt() {
	
		echo ("What Type Would You Like To Set This Account As?");
		
		String response = queryUtil.queryAccountType();
		
		return response;
	
	}
	
	public static void staffUpdateAccountPrompt(FullJoin fulljoin) {
	
		echo ("");
		echo ("What Would You Like To Update Or Do?");
	
		if (fulljoin == null) {
		
			echo ("    [ No Account Selected Yet ]");
		
		}
		else {
		
			echo (fulljoin.viewAccountCredentials());
		
		}
		
		echo("");
		
		return;
	
	}
	
	public static String updateUsernamePrompt() {
	
		echo ("What Would You Like To Set The Username As?");
		
		String response = queryUtil.queryUsername();
		
		return response;
	
	}
	
	public static String updatePasswordPrompt() {
	
		echo ("What Would You Like To Set The Password As?");
		
		String response = queryUtil.queryPassword();
		
		return response;
	
	}
	
	public static String updateFirstNamePrompt() {
	
		echo ("What Is The New First Name?");
		
		String response = queryUtil.queryFirstName();
		
		return response;
	
	}
	
	public static String updateLastNamePrompt() {
	
		echo ("What Is The New Last Name?");
		
		String response = queryUtil.queryLastName();
		
		return response;
	
	}
	
	public static String setUsernamePrompt() {
	
		echo ("What Would You Like You Username To Be?");
		
		String response = queryUtil.queryUsername();
		
		return response;
	
	}
	
	public static String setPasswordPrompt() {
	
		echo ("What Would You Like To Set Your Password As?");
		
		String response = queryUtil.queryPassword();
		
		return response;
		
	}
	
	public static String setFirstNamePrompt() {
	
		echo ("What Is Your First Name?");
		
		String response = queryUtil.queryFirstName();
		
		return response;
		
	}
	
	public static String setLastNamePrompt() {
	
		echo ("What Is Your Last Name?");
		
		String response = queryUtil.queryLastName();
		
		return response;
		
	}
	
	public static String loginUsernamePrompt() {
	
		echo ("  LOGIN : What Is Your Username?");
		
		String response = queryUtil.queryUsername();
		
		return response;
		
	}
	
	public static String loginPasswordPrompt() {
	
		echo ("  LOGIN : What Is Your Password?");
		
		String response = queryUtil.queryPassword();
		
		return response;
		
	}
	
	
	public static void echo(String toprint){
	
		System.out.println(toprint);
		
	}

}
