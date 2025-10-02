package test;

import user.UserDAO;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDAO userDao = new UserDAO();
		userDao.insert(100, null, null, false, 1);
		//eliminar un usuario con su id
		userDao.delete(100);
	}
}
