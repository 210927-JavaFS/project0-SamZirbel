package com.revature.dao;

import java.util.List;

import com.revature.models.Login;

public interface LoginDAO {
	
	// VV Lists All Users Stored Within The Application
	public List<Login> listAllUsers();
	
	// VV Finds Users Whom Match the Given Username
	// VV SHould Only Return One User As username Is A Primary Key
	public List<Login> findUser(String username);
	
	public List<Login> getPassword(String username);
	
	// VV Adds A New User To The Database
	public boolean addUser(String username, String password);
	
	// VV Removes A User From The Database
	public boolean deleteUser(String username);
	
	public boolean updateUsername(String oldUsername, String newUsername);
	
	public boolean updatePassword(String username, String newPassword);

}
