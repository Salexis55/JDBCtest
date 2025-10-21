package test;

import java.util.ArrayList;

import model.User;
import user.UserDAO;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDAO userDao = new UserDAO();
		//userDAO.insert/0, null, null, false, 34);
		//eliminar un usuario con su id
		//userDAO.delete(1);
		
		ArrayList<User> users = userDao.findAll();
		System.out.println(users.size());
		
		userDao.transfer(1, 0, 1);
	}
}
