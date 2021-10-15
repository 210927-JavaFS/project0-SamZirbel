package com.revature.models;

public class Login {
	
	private String username;
	
	private String password;
	
	private int account;
	
	public Login() {
	
		super();
		
		this.username = "Undefined";
		this.password = "Undefined";
		this.account = -1;

	}
	
	public Login(String username, String password, int account) {
		
		super();
		
		this.username = username;
		
		this.password = password;
		
		this.account = account;
		
	}
	
	public String getUsername() {
		
		return this.username;
		
	}
	
	public void setUsername(String username) {
		
		this.username = username;
		
	}
	
	public String getPassword() {
		
		return this.password;
		
	}
	
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	public int getAccount() {
	
		return this.account;
		
	}
	
	public void setAccount(int account) {
	
		this.account = account;
	
	}
	
	@Override
	public String toString() {
	
		return "Login >> ["
				+ "username : " + this.getUsername() + ", "
				+ "password : " + this.getPassword() + ", "
				+ "account : " + this.getAccount()
				+ "]";
	
	}

}
