package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
	String dbURL = "jdbc:mysql://localhost:3306/test";
	String username = "root";
	String password = "Admin";
	
	
	Connection getConnection() {
		try {
			return DriverManager.getConnection(dbURL, username, password);
			
		}
	}
	
	
	
	
	
	
	
}
