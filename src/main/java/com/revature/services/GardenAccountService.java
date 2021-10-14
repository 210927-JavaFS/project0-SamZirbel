package com.revature.services;

import java.util.List;

import com.revature.dao.GardenAccountDAO;
import com.revature.dao.GardenAccountDAOImpl;
import com.revature.models.FullJoin;
import com.revature.models.GardenAccount;

public class GardenAccountService {

	private GardenAccountDAO gardenaccountdao = new GardenAccountDAOImpl();
	
	public String getAccountType(int account) {
	
		List<GardenAccount> accountquery = gardenaccountdao.getAccount(account);
		
		return accountquery.get(0).getAccounttype();
	
	}
	
	public void viewPendingAccounts() {
	
		List<GardenAccount> pendings = gardenaccountdao.getPendingAccounts();
		
		for (GardenAccount ga : pendings) {
		
			System.out.println(ga);
		
		}
	
	}
	
	public boolean approvalDecision(int account, String decision) {
	
		return gardenaccountdao.approvalDecision(account, decision);
	
	
	}
	
	public boolean deleteDeniedAccounts() {
	
		return gardenaccountdao.deleteDeniedAccounts();
	
	}
	
	public boolean provideTrees() {
	
		return gardenaccountdao.provideTrees();
	
	}
	
	public boolean viewAllAccounts() {
	
		List<FullJoin> result =  gardenaccountdao.viewAllAccounts();
	
		for (FullJoin fj : result) {
		
			System.out.println(fj);
		
		}
		
		return true;
	
	}
	
	public boolean addBirdFeeder(int account) {
	
		return gardenaccountdao.addBirdFeeder(account);
	
	}
	
	public boolean removeBirdFeeder(int account) {
	
		return gardenaccountdao.removeBirdFeeder(account);
	
	}
	
	public boolean transferBirdFeeder(int oldAccount, int newAccount) {
	
		boolean one = gardenaccountdao.removeBirdFeeder(oldAccount);
		boolean two = gardenaccountdao.addBirdFeeder(newAccount);
	
		return (one && two);
	
	}


}
