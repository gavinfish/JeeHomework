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

	// 连接数据库
	public MySQLHelper() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 要使用的数据库名称以及数据库的账号密码
			String url = "jdbc:mysql://localhost/" + "jee_homework";
			String username = "root";
			String password = "123456";

			// 加载驱动程序以连接数据库
			connection = DriverManager.getConnection(url, username, password);
		}

		// 捕获加载驱动程序异常
		catch (ClassNotFoundException cnfex) {
			System.err.println("装载 JDBC/ODBC 驱动程序失败。");
			cnfex.printStackTrace();
			System.exit(1); // 结束程序
		}
		// 捕获连接数据库异常
		catch (SQLException sqlex) {
			System.err.println("无法连接数据库");
			sqlex.printStackTrace();
			System.exit(1); // 结束程序
		}
	}

}
