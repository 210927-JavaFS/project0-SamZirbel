package com.revature.subservices;

import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;

public class ObtainPasswordSubservice {

	private static LoginDAO logindao = new LoginDAOImpl();
	
	public static String obtainPassword(String username){
	
		return logindao.getPassword(username).get(0).getPassword();
	
	}

}
