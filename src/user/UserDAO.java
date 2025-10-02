package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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