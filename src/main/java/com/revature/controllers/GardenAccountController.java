package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.FullJoin;
import com.revature.services.GardenAccountService;
import com.revature.util.displayUtil;
import com.revature.util.encryptDecryptUtil;
import com.revature.util.promptUtil;
import com.revature.util.queryUtil;

public class GardenAccountController {

	private Scanner scanin = new Scanner(System.in);

	private GardenAccountService gardenaccountservice = new GardenAccountService();

	public void accountTypeFilter(int account) {
	
		String accounttype = gardenaccountservice.getAccountType(account);
		
		if (accounttype == null) {
		
			accounttype = "Pending";
		
		}
		
		switch (accounttype) {
		
			case "Owner" :
				OwnerStartup();
				break;
			case "Employee" :
				EmployeeStartup();
				break;
			case "Sponsor" :
			case "Pending" :
				SponsorStartup(account);
				break;
		
		}
	
	}

	public void SponsorStartup(int account) {
	
		echo("Congratulations! Successful Login!");

		FullJoin useraccount;

		String response = "A";
		
		while (!response.equals("0")){

			useraccount = gardenaccountservice.getAccountFullJoin(account);

			echo ("");
			echo ("What Account Function Would You Like To Access?");
			
			echo ("0 : logout");
			echo ("1 : View All Your Sponsor Account Information");
			echo ("2 : Update Your Account");
			echo ("3 : Manage Your Bird Feeders");
		
			response = scanin.nextLine();
			
			switch (response) {
			
				case "0" :
					break;
				case "1" :
					System.out.println(useraccount);
					break;
				case "2" :
					sponsorUpdateAccountUI(account);
					break;
				case "3" :
					sponsorManageBirdFeedersUI(account);
					break;
			
			} // << End Switch Case
			
		} // << End While Loop
		
	}
	
	public void EmployeeStartup() {
	
		echo("Welcome Employee! Successful Login!");
		
		int pending = 0;

		String response = "A";
		
		while (!response.equals("0")){
		
			echo ("");
			echo ("What Account Function Would You Like To Access?");
			
			echo ("0 : logout");
			echo ("1 : View Pending Accounts");
			echo ("2 : Approval / Denial Of Prospective Accounts");
			echo ("3 : Provide Trees To Newly Approved");
			echo ("4 : View All Account Information");
			echo ("5 : Update Account");
			echo ("6 : Manage Bird Feeders");
		
			response = scanin.nextLine();
			
			switch (response) {
			
				case "0" :
					break;
				case "1" :
					pending = gardenaccountservice.countPendingAccounts();
					if (pending > 0) { gardenaccountservice.viewPendingAccounts(); }
					else { echo("\nThere Are Currently No Accounts Pending Approval\n"); }
					break;
				case "2" :
					int account = promptUtil.accountNumberSingularPrompt();
					String decision = queryUtil.queryApprovalDecision();
					gardenaccountservice.updateGardenStatus(account, decision);
					break;
				case "3" :
					gardenaccountservice.provideTrees();
					break;
				case "4" :
					gardenaccountservice.viewAllAccounts();
					break;
				case "5" :
					staffUpdateAccountUI();
					break;
				case "6" :
					staffManageBirdFeedersUI();
					break;
					
			
			} // << End Switch Case
			
		} // << End While Loop
		
		
	
	}
	
	public void OwnerStartup() {
	
		echo("Welcome Botanical Garden Owner! Successful Login!");

		String response = "A";
		
		while (!response.equals("0")){
		
			echo ("");
			echo ("What Account Function Would You Like To Access?");
			
			echo ("0 : logout");
			echo ("1 : View Pending Accounts");
			echo ("2 : Approval / Denial Of Prospective Accounts");
			echo ("3 : Delete Denied Accounts");
			echo ("4 : Provide Trees To Newly Approved");
			echo ("5 : View All Account Information");
			echo ("6 : Set Account Type");
			echo ("7 : Update Account");
			echo ("8 : Manage Bird Feeders");
			echo ("9 : Delete Account");
		
			response = scanin.nextLine();
			
			switch (response) {
			
				case "0" :
					break;
				case "1" :
					gardenaccountservice.viewPendingAccounts();
					break;
				case "2" :
					int account = promptUtil.accountNumberSingularPrompt();
					String decision = queryUtil.queryApprovalDecision();
					gardenaccountservice.updateGardenStatus(account, decision);
					break;
				case "3" :
					gardenaccountservice.deleteDeniedAccounts();
					break;
				case "4" :
					gardenaccountservice.provideTrees();
					break;
				case "5" :
					gardenaccountservice.viewAllAccounts();
					break;
				case "6" :
					account = promptUtil.accountNumberSingularPrompt();
					String accounttype = promptUtil.accountTypeResetPrompt();
					gardenaccountservice.updateAccountType(account, accounttype);
					break;
				case "7" :
					staffUpdateAccountUI();
					break;
				case "8" :
					staffManageBirdFeedersUI();
					break;
				case "9" :
					account = promptUtil.accountNumberSingularPrompt();
					gardenaccountservice.deleteActiveAccount(account);
					break;
					
			
			} // << End Switch Case
			
		} // << End While Loop
	
	}
	
	public void staffUpdateAccountUI() {

		echo("Welcome To The Update Account Portal!");

		FullJoin fulljoin = null;
		int activeaccount = 0;
		String response = "A";
		String update = "";
		String encrypted = "";
		String decrypted = "";
		
		while (!response.equals("0")){
		
			promptUtil.staffUpdateAccountPrompt(fulljoin);
			
			echo ("0 : Return To Account Options");
			echo ("1 : Select An Account For Update");
			echo ("2 : Update Username");
			echo ("3 : Update Password");
			echo ("4 : Update First Name");
			echo ("5 : Update Last Name");
		
			response = scanin.nextLine();
			
			switch (response) {
			
				case "0" :
					break;
				case "1" :
					activeaccount = promptUtil.accountNumberSingularPrompt();
					fulljoin = gardenaccountservice.getAccountFullJoin(activeaccount);
					if (fulljoin == null) { activeaccount = 0; }
					break;
				case "2" :
					if (fulljoin == null) { echo ("Please Select An Account First"); }
					else {
					update = promptUtil.updateUsernamePrompt();
					fulljoin.setUsername(update);
					gardenaccountservice.updateUsername(fulljoin);
					}
					break;
				case "3" :
					if (fulljoin == null) { echo ("Please Select An Account First"); }
					else {
					update = promptUtil.updatePasswordPrompt();
					fulljoin.setUserpassword(update);
					gardenaccountservice.updatePassword(fulljoin);
					
					encrypted = fulljoin.getUserpassword();
					decrypted = encryptDecryptUtil.encryptDecrypt(encrypted);
					fulljoin.setUserpassword(decrypted);
					}
					break;
				case "4" :
					if (fulljoin == null) { echo ("Please Select An Account First"); }
					else {
					update = promptUtil.updateFirstNamePrompt();
					fulljoin.setFirstname(update);
					gardenaccountservice.updateFirstName(fulljoin);
					}
					break;
				case "5" :
					if (fulljoin == null) { echo ("Please Select An Account First"); }
					else {
					update = promptUtil.updateLastNamePrompt();
					fulljoin.setLastname(update);
					gardenaccountservice.updateLastName(fulljoin);
					}
					break;
			
			} // << End Switch Case
			
		} // << End While Loop
	
	}
	
	public void sponsorUpdateAccountUI(int account) {

		echo("Welcome To The Update Account Portal!");

		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(account);
		String response = "A";
		String update = "";
		String encrypted = "";
		String decrypted = "";
		
		while (!response.equals("0")){
		
			promptUtil.sponsorUpdateAccountPrompt(fulljoin);
			
			echo ("0 : Return To Account Options");
			echo ("1 : Update Username");
			echo ("2 : Update Password");
			echo ("3 : Update First Name");
			echo ("4 : Update Last Name");
		
			response = scanin.nextLine();
			
			switch (response) {
			
				case "0" :
					break;
				case "1" :
					update = promptUtil.updateUsernamePrompt();
					fulljoin.setUsername(update);
					gardenaccountservice.updateUsername(fulljoin);
					break;
				case "2" :
					update = promptUtil.updatePasswordPrompt();
					fulljoin.setUserpassword(update);
					
					encrypted = fulljoin.getUserpassword();
					decrypted = encryptDecryptUtil.encryptDecrypt(encrypted);
					fulljoin.setUserpassword(decrypted);
					
					gardenaccountservice.updatePassword(fulljoin);
					break;
				case "3" :
					update = promptUtil.updateFirstNamePrompt();
					fulljoin.setFirstname(update);
					gardenaccountservice.updateFirstName(fulljoin);
					break;
				case "4" :
					update = promptUtil.updateLastNamePrompt();
					fulljoin.setLastname(update);
					gardenaccountservice.updateLastName(fulljoin);
					break;
			
			} // << End Switch Case
			
		} // << End While Loop
	
	}
	
	public void staffManageBirdFeedersUI() {
	

		echo("Welcome To The Bird Feeder Management Portal!");

		FullJoin fulljoin = null;
		int activeaccount = 0;
		String response = "A";
		int feeders = 0;
		int transferfrom = 0;
		//int transferto = 0;
		FullJoin fjtransferfrom = null;
		
		while (!response.equals("0")){
		
			promptUtil.staffManageBirdFeedersPrompt(fulljoin, response);
			
			if (!response.equals("6")) {
			
			echo ("0 : Return To Account Options");
			echo ("1 : Select An Account To View Tree Status");
			echo ("2 : View Grove Status");
			echo ("3 : Add Bird Feeder");
			echo ("4 : Remove Bird Feeder");
			echo ("5 : Transfer Bird Feeder");
			
			// == Case 5 : Obtain User To Transer To && Alter Display
			// == Case 6 : Functionality Of Transfer
		
			response = scanin.nextLine(); 
			
			}
			
			switch (response) {
			
				case "0" :
					break;
				case "1" :
					activeaccount = promptUtil.accountNumberSingularPrompt();
					fulljoin = gardenaccountservice.getAccountFullJoin(activeaccount);
					if (fulljoin == null) { activeaccount = 0; }
					break;
				case "2" :
					List<FullJoin> all = gardenaccountservice.getAllAccounts();
					displayUtil.displayFullGroveTreeInfo(all);
					break;
				case "3" :
					if (fulljoin == null) { echo ("Please Select An Account First"); }
					else {
					feeders = promptUtil.addBirdFeedersPrompt();
					gardenaccountservice.addBirdFeeders(fulljoin, feeders);
					}
					break;
				case "4" :
					if (fulljoin == null) { echo ("Please Select An Account First"); }
					else {
					feeders = promptUtil.removeBirdFeedersPrompt();
					gardenaccountservice.removeBirdFeeders(fulljoin, feeders);
					}
					break;
				case "5" :
					feeders = promptUtil.transferBirdFeedersPrompt();
					
					transferfrom = promptUtil.transferringFromPrompt();
					activeaccount = promptUtil.transferringToPrompt();
					
					if (gardenaccountservice.checkForValidAccount(transferfrom) == false
						|| gardenaccountservice.checkForValidAccount(activeaccount) == false) {
						
						response = "7";
						break;
						
					}
					
					fjtransferfrom = gardenaccountservice.getAccountFullJoin(transferfrom);
					
					
					fulljoin = gardenaccountservice.getAccountFullJoin(activeaccount);

					response = "6";
					break;
				case "6" :
					response = "7";
					
					echo ("Transferred From : ");
					echo (fjtransferfrom.viewSponsoredTreeInfo());
					
					gardenaccountservice.transferManyBirdFeeders(fjtransferfrom, fulljoin, feeders);
					
					echo ("");
					echo ("Transferred Into Active Account Below");
					
					break;
			
			} // << End Switch Case
			
		} // << End While Loop
	
	}
	
	public void sponsorManageBirdFeedersUI(int account) {
		

		echo("Welcome To The Bird Feeder Management Portal!");

		FullJoin fulljoin = gardenaccountservice.getAccountFullJoin(account);
		String response = "A";
		int feeders = 0;
		
		while (!response.equals("0")){
		
			promptUtil.sponsorManageBirdFeedersPrompt(fulljoin);
			
			echo ("0 : Return To Account Options");
			echo ("1 : View Grove Status");
			echo ("2 : Add Bird Feeder");
			echo ("3 : Remove Bird Feeder");

			response = scanin.nextLine();
			
			switch (response) {
			
				case "0" :
					break;
				case "1" :
					List<FullJoin> all = gardenaccountservice.getAllAccounts();
					displayUtil.displayFullGroveTreeInfo(all);
					break;
				case "2" :
					feeders = promptUtil.addBirdFeedersPrompt();
					gardenaccountservice.addBirdFeeders(fulljoin, feeders);
					break;
				case "3" :
					feeders = promptUtil.removeBirdFeedersPrompt();
					gardenaccountservice.removeBirdFeeders(fulljoin, feeders);
					break;
				
			
			} // << End Switch Case
			
		} // << End While Loop
	
	}
	
	public void echo(String toprint) {
	
		System.out.println(toprint);
	
	}

}
