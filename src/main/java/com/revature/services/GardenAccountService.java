package com.revature.services;

import java.util.List;

import com.revature.dao.GardenAccountDAO;
import com.revature.dao.GardenAccountDAOImpl;
import com.revature.models.FullJoin;
import com.revature.models.GardenAccount;
import com.revature.util.encryptDecryptUtil;

public class GardenAccountService {

	private GardenAccountDAO gardenaccountdao = new GardenAccountDAOImpl();
	
	public String getAccountType(int account) {
	
		List<GardenAccount> accountquery = gardenaccountdao.getAccount(account);
		
		return accountquery.get(0).getAccounttype();
	
	}
	

	public boolean updateAccountType(int account, String accounttype) {
	
		List<GardenAccount> accountquery = gardenaccountdao.getAccount(account);
		
		GardenAccount activeaccount = accountquery.get(0);
		
		activeaccount.setAccounttype(accounttype);
		
		System.out.println(activeaccount.getAccounttype());
		
		return gardenaccountdao.updateAccountType(activeaccount);
	
	}
	
	public FullJoin getAccountFullJoin(int account){
	
		List<FullJoin> accountquery = gardenaccountdao.viewSingleAccount(account);
		
		FullJoin result = null;
		
		if (accountquery.size() >= 1) {
		
			result = accountquery.get(0);
			
			String encryptedpassword = result.getUserpassword();
			
			String decryptedpassword = encryptDecryptUtil.encryptDecrypt(encryptedpassword);
			
			result.setUserpassword(decryptedpassword);
		
		}
		
		return result;
	
	}
	
	public List<FullJoin> getAllAccounts() {
	
		List<FullJoin> records = gardenaccountdao.grabAllAccounts();
		
		return records;
	
	}
	
	public boolean updateUsername(FullJoin fulljoin) {
	
		return gardenaccountdao.updateUsername(fulljoin);
	
	}
	
	public boolean updatePassword(FullJoin fulljoin) {
	
		String passworddecrypted = fulljoin.getUserpassword();
		
		String passwordencrypted = encryptDecryptUtil.encryptDecrypt(passworddecrypted);
		
		fulljoin.setUserpassword(passwordencrypted);
	
		return gardenaccountdao.updatePassword(fulljoin);
		
	}
	
	public boolean updateFirstName(FullJoin fulljoin) {
	
		return gardenaccountdao.updateFirstName(fulljoin);
		
	}
	
	public boolean updateLastName(FullJoin fulljoin) {
	
		return gardenaccountdao.updateLastName(fulljoin);
		
	}
	
	public boolean updateGardenStatus(int account, String decision) {
	
		FullJoin updating = getAccountFullJoin(account);
		
		String newtype = (decision.equals("Approved")) ? "Sponsor" : "Denied";
		
		updating.setAccounttype(newtype);
		
		String newstatus = (newtype.equals("Sponsor")) ? "Approved" : "Denied";
		
		updating.setGardenstatus(newstatus);
				
		boolean one = gardenaccountdao.updateAccountType(updating);
		boolean two = gardenaccountdao.updateGardenStatus(updating);
		
		return (one && two);
		
	
	}
	
	public boolean addBirdFeeders(FullJoin fulljoin, int feeders) {
	
		int currentfeeders = fulljoin.getBirdfeeders();
		
		currentfeeders += feeders;
		
		fulljoin.setBirdfeeders(currentfeeders);
	
		return gardenaccountdao.updateBirdFeeders(fulljoin);
	
	}
	
	public boolean removeBirdFeeders(FullJoin fulljoin, int feeders) {
	
		int currentfeeders = fulljoin.getBirdfeeders();
		
		if (feeders >= currentfeeders) {
		
			currentfeeders = 0;
		
		}
		else {
		
			currentfeeders -= feeders;
		
		}
		
		fulljoin.setBirdfeeders(currentfeeders);
		
		return gardenaccountdao.updateBirdFeeders(fulljoin);
	
	}
	
	public boolean transferManyBirdFeeders(FullJoin from, FullJoin to, int feeders) {
	
		int feedersfrom = from.getBirdfeeders();
		
		int transferring = (feedersfrom - feeders >= 0) ?
			feeders : feedersfrom;
			
		addBirdFeeders(to, transferring);
		removeBirdFeeders(from, transferring);
		
		return true;
		
	}
	
	public int countPendingAccounts() {
	
		List<GardenAccount> pendings = gardenaccountdao.getPendingAccounts();
		
		return pendings.size();
		
	}
	
	public void viewPendingAccounts() {
	
		List<GardenAccount> pendings = gardenaccountdao.getPendingAccounts();
		
		for (GardenAccount ga : pendings) {
		
			System.out.println(ga);
		
		}
	
	}
	
	public boolean deleteDeniedAccounts() {
	
		List<FullJoin> all = gardenaccountdao.grabAllAccounts();
		
		int accountnumber;
		
		boolean one = true;
		boolean two = true;
		
		for (FullJoin fj : all) {
		
			if (fj.getGardenstatus().equals("Denied")) {
			
				accountnumber = fj.getAccount();
				
				one = gardenaccountdao.removeLoginRow(accountnumber);
				two = gardenaccountdao.removeGardenAccountRow(accountnumber);
			
			}
		
		}
	
		return (one && two);
	
	}
	
	public boolean deleteActiveAccount(int account) {
	
		FullJoin prompt = getAccountFullJoin(account);
		
		int treeid = 0;
		
		if (!prompt.getAccounttype().equals("Denied")) {
		
			treeid = prompt.getTreeid();
		
			gardenaccountdao.removeLoginRow(account);
			
			gardenaccountdao.removeGardenAccountRow(account);
			
			gardenaccountdao.removeTreeRow(treeid);
			
			return true;
		
		}
		
		return false;
	
	}
	
	public boolean provideTrees() {

		List<FullJoin> all = gardenaccountdao.grabAllAccounts();
		
		boolean one = true;
		
		int treeid = 0;
		
		for (FullJoin fj : all) {
		
			System.out.println(fj.getGardenstatus());
		
			if (fj.getGardenstatus().equals("Approved")) {
			
				treeid = gardenaccountdao.createTree();
				
				fj.setTreeid(treeid);
				
				one = gardenaccountdao.updateTreeId(fj);
			
			}
		
		}
	
		return one;
	}
	
	public boolean viewAllAccounts() {
	
		List<FullJoin> result =  gardenaccountdao.grabAllAccounts();
	
		for (FullJoin fj : result) {
		
			System.out.println(fj);
		
		}
		
		return true;
	
	}

}
