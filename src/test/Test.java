
package test;

import model.User;

/**
 * @author [Manolo Peng]
 * Sep 9, 2025
 */
public class Test {

	public static void main(String[] args) {
		System.out.println(1);
		User user1 = new User();
		User user2 = new User();
		System.out.println(1);
		System.out.println(user1);
		System.out.println(user2.username);
		System.out.println(user2);
		user1.setUsername("Catalina");
		System.out.println(user2.getUsername());
		User user3 =  new User(234, "manolo", "manolo", false, 0);
		System.out.println(user3.getPsw());
		
		
	}
}


