package com.revature.dao;

import java.util.List;

import com.revature.models.Login;

public interface LoginDAO {
	
	public List<Login> findAll();
	
	public Login findUser();
	
	public boolean addUser();

}
