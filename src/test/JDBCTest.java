package test;

import java.awt.desktop.UserSessionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

public class JDBCTest {

	public static void main(String[] args) {

		String dbURLString = "jdbc:mysql://localhost:3306/test";

		String username = "root";
		String password = "Admin";

		DriverManager driverManager;
		// creamos una conexion con la base de datos mysql
		Connection connection;
		try {
			connection = DriverManager.getConnection(dbURLString, username, password);
			System.out.println(connection);

			String createSQL = "create table if not exists users(" + "id integer not null," + "username VARCHAR(255),"
					+ "psw VARCHAR(255)," + "isVIP TINYINT(1)," + "balance FLOAT," + "PRIMARY KEY (id)" + "" + ")";
			PreparedStatement ps = connection.prepareStatement(createSQL);
			ps.execute();

			String insertSQL = "insert into users values('1', 'Alejandro', '1234', '0', '12,50')";
			ps = connection.prepareStatement(insertSQL);

			ps.execute();
			
			Delete from users when id =
			String createSQL = "CREATE DATABASE happyending";
			
			String deleteSQL = ""
					
			

			System.out.println(connection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}