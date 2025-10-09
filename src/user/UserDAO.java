package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

/**
 * data access object for user table
 */
public class UserDAO {

	public void insert(int id, String name, String psw, boolean isVip, float balance) {
		String insertSQL = "insert into users values(?, ?, ?, ?, ?)";

		Connection connection = DBHelper.getConnection();
		try {
			PreparedStatement ps = 
					connection.prepareStatement(insertSQL);

			
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, psw);
			ps.setBoolean(4, isVip);
			ps.setFloat(5, balance);
			int result = ps.executeUpdate();
			System.out.println("insert rows " + result);
			
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/*
	 * Tenemos que determinar que input o entradas tenemos que proporcionar
	 *  a este metodo, y que es lo que nos debe devolver como resultado
	 */
	public void update(int id) {
		
		
	}
		
	public User[] findAll() {
		String selectSQL = "select * from users where username = 'Manolo'";
		UserDAO[] users;
		ArrayList<User> userList =
				new ArrayList<User>();
		userList.add(null);
		
;		Connection connection = DBHelper.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(selectSQL);
			
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.last())
				System.out.println("total rows is " + resultSet.getRow());
			System.out.println("rows = " + resultSet.getFetchSize());
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("username");
				boolean isVip = resultSet.getBoolean("isVip");
				String psw = resultSet.getString("psw");
				System.out.println("record > id = " + id + "username = " + name + "isVip" + isVip);
				float balance = resultSet.getFloat("balance");
				userList.add(new User(id, name, psw, isVip, balance));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
		
	}
	
	public User find(int id) {
		
		return null;
	}
	
	public void delete(int id) {
		String deleteSQL = "DELETE FROM users WHERE id = ?";
		Connection conn = DBHelper.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(deleteSQL);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			System.out.println("we have deleted " + result + " rows. ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}