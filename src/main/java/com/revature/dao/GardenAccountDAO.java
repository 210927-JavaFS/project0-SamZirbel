package com.revature.dao;

import java.util.List;

import com.revature.models.FullJoin;
import com.revature.models.GardenAccount;

public interface GardenAccountDAO {

	public boolean createAccount(String firstname, String lastname);
	
	public List<GardenAccount> getAccount(int account);
	
	public boolean updateAccountType(GardenAccount gardenaccount);
	
	public boolean updateUsername(FullJoin fulljoin);
	
	public boolean updatePassword(FullJoin fulljoin);
	
	public boolean updateFirstName(FullJoin fulljoin);
	
	public boolean updateLastName(FullJoin fulljoin);
	
	public boolean updateBirdFeeders(FullJoin fulljoin);
	
	public List<GardenAccount> getPendingAccounts();
	
	public boolean approvalDecision(int account, String decision);
	
	public boolean deleteDeniedAccounts();
	
	public boolean provideTrees();
	
	public List<FullJoin> grabAllAccounts();
	
	public List<FullJoin> viewSingleAccount(int account);
	
	public boolean addBirdFeeder(int account);
	
	public boolean removeBirdFeeder(int account);
	
}
