package cn.edu.nju.sj12.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.nju.sj12.beans.UserBean;
import cn.edu.nju.sj12.dao.IDaoHelper;
import cn.edu.nju.sj12.dao.IUserDao;
import cn.edu.nju.sj12.enums.Gender;

/**
 * 
 * @author ShenJie
 *
 * Code Every Day
 */

public class MySQLUserDaoImpl implements IUserDao{
	private String tableName = "userInfo";
	IDaoHelper daoHelper;
	
	public MySQLUserDaoImpl(){
		daoHelper = new MySQLDaoHelperImpl();
	}
	
	@Override
	public void addUser(UserBean user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserBean getUser(String id) {
		// TODO Auto-generated method stub
		UserBean user = null;
		String sqlSentence = "select * from "+tableName+" where id='"+id+"'";
		ResultSet resultSet = daoHelper.getSQLResult(sqlSentence);
		try {
			while(resultSet.next()){
				String name = resultSet.getString(2);
				String password = resultSet.getString(3);
				int age = resultSet.getInt(4);
				Gender gender = (Gender)Enum.valueOf(Gender.class, resultSet.getString(5));
				user = new UserBean(id);
				user.setName(name);
				user.setPassword(password);
				user.setAge(age);
				user.setGender(gender);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUser(UserBean user) {
		// TODO Auto-generated method stub
		
	}

}
