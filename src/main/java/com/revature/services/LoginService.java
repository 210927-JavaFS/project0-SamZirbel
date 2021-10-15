package com.revature.services;

import java.util.List;

import com.revature.dao.GardenAccountDAO;
import com.revature.dao.GardenAccountDAOImpl;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.models.Login;
import com.revature.util.encryptDecryptUtil;

public class LoginService {

	private LoginDAO logindao = new LoginDAOImpl();
	private GardenAccountDAO gardenaccountdao = new GardenAccountDAOImpl();
	
	
	public boolean createAccount(String username, String password, String firstname, String lastname) {
		
		String passwordencrypted = encryptDecryptUtil.encryptDecrypt(password);
		
		boolean one = gardenaccountdao.createAccount(firstname, lastname);
		boolean two = logindao.addUser(username, passwordencrypted);
		
		return (one && two);
				
	}
	
	public boolean logIn(String username, String password) {
	
		List<Login> userLookup = logindao.findUser(username);
				
		if (userLookup.size() == 0 || userLookup.size() > 1) {
		
			return false;
			
		}
		
		Login user = userLookup.get(0);
		
		String passwordencrypted = user.getPassword();
		
		//System.out.println(passwordencrypted);
		
		String passworddecrypted = encryptDecryptUtil.encryptDecrypt(passwordencrypted);
		
		//System.out.println(passworddecrypted);
		
		if (passworddecrypted.equals(password)) {
		
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
