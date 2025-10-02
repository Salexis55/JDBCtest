package model;

/**
 * @author [Manolo Peng] Sep 8, 2025
 */
public class User {

	//
	private long id;
	//
	public String username = "Manolo";
	private String psw;
	private boolean isVIP;
	private float balance;

	/**
	 * constructors
	 */
	public User() {

	}

	public User(long id) {
		this.id = id;
		

	}
	public User(long id, String username, String psw, boolean isVIP, float balance) {
		this.id = id;
		this.username = username;
		this.psw = psw;
		this.isVIP = isVIP;
		this.balance = balance;
	}
	

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPsw() {
		return psw;
	}

	public boolean isVIP() {
		return isVIP;
	}

	public float getBalance() {
		return balance;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public void setVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
