package db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {

	static String dbURL = "jdbc:mysql://localhost:3306/test";
	static String username = "root";
	static String password = "Admin";

	private static HikariDataSource dataSource;

	public static void main(String[] args) {
		HikariConfig config = new HikariConfig();
		config.setUsername(username);
		config.setJdbcUrl(dbURL);
		config.setPassword(password);
		config.setMaximumPoolSize(20);
		
		dataSource = new HikariDataSource(config);
		
	}

}
