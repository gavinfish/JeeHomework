package cn.edu.nju.sj12.dao.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import cn.edu.nju.sj12.dao.IDaoHelper;
import cn.edu.nju.sj12.dao.IScoreDao;

/**
 * 
 * @author ShenJie
 *
 * Code Every Day
 */

public class MySQLScoreDaoImpl implements IScoreDao{
	private String tableName = "scoreInfo";
	IDaoHelper daoHelper;
	
	public MySQLScoreDaoImpl(){
		daoHelper = new MySQLDaoHelperImpl();
	}
	
	@Override
	public void updateScore(String id, int courseId, int score) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getScore(String id, int courseId) {
		// TODO Auto-generated method stub
		int score = 0;
		String sqlSentence = "select * from "+tableName+" where id='"+id+"' and course_id="+courseId;
		ResultSet resultSet = null;
		try {
			resultSet = daoHelper.getSQLResult(sqlSentence);
			//未查询到结果
			if(!resultSet.next()){
				return 0;
			}
			score = resultSet.getInt(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			daoHelper.disConnect();
		}
		return score;
	}

	@Override
	public Map<Integer, Integer> getAllScores(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
