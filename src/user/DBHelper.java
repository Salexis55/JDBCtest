package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	static String dbURL = "jdbc:mysql://localhost:3306/test";
	static String username = "root";
	static String password = "Admin";

	static Connection getConnection() {

		try {
			return DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
