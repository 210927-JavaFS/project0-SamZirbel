package com.revature.services;

import java.util.List;

import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.models.Login;
import com.revature.subservices.QueryUsernameSubservice;
import com.revature.subservices.UpdateUsernameQuerySubservice;
import com.revature.subservices.UserCredentialSubservice;

public class LoginService {

	private LoginDAO logindao = new LoginDAOImpl();
	
	
	
	
	public List<Login> listAllUsers(){
	
		return logindao.listAllUsers();
	
	}
	
	public List<Login> findUser() {
	
		String username = QueryUsernameSubservice.queryUsername();
	
		return logindao.findUser(username);
	
	}
	
	// VV For This Function The THought Process Was
	// VV The DAO Should Purely Be Concerned With SQL Code
	// VV Menu Should Only Have To Run A Method To Initiate Functionality
	// VV Controller Should Deal With Front End System Output
	// VV THe Service Should Therefore Run Methods To Obtain Data Relevant
	// VV    To The Running Of The SQL Command In The DAO
	public boolean addUser(){
	
		Login user = UserCredentialSubservice.getCredentials();
		
		// VV CHeck If Username Is Taken Already - If So We Return False
		if (logindao.findUser(user.getUsername()).size() > 0) {
		
			return false;
			
		}
		// VV Otherwise Add The User
		else { 
	
			return logindao.addUser(user.getUsername(), user.getPassword());
			
		}
	
	}
	
	public boolean deleteUser() {
	
		String username = QueryUsernameSubservice.queryUsername();
		
		// VV Cannot Delete Users Not In Database
		if (logindao.findUser(username).size() == 0){
		
			return false;
			
		}
		// VV Else Delete User
		else {
		
			return logindao.deleteUser(username);
			
		}
	
	}
	
	public int updateUsername() {
	
		List<String> responses = UpdateUsernameQuerySubservice.updateUsernameQuery();
		
		// VV If Both Usernames Provided Match
		// VV Old Username == New Username
		// VV Return 0 : Failed
		if (responses.get(0).equals(responses.get(1))){
		
			return 0;
			
		}
		// VV If The Updating Name Is Already Within The Database
		// VV Return 2 : Multiple Instances Of Username In Database
		else if (logindao.findUser(responses.get(1)).size() > 0) {
			
				return 2;
			
		}
		// VV If Username We Are Trying To Update Is Not Within THe Datbase
		// VV Return 3 : Theerees No Username To Update
		else if (logindao.findUser(responses.get(0)).size() == 0) {
		
			return 3;
		
		}	
		// VV Otherwise Update The Username
		// VV Return 1 : True Update
		// VV Return 1 : Only 1 Instance Of Username In Database
		else {
		
			logindao.updateUsername(responses.get(0), responses.get(1));
			
			return 1;
				
		}
	}

}
