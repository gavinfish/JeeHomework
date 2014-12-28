package cn.edu.nju.sj12.dao.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import javax.sql.DataSource;

import cn.edu.nju.sj12.dao.IDaoHelper;

/**
 * 
 * @author ShenJie
 *
 * Code Every Day
 */

public class MySQLDaoHelperImpl implements IDaoHelper{
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public MySQLDaoHelperImpl(){
		Properties properties = new Properties();
		properties.put(javax.naming.Context.PROVIDER_URL, "jnp:///");
		properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.naming.java.javaURLContextFactory");
		try {
			Context context = new InitialContext(properties);
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/jee_homework");
			connection = dataSource.getConnection();
			statement = connection.createStatement();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}
	
	@Override
	public ResultSet getSQLResult(String sql) {
		// TODO Auto-generated method stub
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public void disConnect() {
		// TODO Auto-generated method stub
		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
