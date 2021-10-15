package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.FullJoin;
import com.revature.services.GardenAccountService;
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
				SponsorStartup();
				break;
		
		}
	
	}

	public void SponsorStartup() {
	
		echo("Congratulations! Successful Login!");

		String response = "A";
		
		
		
		while (!response.equals("0")){
		
			echo ("What Account Function Would You Like To Access?");
			
			echo ("0 : logout");
			echo ("6 : Add Another Bird Feeder To A Sponsor Account's Tree");
			echo ("7 : Remove Bird Feeder From A Sponsor Account's Tree");
			echo ("8 : Transfer Bird Feeders Between Two Account's Trees");
		
			response = scanin.nextLine();
			
			switch (response) {
			
				case "0" :
					break;
				case "1" :
					gardenaccountservice.viewPendingAccounts();
					break;
				case "2" :
					int account = queryUtil.queryAccount();
					String decision = queryUtil.queryApprovalDecision();
					gardenaccountservice.approvalDecision(account, decision);
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
					int account6 = queryUtil.queryAccount();
					gardenaccountservice.addBirdFeeder(account6);
					break;
				case "7" :
					account = queryUtil.queryAccount();
					gardenaccountservice.removeBirdFeeder(account);
					break;
				case "8" :
					account = queryUtil.queryAccount();
					int account2 = queryUtil.queryAccount();
					gardenaccountservice.transferBirdFeeder(account, account2);
					break;
			
			} // << End Switch Case
			
		} // << End While Loop
		
	}
	
	public void EmployeeStartup() {
	
		echo("Welcome Employee! Successful Login!");
		
		
	
	}
	
	public void OwnerStartup() {
	
		echo("Welcome Botanical Garden Owner! Successful Login!");

		String response = "A";
		
		while (!response.equals("0")){
		
			echo ("What Account Function Would You Like To Access?");
			
			echo ("0 : logout");
			echo ("1 : View Pending Accounts");
			echo ("2 : Approval / Denial Of Prospective Accounts");
			echo ("3 : Delete Denied Accounts");
			echo ("4 : Provide Trees To Newly Approved");
			echo ("5 : View All Account Information");
			echo ("6 : Add Another Bird Feeder To A Sponsor Account's Tree");
			echo ("7 : Remove Bird Feeder From A Sponsor Account's Tree");
			echo ("8 : Transfer Bird Feeders Between Two Account's Trees");
			echo ("9 : Set Account Type");
			echo ("10: Update Account");
		
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
					gardenaccountservice.approvalDecision(account, decision);
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
					int account6 = promptUtil.accountNumberSingularPrompt();
					gardenaccountservice.addBirdFeeder(account6);
					break;
				case "7" :
					account = promptUtil.accountNumberSingularPrompt();
					gardenaccountservice.removeBirdFeeder(account);
					break;
				case "8" :
					account = promptUtil.accountNumberSingularPrompt();
					int account2 = promptUtil.accountNumberSingularPrompt();
					gardenaccountservice.transferBirdFeeder(account, account2);
					break;
				case "9" :
					account = promptUtil.accountNumberSingularPrompt();
					String accounttype = promptUtil.accountTypeResetPrompt();
					gardenaccountservice.updateAccountType(account, accounttype);
					break;
				case "10" :
					staffUpdateAccountUI();
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
					update = promptUtil.updateUsernamePrompt();
					fulljoin.setUsername(update);
					gardenaccountservice.updateUsername(fulljoin);
					break;
				case "3" :
					update = promptUtil.updatePasswordPrompt();
					fulljoin.setUserpassword(update);
					gardenaccountservice.updatePassword(fulljoin);
					break;
				case "4" :
					update = promptUtil.updateFirstNamePrompt();
					fulljoin.setFirstname(update);
					gardenaccountservice.updateFirstName(fulljoin);
					break;
				case "5" :
					update = promptUtil.updateLastNamePrompt();
					fulljoin.setLastname(update);
					gardenaccountservice.updateLastName(fulljoin);
					break;
			
			} // << End Switch Case
			
		} // << End While Loop
	
	}
	
	public void echo(String toprint) {
	
		System.out.println(toprint);
	
	}

}
