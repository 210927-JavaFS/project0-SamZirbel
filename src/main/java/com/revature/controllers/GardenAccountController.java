package com.revature.controllers;

import java.util.Scanner;

import com.revature.services.GardenAccountService;
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
		
			response = "0";
		
		}
		
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
			
			}
			
			
		
		}
	
	}
	
	public void echo(String toprint) {
	
		System.out.println(toprint);
	
	}

}
