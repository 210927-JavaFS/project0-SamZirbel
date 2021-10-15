package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.revature.models.FullJoin;
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
	
	public boolean updateAccountType(GardenAccount gardenaccount) {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "UPDATE gardenaccount "
				+ "SET accounttype = ? "
				+ "WHERE account = ?;"
				;
			
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, gardenaccount.getAccounttype());
			
			preparedstatement.setInt(2, gardenaccount.getAccount());
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
	
	}
	
	@Override
	public boolean updateAccountType(FullJoin fulljoin) {

		try (Connection connect = ConnectionUtil.getConnection()) {
			
			String sql =
				""
				+ "UPDATE gardenaccount "
				+ "SET accounttype = ? "
				+ "WHERE account = ?;"
				;
			
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, fulljoin.getAccounttype());
			
			preparedstatement.setInt(2, fulljoin.getAccount());
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
	
	}
	
	@Override
	public boolean updateGardenStatus(FullJoin fulljoin) {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
			
			String sql =
				""
				+ "UPDATE gardenaccount "
				+ "SET gardenstatus = ? "
				+ "WHERE account = ?;"
				;
			
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, fulljoin.getGardenstatus());
			
			preparedstatement.setInt(2, fulljoin.getAccount());
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
	
	}

	@Override
	public boolean updateUsername(FullJoin fulljoin) {

		try (Connection connect = ConnectionUtil.getConnection()) {
			
			String sql =
				""
				+ "UPDATE login "
				+ "SET username = ? "
				+ "WHERE account = ?;"
				;
			
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, fulljoin.getUsername());
			
			preparedstatement.setInt(2, fulljoin.getAccount());
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
		
	}

	@Override
	public boolean updatePassword(FullJoin fulljoin) {

		try (Connection connect = ConnectionUtil.getConnection()) {
			
			String sql =
				""
				+ "UPDATE login "
				+ "SET userpassword = ? "
				+ "WHERE account = ?;"
				;
			
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, fulljoin.getUserpassword());
			
			preparedstatement.setInt(2, fulljoin.getAccount());
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
		
	}

	@Override
	public boolean updateFirstName(FullJoin fulljoin) {
		
		try (Connection connect = ConnectionUtil.getConnection()) {
			
			String sql =
				""
				+ "UPDATE gardenaccount "
				+ "SET firstname = ? "
				+ "WHERE account = ?;"
				;
			
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, fulljoin.getFirstname());
			
			preparedstatement.setInt(2, fulljoin.getAccount());
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
		
	}

	@Override
	public boolean updateLastName(FullJoin fulljoin) {

		try (Connection connect = ConnectionUtil.getConnection()) {
			
			String sql =
				""
				+ "UPDATE gardenaccount "
				+ "SET lastname = ? "
				+ "WHERE account = ?;"
				;
			
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setString(1, fulljoin.getLastname());
			
			preparedstatement.setInt(2, fulljoin.getAccount());
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
		
	}
	
	@Override
	public boolean updateBirdFeeders(FullJoin fulljoin) {

		try (Connection connect = ConnectionUtil.getConnection()) {
			
			String sql =
				""
				+ "UPDATE tree "
				+ "SET birdfeeders = ? "
				+ "WHERE treeid = ?;"
				;
			
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setInt(1, fulljoin.getBirdfeeders());
			
			preparedstatement.setInt(2, fulljoin.getTreeid());
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
		
	}
	
	public boolean updateTreeId(FullJoin fulljoin) {

		try (Connection connect = ConnectionUtil.getConnection()) {
			
			String sql =
				""
				+ "UPDATE gardenaccount "
				+ "SET treeid = ? "
				+ "WHERE account = ?;"
				;
			
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setInt(1, fulljoin.getTreeid());
			
			preparedstatement.setInt(2, fulljoin.getAccount());
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
	
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
	
	public boolean removeGardenAccountRow(int account) {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "DELETE FROM gardenaccount "
				+ "WHERE account = ?;"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setInt(1, account);
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
	
	}
	
	public boolean removeLoginRow(int account) {

		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql =
				""
				+ "DELETE FROM login "
				+ "WHERE account = ?;"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setInt(1, account);
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
	
	}
	
	@Override
	public boolean removeTreeRow(int treeid) {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
			
			String sql =
				""
				+ "DELETE FROM tree "
				+ "WHERE treeid = ?;"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setInt(1, treeid);
			
			preparedstatement.execute();
			
			return true;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return false;
	
	}
	
	@Override
	public int createTree() {
	
		try (Connection connect = ConnectionUtil.getConnection()) {
		
			String sql = 
				""
				+ "INSERT INTO tree (branches, flowers, birdfeeders, plantinggroup) "
				+ "VALUES (?, 0, 1, ?)"
				+ "RETURNING treeid;"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			Random rn = new Random();
				
			int treegroup = rn.nextInt(10) + 1;
			
			int branchcount = rn.nextInt(100) + 10;
			
			preparedstatement.setInt(1, branchcount);
		
			preparedstatement.setInt(2, treegroup);
			
			ResultSet result = preparedstatement.executeQuery();
			
			result.next();
			
			Integer treeid = (Integer) result.getInt("treeid");
					
			return treeid;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return 0;
	
	}
	
	public List<FullJoin> grabAllAccounts(){
	
		try(Connection connect = ConnectionUtil.getConnection()) {
		
			String sql = 
				""
				+ "SELECT * "
				+ "FROM login l "
				+ "FULL JOIN GardenAccount g ON g.account = l.account "
				+ "FULL JOIN tree t ON t.treeid = g.treeid "
				+ "LEFT JOIN plantingdata p ON p.plantinggroup = t.plantinggroup;"
				;
				
			Statement statement = connect.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<FullJoin> query = new ArrayList<>();
			
			while (result.next()) {
			
				FullJoin fulljoin = new FullJoin(
					
					result.getString("username"),
					result.getString("userpassword"),
					result.getInt("account"),
					result.getString("firstname"),
					result.getString("lastname"),
					result.getString("gardenstatus"),
					result.getString("accounttype"),
					result.getInt("treeid"),
					result.getInt("branches"),
					result.getInt("flowers"),
					result.getInt("birdfeeders"),
					result.getString("plantinggroup"),
					result.getInt("yearplanted"),
					result.getInt("monthplanted"),
					result.getInt("dayplanted")
					
				);
				
				query.add(fulljoin);
			
			}
			
			return query;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return null;
	
	}

	public List<FullJoin> viewSingleAccount(int account) {
	

		try(Connection connect = ConnectionUtil.getConnection()) {
		
			String sql = 
				""
				+ "SELECT * "
				+ "FROM login l "
				+ "FULL JOIN GardenAccount g ON g.account = l.account "
				+ "FULL JOIN tree t ON t.treeid = g.treeid "
				+ "LEFT JOIN plantingdata p ON p.plantinggroup = t.plantinggroup "
				+ "WHERE l.account = ?;"
				;
				
			PreparedStatement preparedstatement = connect.prepareStatement(sql);
			
			preparedstatement.setInt(1, account);
			
			ResultSet result = preparedstatement.executeQuery();
			
			List<FullJoin> query = new ArrayList<>();
			
			while (result.next()) {
			
				FullJoin fulljoin = new FullJoin(
					
					result.getString("username"),
					result.getString("userpassword"),
					result.getInt("account"),
					result.getString("firstname"),
					result.getString("lastname"),
					result.getString("gardenstatus"),
					result.getString("accounttype"),
					result.getInt("treeid"),
					result.getInt("branches"),
					result.getInt("flowers"),
					result.getInt("birdfeeders"),
					result.getString("plantinggroup"),
					result.getInt("yearplanted"),
					result.getInt("monthplanted"),
					result.getInt("dayplanted")
					
				);
				
				query.add(fulljoin);
			
			}
			
			return query;
		
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return null;
	
	}



}
