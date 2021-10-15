package com.revature.subservices;

import java.util.ArrayList;
import java.util.List;

public class UpdateUsernameQuerySubservice {

	public static List<String> updateUsernameQuery(){
	
		echo("Initiating Update Username Subservice");
		
		List<String> responses = new ArrayList<>();
		
		echo ("What Is The Old Username To Update?");
		
		responses.add(QueryUsernameSubservice.queryUsername());
		
		echo ("What Is The Over-Writing Username?");
		
		responses.add(QueryUsernameSubservice.queryUsername());
		
		return responses;
	
	}
	
	public static void echo(String toPrint){
	
		System.out.println(toPrint);
	
	}

}
