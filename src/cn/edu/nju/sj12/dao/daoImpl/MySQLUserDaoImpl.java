package cn.edu.nju.sj12.dao.daoImpl;

import cn.edu.nju.sj12.beans.UserBean;
import cn.edu.nju.sj12.dao.IUserDao;

/**
 * 
 * @author ShenJie
 *
 * Code Every Day
 */

public class MySQLUserDaoImpl implements IUserDao{
	private String tableName = "userInfo";
	
	@Override
	public void addUser(UserBean user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		System.out.println("É¾³ýÓÃ»§");
	}

	@Override
	public UserBean getUser(String id) {
		// TODO Auto-generated method stub
		UserBean userVO = null;
		String sqlSentence = "select * from "+tableName+" where id='"+id+"'";
		return null;
	}

	@Override
	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub
		
	}

}
