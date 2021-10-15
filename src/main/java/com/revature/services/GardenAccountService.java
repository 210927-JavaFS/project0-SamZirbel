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
	
		int feedersinfrom = from.getBirdfeeders();
		
		int transferring = (feedersinfrom - feeders >= 0) ?
			feedersinfrom - feeders : feedersinfrom;
			
		addBirdFeeders(to, transferring);
		removeBirdFeeders(from, transferring);
		
		return true;
		
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
	
		List<FullJoin> result =  gardenaccountdao.grabAllAccounts();
	
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
