package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

/**
 * data access object for user table
 */
public class UserDAO implements UserDaoInterface {

	public void insert(int id, String name, String psw, boolean isVip, float balance) {
		String insertSQL = "insert into users values(?, ?, ?, ?, ?)";

		Connection connection = DBHelper.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(insertSQL);

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
	 * Tenemos que determinar que input o entradas tenemos que proporcionar a este
	 * metodo, y que es lo que nos debe devolver como resultado
	 */
	public void update(int id) {

	}

	public ArrayList<User> findAll() {
		String selectSQL = "select * from users where username = 'Manolo'";
		UserDAO[] users;
		ArrayList<User> userList = new ArrayList<User>();

		;
		Connection connection = DBHelper.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(selectSQL);

			ResultSet resultSet = ps.executeQuery();
//			if(resultSet.last())
//				System.out.println("total rows is " + resultSet.getRow());
//			System.out.println("rows = " + resultSet.getFetchSize());

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("username");
				boolean isVip = resultSet.getBoolean("isVip");
				String psw = resultSet.getString("psw");
				System.out.println("record > id = " + id + "username = " + name + "isVip" + isVip);
				float balance = resultSet.getFloat("balance");
				userList.add(new User(id, name, psw, isVip, balance));

			}

			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public User find(int id) {

		String selectSQLS = "select * from users where id = ? ";

		Connection connection = DBHelper.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(selectSQLS);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				String name = resultSet.getString("username");
				boolean isVIP = resultSet.getBoolean("isVIP");
				String psw = resultSet.getString("psw");
				System.out.println("record > id = " + "username = " + name + "is");
				float balance = resultSet.getFloat("balance");
				return new User(id, name, psw, isVIP, balance);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

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

	public boolean transfer(long FromUserId, long toUserId, float amount) {
		if(amount < 0) {
			System.out.println("the amount can not be negative");
			return false ;
		}
		
		
		String updSQL1 = 
				"UPDATE users SET balance = balance - " + amount + " where id = " + FromUserId + " and balance >= " + amount;

		String updSQL2 = 
				"UPDATE users SET balance = balance + " + amount + " where id = " + toUserId;

		try (Connection connection = DBHelper.getConnection();) {
			PreparedStatement ps = connection.prepareStatement(updSQL1);
			int rowsUpdated = ps.executeUpdate();
			System.out.println("rows updated = " + rowsUpdated);
			if(rowsUpdated > 0) {
				ps = connection.prepareStatement(updSQL2);
				rowsUpdated = ps.executeUpdate();
				System.out.println("rows updated = " + rowsUpdated);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public int insertAll(User[] users) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean transferWithBatch(long fromUserId, long toUserId, float amount) {

		String updSQL1 = "UPDATE users SET balance = balance - " + amount + " where id = " + fromUserId
				+ " and balance > " + amount;

		String updSQL2 = "UPDATE users SET balance = balance + " + amount + " where id = " + toUserId;

		try (Connection connection = DBHelper.getConnection();) {
			Statement st = connection.createStatement();

			st.addBatch(updSQL1);

			st.addBatch(updSQL2);

			st.executeBatch();

		} catch (Exception e) {

		}

		return false;

	}
}