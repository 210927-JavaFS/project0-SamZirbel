package com.revature.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.revature.dao.GardenAccountDAO;
import com.revature.dao.GardenAccountDAOImpl;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.models.Login;
import com.revature.util.encryptDecryptUtil;

public class LoginService {

	private LoginDAO logindao = new LoginDAOImpl();
	private GardenAccountDAO gardenaccountdao = new GardenAccountDAOImpl();
	
	private static Logger Log = LoggerFactory.getLogger(LoginService.class);
	
	
	
	public boolean createAccount(String username, String password, String firstname, String lastname) {
		
		String passwordencrypted = encryptDecryptUtil.encryptDecrypt(password);
		
		boolean one = gardenaccountdao.createAccount(firstname, lastname);
		boolean two = logindao.addUser(username, passwordencrypted);
		
		Log.info("New User Created : " + username);
		
		MDC.put(username, "User CreateD");
		
		return (one && two);
				
	}
	
	public boolean logIn(String username, String password) {
	
		List<Login> userLookup = logindao.findUser(username);
				
		if (userLookup.size() == 0 || userLookup.size() > 1) {
		
			Log.warn("User In Database Multiple Times Or Not At All : " + username);
		
			return false;
			
		}
		
		Login user = userLookup.get(0);
		
		String passwordencrypted = user.getPassword();
		
		//System.out.println(passwordencrypted);
		
		String passworddecrypted = encryptDecryptUtil.encryptDecrypt(passwordencrypted);
		
		Log.debug("Password Decripted For Login Comparison");
		
		//System.out.println(passworddecrypted);
		
		if (passworddecrypted.equals(password)) {
		
			Log.info("Successfully Logged In : " + username);
		
			return true;
			
		}
		
		return false;
	
	}
	
	public int getAccount(String username) {
	
		List<Login> user = logindao.findUser(username);
				
		return user.get(0).getAccount();
	
	}
	
	
	
	
	public List<Login> listAllUsers(){
	
		return logindao.listAllUsers();
	
	}
	

}
