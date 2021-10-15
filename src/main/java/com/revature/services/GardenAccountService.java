package com.revature.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.GardenAccountDAO;
import com.revature.dao.GardenAccountDAOImpl;
import com.revature.models.FullJoin;
import com.revature.models.GardenAccount;
import com.revature.util.encryptDecryptUtil;

public class GardenAccountService {

	private GardenAccountDAO gardenaccountdao = new GardenAccountDAOImpl();
	
	private static Logger Log = LoggerFactory.getLogger(LoginService.class);
	
	//MDC.put("GardenAccountService", "1");
	
	public String getAccountType(int account) {
	
		List<GardenAccount> accountquery = gardenaccountdao.getAccount(account);
		
		Log.debug("Account Type Query Returning");
		
		return accountquery.get(0).getAccounttype();
	
	}
	

	public boolean updateAccountType(int account, String accounttype) {
	
		if(!checkForValidAccount(account)) { return false; }
	
		List<GardenAccount> accountquery = gardenaccountdao.getAccount(account);
		
		GardenAccount activeaccount = accountquery.get(0);
		
		activeaccount.setAccounttype(accounttype);
		
		System.out.println(activeaccount.getAccounttype());
		
		Log.info("Account Type Has Been Set To : " + accounttype + " For account : " + account);
		
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
	
		Log.debug("Username Updated");
	
		return gardenaccountdao.updateUsername(fulljoin);
	
	}
	
	public boolean updatePassword(FullJoin fulljoin) {
	
		String passworddecrypted = fulljoin.getUserpassword();
		
		String passwordencrypted = encryptDecryptUtil.encryptDecrypt(passworddecrypted);
		
		Log.debug("Password Successfully Encrypted For Database Update");
		
		fulljoin.setUserpassword(passwordencrypted);
	
		Log.debug("Password Updated");
	
		return gardenaccountdao.updatePassword(fulljoin);
		
	}
	
	public boolean updateFirstName(FullJoin fulljoin) {
	
		Log.debug("First Name Updated");
	
		return gardenaccountdao.updateFirstName(fulljoin);
		
	}
	
	public boolean updateLastName(FullJoin fulljoin) {
	
		Log.debug("Last Name Updated");
	
		return gardenaccountdao.updateLastName(fulljoin);
		
	}
	
	public boolean checkForValidAccount(int account) {
	
		List<FullJoin> all = getAllAccounts();
		
		// VV Duplicate Check FOr New Users
		for (FullJoin fj : all) {
		
			if (fj.getAccount() == account) {
			
			
				return true;
			
			}
		
		}
		
		System.out.println("That Account Does Not Exist Please Try Again");
		
		return false;
	
	
	}
	
	public boolean updateGardenStatus(int account, String decision) {
	
		if(!checkForValidAccount(account)) { return false; }
	
		FullJoin updating = getAccountFullJoin(account);
		
		String newtype = (decision.equals("Approved")) ? "Sponsor" : "Denied";
		
		updating.setAccounttype(newtype);
		
		String newstatus = (newtype.equals("Sponsor")) ? "Approved" : "Denied";
		
		updating.setGardenstatus(newstatus);
				
		boolean one = gardenaccountdao.updateAccountType(updating);
		boolean two = gardenaccountdao.updateGardenStatus(updating);
		
		Log.debug("Garden Status Updated For Account : " + account + " To : " + newstatus);
		
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
		
			Log.warn("Notice That More Items Were Asked To Move Than Possible");
		
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
			
				Log.debug("Account : " + accountnumber + " Deleted");
			
			}
		
		}
	
		return (one && two);
	
	}
	
	public boolean deleteActiveAccount(int account) {
	
		if(!checkForValidAccount(account)) { return false; }
	
		FullJoin prompt = getAccountFullJoin(account);
		
		int treeid = 0;
		
		if (!prompt.getAccounttype().equals("Denied")) {
		
			treeid = prompt.getTreeid();
		
			gardenaccountdao.removeLoginRow(account);
			
			gardenaccountdao.removeGardenAccountRow(account);
			
			gardenaccountdao.removeTreeRow(treeid);
			
			Log.debug("Account : " + account + " Deleted");
			
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
		
		Log.debug("Trees Have Been Populated");
	
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
