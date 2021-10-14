package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.GardenAccount;
import com.revature.util.ConnectionUtil;

public class GardenAccountDAOImpl implements GardenAccountDAO {

	@Override
	public boolean createAccount(String firstname, String lastname) {
		
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "INSERT INTO gardenaccount (firstname, lastname, gardenstatus) "
				+ "VALUES (?, ?, 'pending');"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, firstname);
			preparedstatement.setString(2, lastname);
			
			preparedstatement.execute();
			
			return true;
		
		
		}
		catch (SQLException e){
		
			e.printStackTrace();
		
		}
		
		return false;
		
	}
	
	public List<GardenAccount> getAccount(int account) {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "SELECT * "
				+ "FROM gardenaccount "
				+ "WHERE account = ?;"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setInt(1, account);
			
			ResultSet result = preparedstatement.executeQuery();
			
			List<GardenAccount> queried = new ArrayList<>();
			
			while (result.next()) {
			
				GardenAccount gardenaccount = new GardenAccount(
					result.getInt("account"),
					result.getString("firstname"),
					result.getString("lastname"),
					result.getInt("treeid"),
					result.getString("gardenstatus"),
					result.getString("accounttype")
					);
					
				queried.add(gardenaccount);
			
			}
			
			return queried;
		
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return null;
	
	}
	
	public List<GardenAccount> getPendingAccounts() {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "SELECT * "
				+ "FROM gardenaccount "
				+ "WHERE gardenstatus = 'pending';"
				;
				
			Statement statement = connect.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<GardenAccount> queries = new ArrayList<>();
			
			while (result.next()) {
			
				GardenAccount gardenaccount = new GardenAccount(
					result.getInt("account"),
					result.getString("firstname"),
					result.getString("lastname"),
					result.getInt("treeid"),
					result.getString("gardenstatus"),
					result.getString("accounttype")
					);
						
					queries.add(gardenaccount);
			
			}
			
			return queries;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return null;
	
	}
	
	public boolean approvalDecision(int account, String decision) {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "UPDATE gardenaccount "
				+ "SET gardenstatus = ?, accounttype = ? "
				+ "WHERE account = ?;"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, decision);
			
			String type = "";
			
			if (decision.equals("Approve")) {
			
				type = "Sponsor";
				
			}
			else if (decision.equals("Deny")) {
			
				type = "Denied";
			
			}
			
			preparedstatement.setString(2, type);
			
			preparedstatement.setInt(3, account);
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
			
		}
		
		return false;
	
	}
	
	public boolean deleteDeniedAccounts() {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "SELECT account "
				+ "FROM gardenaccount "
				+ "WHERE gardenstatus = 'Denied';"
				;
				
			Statement statement = connect.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Integer> accounts = new ArrayList<>();

			while (result.next()) {
			
				Integer query = (Integer) result.getInt("account");
						
					accounts.add(query);
			
			}
			
			for (Integer i : accounts) {
			
				sql = ""
					+ "DELETE FROM login "
					+ "WHERE account = ?;"
					;
					
				PreparedStatement preparedstatement = connect.prepareStatement(sql);
				
				preparedstatement.setInt(1, i);
				
				preparedstatement.execute();
				
				sql = ""
					+ "DELETE FROM gardenaccount "
					+ "WHERE account = ?;"
					;
					
				preparedstatement = connect.prepareStatement(sql);
				
				preparedstatement.setInt(1, i);
				
				preparedstatement.execute();
			
			}
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
	
	}



}
