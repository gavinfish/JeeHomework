package cn.edu.nju.sj12.dao.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public MySQLDaoHelperImpl(){

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Ҫʹ�õ����ݿ������Լ����ݿ���˺�����
			String url = "jdbc:mysql://localhost/" + "jee_homework";
			String username = "root";
			String password = "123456";

			// ���������������������ݿ�
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
		}

		// ����������������쳣
		catch (ClassNotFoundException cnfex) {
			System.err.println("װ�� JDBC/ODBC ��������ʧ�ܡ�");
			cnfex.printStackTrace();
			System.exit(1); // ��������
		}
		// �����������ݿ��쳣
		catch (SQLException sqlex) {
			System.err.println("�޷��������ݿ�");
			sqlex.printStackTrace();
			System.exit(1); // ��������
		}
	}
	
	@Override
	public ResultSet getSQLResult(String sql) {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

}
