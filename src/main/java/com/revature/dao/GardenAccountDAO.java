package com.revature.dao;

import java.util.List;

import com.revature.models.GardenAccount;

public interface GardenAccountDAO {

	public boolean createAccount(String firstname, String lastname);
	
	public List<GardenAccount> getAccount(int account);
	
	public List<GardenAccount> getPendingAccounts();
	
	public boolean approvalDecision(int account, String decision);
	
	public boolean deleteDeniedAccounts();
	
	public boolean provideTrees();

}
