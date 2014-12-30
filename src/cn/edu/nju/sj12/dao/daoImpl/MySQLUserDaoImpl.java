package cn.edu.nju.sj12.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.nju.sj12.dao.IDaoHelper;
import cn.edu.nju.sj12.dao.IUserDao;
import cn.edu.nju.sj12.enums.Gender;
import cn.edu.nju.sj12.model.User;

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
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		User user = null;
		String sqlSentence = "select * from "+tableName+" where id='"+id+"'";
		ResultSet resultSet = daoHelper.getSQLResult(sqlSentence);
		try {
			while(resultSet.next()){
				String name = resultSet.getString(2);
				String password = resultSet.getString(3);
				int age = resultSet.getInt(4);
				Gender gender = (Gender)Enum.valueOf(Gender.class, resultSet.getString(5));
				user = new User(id);
				user.setName(name);
				user.setPassword(password);
				user.setAge(age);
				user.setGender(gender);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			daoHelper.disConnect();
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
