package com.revature.util;

import java.util.Scanner;

public class queryUtil {

	private static Scanner scanin = new Scanner(System.in);
	
	public static String queryUsername() {
	
		String answer = scanin.nextLine();
		
		return answer;
	
	}
	
	public static String queryPassword() {
	
		String answer = scanin.nextLine();
		
		return answer;
		
	}
	
	public static String queryFirstName() {
	
		String answer = scanin.nextLine();
		
		return answer;
	
	}
	
	public static String queryLastName() {
	
		String answer = scanin.nextLine();
		
		return answer;
	
	}
	
	public static int queryAccount() {
	
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
	
	public static String queryAccountType() {
	
		String answer = "A";
		
		while (!answer.equals("Owner") && !answer.equals("Employee") 
			&& !answer.equals("Sponsor") && !answer.equals("Cancel")){
		
			echo ("Plase Respond With : Owner, Employee, Sponsor, or Cancel");
			
			answer = scanin.nextLine();
		
		}
		
		return answer;
	
	}
	
	public static void echo(String toprint) {
	
		System.out.println(toprint);
	
	}

}
