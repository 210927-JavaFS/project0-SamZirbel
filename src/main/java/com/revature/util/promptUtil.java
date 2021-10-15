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
	
	public static void sponsorUpdateAccountPrompt(FullJoin fulljoin) {
		
		echo ("");
		echo ("Hello Sponsor, Welcome To Your Account Update Page");
		
		echo ("Account Number : " + fulljoin.getAccount());
		
		echo (fulljoin.viewAccountCredentials());
		
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
	

	public static void staffManageBirdFeedersPrompt(FullJoin fulljoin, String response) {
	
		if (!response.equals("6")) {
		
			echo ("");
			echo ("Where Would You Like To Move Bird Feeders?");
		
			if (fulljoin == null) {
			
				echo ("    [ No Account Selected Yet ]");
			
			}
			else {
			
				echo ("Viewing Account : " + fulljoin.getAccount());
				echo (fulljoin.viewSponsoredTreeInfo());
			
			}
			
		}
		// VV Transfer Case
		else {
			
			echo ("Transferring To : ");
			echo (fulljoin.viewSponsoredTreeInfo());
			
		}
		
		echo("");
		
		return;
	
	}
	
	public static void sponsorManageBirdFeedersPrompt(FullJoin fulljoin) {
		
		echo ("");
		echo ("What Would You Like To Know About / Do With Your Tree?");
		
		echo ("Your Account : " + fulljoin.getAccount());
		echo (fulljoin.viewSponsoredTreeInfo());
			
		echo("");
		
		return;
	
	}
	
	public static int addBirdFeedersPrompt() {
	
		echo ("How Many Bird Feeders Would You Like To Add?");
		
		int response = queryUtil.queryBirdFeeders();
		
		return response;
	
	}
	
	public static int removeBirdFeedersPrompt() {
	
		echo ("How Many Bird Feeders Would You Like To Remove?");
		
		int response = queryUtil.queryBirdFeeders();
		
		return response;
		
	}
	
	public static int transferBirdFeedersPrompt() {
	
		echo ("How Many Bird Feeders Would You Like To Transfer?");
		
		int response = queryUtil.queryBirdFeeders();
		
		return response;
	
	}

	public static int transferringFromPrompt() {
	
		echo ("What Account Should The Bird Feeders Be Transferred From?");
		
		int response = queryUtil.queryAccount();
		
		return response;
	
	}
	
	public static int transferringToPrompt() {
	
		echo ("What Account Should The Feeders Be Transferred To?");
		
		int response = queryUtil.queryAccount();
		
		return response;
	
	}

}
