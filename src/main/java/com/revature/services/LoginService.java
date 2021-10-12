package com.revature.services;

import java.util.List;

import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.models.Login;

public class LoginService {

	private LoginDAO logindao = new LoginDAOImpl();
	
	public List<Login> listAllUsers(){
	
		return logindao.listAllUsers();
	
	}

}
