package cn.edu.nju.sj12.model.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.nju.sj12.enums.Gender;
import cn.edu.nju.sj12.model.helpers.MySQLHelper;
import cn.edu.nju.sj12.vo.UserVO;

public class UserRegulationSQLImp implements UserRegulationInterface{
	private MySQLHelper mySQLHelper;
	private Statement statement;
	private ResultSet resultSet;
	private String tableName = "userInfo";
	
	public UserRegulationSQLImp(){
		mySQLHelper = new MySQLHelper();
		try {
			statement = mySQLHelper.connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void addUser(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO getUser(String id) {
		// TODO Auto-generated method stub
		UserVO userVO = null;
		String sqlSentence = "select * from "+tableName+" where id='"+id+"'";
		try {
			resultSet = statement.executeQuery(sqlSentence);
			while(resultSet.next()){
				String name = resultSet.getString(2);
				String password = resultSet.getString(3);
				int age = resultSet.getInt(4);
				Gender gender = (Gender)Enum.valueOf(Gender.class, resultSet.getString(5));
				userVO = new UserVO(id);
				userVO.setName(name);
				userVO.setPassword(password);
				userVO.setAge(age);
				userVO.setGender(gender);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userVO;
	}

	@Override
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		UserRegulationInterface userRegulation = new UserRegulationSQLImp();
		userRegulation.getUser("1");
	}

}
