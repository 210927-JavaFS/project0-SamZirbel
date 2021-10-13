package com.revature.dao;

import java.util.List;

import com.revature.models.Login;

public interface LoginDAO {
	
	public List<Login> listAllUsers();
	
	public Login findUser();
	
	public boolean addUser(String username, String password);
	
	public boolean deleteUser(String username);

}
