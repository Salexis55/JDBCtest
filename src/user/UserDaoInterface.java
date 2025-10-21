package user;

import model.User;

public interface UserDaoInterface {

	
	
	public int insertAll(User[] users); 
		
	/**
	 * 
	 * @param fromUserId
	 * @param toUserId
	 * @param amount
	 * @return
	 */
	
	
	public boolean transfer(long fromUserId, long toUserId, float amount);
	
	/**
	 * 
	 * @param fromUserId
	 * @param toUserId
	 * @param amount
	 * @return
	 */
	
	
	public boolean transferWithBatch(long fromUserId, long toUserId, float amount);
}
