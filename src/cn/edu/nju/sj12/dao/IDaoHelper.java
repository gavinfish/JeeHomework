package cn.edu.nju.sj12.dao;

import java.sql.ResultSet;

/**
 * 
 * @author ShenJie
 *
 * Code Every Day
 */

public interface IDaoHelper {
	public ResultSet getSQLResult(String sql);
	public void disConnect();
}
