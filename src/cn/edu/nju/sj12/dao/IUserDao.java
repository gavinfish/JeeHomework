package cn.edu.nju.sj12.dao;

import cn.edu.nju.sj12.beans.UserBean;

/**
 * 
 * @author ShenJie
 *
 * Code Every Day
 */

public interface IUserDao {
	public void addUser(UserBean user);
	public void deleteUser(String id);
	public UserBean getUser(String id);
	public void updateUser(UserBean user);
}
