package com.revature.util;

import java.util.Scanner;

public class queryUtil {

	private static Scanner scanin = new Scanner(System.in);
	
	public static String queryUsername() {
	
		echo("What Is Your Desired Username?");
		
		String answer = scanin.nextLine();
		
		return answer;
	
	}
	
	public static String queryPassword() {
	
		echo("What Is Your Desired Password?");
		
		String answer = scanin.nextLine();
		
		return answer;
		
	}
	
	public static String queryFirstName() {
	
		echo("What Is Your First Name?");
		
		String answer = scanin.nextLine();
		
		return answer;
	
	}
	
	public static String queryLastName() {
	
		echo("What Is Your Last Name?");
		
		String answer = scanin.nextLine();
		
		return answer;
	
	}
	
	public static int queryAccount() {
	
		echo("What Account Would You Like?");
		
		String answer = scanin.nextLine();
	
		int result = Integer.parseInt(answer);
		
		return result;
	
	}
	
	public static String queryApprovalDecision() {
	
		echo("Have You Decided What To Do With This Account?");
		
		String answer = "A";
		
		while (!answer.equals("Approved") && !answer.equals("Denied")) {
		
			echo ("Please Respond Approved Or Denied");
			
			answer = scanin.nextLine();
		
		}
		
		return answer;
	
	}
	
	public static void echo(String toprint) {
	
		System.out.println(toprint);
	
	}

}
