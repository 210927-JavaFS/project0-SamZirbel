package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				+ "SELECT * "
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
	public List<Login> findUser(String username) {

		try(Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "SELECT * "
				+ "FROM login "
				+ "WHERE username = ?;"
				;
			
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, username);
			
			ResultSet result = preparedstatement.executeQuery();
			
			List<Login> matchingUsers = new ArrayList<>();
			
			while (result.next()) {
			
				Login login = new Login(
					result.getString("username"),
					result.getString("userpassword")
					);
					
					matchingUsers.add(login);
			
			}
			
			return matchingUsers;
			
		
		}
		catch (SQLException e){
		
			e.printStackTrace();
		
		}

		return null;
		
	}
	
	@Override
	public List<Login> getPassword(String username) {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql = 
				""
				+ "SELECT userpassword "
				+ "FROM login "
				+ "WHERE username = ?;"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, username);
			
			ResultSet result = preparedstatement.executeQuery();
			
			List<Login> passwordQuery = new ArrayList<>();
			
			while (result.next()) {
			
				Login login = new Login(
					username,
					result.getString("userpassword")
					);
					
				passwordQuery.add(login);
			
			}
			
			return passwordQuery;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return null;
	
	}

	@Override
	public boolean addUser(String username, String password) {
		
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "INSERT INTO login(username, userpassword) "
				+ "VALUES (?, ?);"
				;
				
				PreparedStatement preparedstatement = connect.prepareStatement(sql);
				
				preparedstatement.setString(1, username);
				preparedstatement.setString(2, password);
				
				preparedstatement.execute();
				
				return true;
				
		
		}
		catch (SQLException e){
		
			e.printStackTrace();
		
		}
		
		return false;
		
	}

	@Override
	public boolean deleteUser(String username) {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql = 
				""
				+ "DELETE FROM login "
				+ "WHERE (username = ?);"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, username);
			
			preparedstatement.execute();
			
			return true;
		
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
			
		}
	
		return false;
		
	}
	
	@Override
	public boolean updateUsername(String oldUsername, String newUsername) {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "UPDATE login "
				+ "SET username = ? "
				+ "WHERE username = ?;"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, newUsername);
			preparedstatement.setString(2, oldUsername);
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
	
	}
	
	
	public boolean updatePassword(String username, String password) {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "UPDATE login "
				+ "SET userpassword = ? "
				+ "WHERE username = ?;"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, password);
			preparedstatement.setString(2, username);
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
			
		}
	
		return false;
	
	}
	
	
}
