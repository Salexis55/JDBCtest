package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ForkJoinPool;

public class ConnectinTest {

	public static void main(String[] args) throws SQLException {

		String dbURL = "jdbc:mysql://localhost:3306/test";
		
		String username = "root";
		String password = "Admin";

		DriverManager driverManager;
		//creamos una conexion con la base de datos mysql
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		System.out.println(connection);
		
		
		
		Connection[] connections = new Connection[1000];
		
		for (int i = 0; i < connections.length; i++) {
		
		}
		
	}
	
	
}
