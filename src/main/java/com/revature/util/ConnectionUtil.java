package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// VV Connection Is Our Interface
	public static Connection getConnection() throws SQLException {
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

		}
		
		// VV Port 5432 : Default Postgresql Port
		// VV Database Name At End Of URL Needs To Be The One You Are Linking To
		// VV Database : forrestgame_project0
		String url = "jdbc:postgresql://javafs-210927-sz.ctjhaliedh90.us-east-2.rds.amazonaws.com:5432/forrestgame_project0";
		
		// VV Workaround So Password Not Displayed On Github
		// VV Use Environment Variables TO Hide Things
		// VV Access With System.getenv("<Name>") Or System.getenv("<Password>")
		String username = "postgres";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
				
	}

}
