package com.revature.services;

import java.util.List;

import com.revature.dao.GardenAccountDAO;
import com.revature.dao.GardenAccountDAOImpl;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.models.GardenAccount;
import com.revature.models.Login;
import com.revature.subservices.ObtainPasswordSubservice;
import com.revature.subservices.QueryPasswordSubservice;
import com.revature.subservices.QueryUsernameSubservice;
import com.revature.subservices.UpdateUsernameQuerySubservice;
import com.revature.subservices.UserCredentialSubservice;
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
		
		System.out.println(passwordencrypted);
		
		String passworddecrypted = encryptDecryptUtil.encryptDecrypt(passwordencrypted);
		
		System.out.println(passworddecrypted);
		
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
	
	public List<Login> findUser() {
	
		String username = QueryUsernameSubservice.queryUsername();
	
		return logindao.findUser(username);
	
	}
	
	public int getPassword() {
	
		String username = QueryUsernameSubservice.queryUsername();
		
		if (logindao.findUser(username).size() == 0) {
		
			return 0;
		
		}
		
		List<Login> result = logindao.getPassword(username);
		
		// VV May Be A Redundant Thought
		// VV If No Result Login Is Found It Was Not WIthin Database
		if (result.size() == 0) {
		
			return 2;
		
		}
		// VV Password Gotten Sucessfully
		else {
		
			return 1;
		
		}
	
	}
	
	// VV For This Function The THought Process Was
	// VV The DAO Should Purely Be Concerned With SQL Code
	// VV Menu Should Only Have To Run A Method To Initiate Functionality
	// VV Controller Should Deal With Front End System Output
	// VV THe Service Should Therefore Run Methods To Obtain Data Relevant
	// VV    To The Running Of The SQL Command In The DAO
	public boolean addUser(){
	
		Login user = UserCredentialSubservice.getCredentials();
		
		// VV CHeck If Username Is Taken Already - If So We Return False
		if (logindao.findUser(user.getUsername()).size() > 0) {
		
			return false;
			
		}
		// VV Otherwise Add The User
		else { 
	
			return logindao.addUser(user.getUsername(), user.getPassword());
			
		}
	
	}
	
	public boolean deleteUser() {
	
		String username = QueryUsernameSubservice.queryUsername();
		
		// VV Cannot Delete Users Not In Database
		if (logindao.findUser(username).size() == 0){
		
			return false;
			
		}
		// VV Else Delete User
		else {
		
			return logindao.deleteUser(username);
			
		}
	
	}
	
	public int updateUsername() {
	
		List<String> responses = UpdateUsernameQuerySubservice.updateUsernameQuery();
		
		// VV If Both Usernames Provided Match
		// VV Old Username == New Username
		// VV Return 0 : Failed
		if (responses.get(0).equals(responses.get(1))){
		
			return 0;
			
		}
		// VV If The Updating Name Is Already Within The Database
		// VV Return 2 : Multiple Instances Of Username In Database
		else if (logindao.findUser(responses.get(1)).size() > 0) {
			
				return 2;
			
		}
		// VV If Username We Are Trying To Update Is Not Within THe Datbase
		// VV Return 3 : Theerees No Username To Update
		else if (logindao.findUser(responses.get(0)).size() == 0) {
		
			return 3;
		
		}	
		// VV Otherwise Update The Username
		// VV Return 1 : True Update
		// VV Return 1 : Only 1 Instance Of Username In Database
		else {
		
			logindao.updateUsername(responses.get(0), responses.get(1));
			
			return 1;
				
		}
		
	}
	
	public int updatePassword() {
	
		String username = QueryUsernameSubservice.queryUsername();
		String password = QueryPasswordSubservice.queryPassword();
		
		// VV If User Is Not Found In Database Return 0
		if (logindao.findUser(username).size() == 0) {
		
			return 0;
			
		}
		// VV If Current Password Is The Same As The Previous Password
		else if (ObtainPasswordSubservice.obtainPassword(username).equals(password)) {
		
			return 2;
		
		}
		// VV Successfully Updated Password
		else {
		
			logindao.updatePassword(username, password);
			
			return 1;
			
		}
	
	}

}
