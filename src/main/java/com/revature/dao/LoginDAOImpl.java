package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Login;
import com.revature.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public List<Login> listAllUsers() {

		try (Connection connect = ConnectionUtil.getConnection()){
			
			String sql =
				""
				+ "SELECT *"
				+ "FROM login;"
				;
				
			Statement sender = connect.createStatement();
			
			ResultSet result = sender.executeQuery(sql);
			
			List<Login> logins = new ArrayList<>();
			
			while (result.next()) {
			
				Login login = new Login(
					result.getString("username"),
					result.getString("userpassword")
				);
				
				logins.add(login);
			
			}
			
			return logins;
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
	}

	@Override
	public Login findUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser() {
		// TODO Auto-generated method stub
		return false;
	}

}
