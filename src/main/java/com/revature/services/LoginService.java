package com.revature.services;

import java.util.List;

import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.models.Login;
import com.revature.procedures.QueryUsernameProcedure;
import com.revature.procedures.UserCredentialProcedure;

public class LoginService {

	private LoginDAO logindao = new LoginDAOImpl();
	
	
	
	
	public List<Login> listAllUsers(){
	
		return logindao.listAllUsers();
	
	}
	
	// VV For This Function The THought Process Was
	// VV The DAO Should Purely Be Concerned With SQL Code
	// VV Menu Should Only Have To Run A Method To Initiate Functionality
	// VV Controller Should Deal With Front End System Output
	// VV THe Service Should Therefore Run Methods To Obtain Data Relevant
	// VV    To The Running Of The SQL Command In The DAO
	public boolean addUser(){
	
		Login user = UserCredentialProcedure.getCredentials();
	
		return logindao.addUser(user.getUsername(), user.getPassword());
	
	}
	
	public boolean deleteUser() {
	
		String username = QueryUsernameProcedure.queryUsername();
		
		return logindao.deleteUser(username);
	
	}

}
