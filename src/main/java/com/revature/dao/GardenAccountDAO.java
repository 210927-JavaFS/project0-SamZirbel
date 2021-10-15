package com.revature.dao;

import java.util.List;

import com.revature.models.FullJoin;
import com.revature.models.GardenAccount;

public interface GardenAccountDAO {

	public boolean createAccount(String firstname, String lastname);
	
	public List<GardenAccount> getAccount(int account);
	
	public boolean updateAccountType(GardenAccount gardenaccount);
	
	public boolean updateAccountType(FullJoin fulljoin);
	
	public boolean updateGardenStatus(FullJoin fulljoin);
	
	public boolean updateUsername(FullJoin fulljoin);
	
	public boolean updatePassword(FullJoin fulljoin);
	
	public boolean updateFirstName(FullJoin fulljoin);
	
	public boolean updateLastName(FullJoin fulljoin);
	
	public boolean updateBirdFeeders(FullJoin fulljoin);
	
	public boolean updateTreeId(FullJoin fulljoin);
	
	public List<GardenAccount> getPendingAccounts();
		
	public boolean removeGardenAccountRow(int account);
	
	public boolean removeLoginRow(int account);
	
	public boolean removeTreeRow(int treeid);
	
	public int createTree();
	
	public List<FullJoin> grabAllAccounts();
	
	public List<FullJoin> viewSingleAccount(int account);
	
}
