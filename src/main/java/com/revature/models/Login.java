package com.revature.models;

public class Login {
	
	private String username;
	
	private String password;
	
	public Login() {
	
		super();
		
		this.username = "Undefined";
		this.password = "Undefined";

	}
	
	public Login(String username, String password) {
		
		super();
		
		this.username = username;
		
		this.password = password;
		
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
	
	@Override
	public String toString() {
	
		return "Login >> ["
				+ "username : " + this.getUsername() + ", "
				+ "password : " + this.getPassword()
				+ "]";
	
	}

}