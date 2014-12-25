package cn.edu.nju.sj12.model.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLHelper {

	public Statement statement;
	public ResultSet resultSet;
	public ResultSetMetaData rsMetaData;
	public Connection connection;

	// �������ݿ�
	public MySQLHelper() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Ҫʹ�õ����ݿ������Լ����ݿ���˺�����
			String url = "jdbc:mysql://localhost/" + "jee_homework";
			String username = "root";
			String password = "123456";

			// ���������������������ݿ�
			connection = DriverManager.getConnection(url, username, password);
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

}
