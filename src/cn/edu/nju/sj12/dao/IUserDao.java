package cn.edu.nju.sj12.dao;

import cn.edu.nju.sj12.model.User;

/**
 * 
 * @author ShenJie
 *
 * Code Every Day
 */

public interface IUserDao {
	public void addUser(User user);
	public void deleteUser(String id);
	public User getUser(String id);
	public void updateUser(User user);
}
