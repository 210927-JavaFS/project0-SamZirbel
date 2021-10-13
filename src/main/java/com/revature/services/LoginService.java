package com.revature.services;

import java.util.List;

import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.models.Login;
import com.revature.procedures.UserCredentialProcedure;

public class LoginService {

	private LoginDAO logindao = new LoginDAOImpl();
	
	
	
	
	public List<Login> listAllUsers(){
	
		return logindao.listAllUsers();
	
	}
	
	public boolean addUser(){
	
		Login user = UserCredentialProcedure.getCredentials();
	
		return logindao.addUser(user.getUsername(), user.getPassword());
	
	}

}
