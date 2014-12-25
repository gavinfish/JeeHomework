package cn.edu.nju.sj12.logic.course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.nju.sj12.helpers.MySQLHelper;
import cn.edu.nju.sj12.vo.TranscriptVO;

public class ScoreRegulationSQLImp implements ScoreRegulationInterface{
	private MySQLHelper mySQLHelper;
	private Statement statement;
	private ResultSet resultSet;
	private String tableName = "scoreInfo";
	
	public ScoreRegulationSQLImp(){
		mySQLHelper = new MySQLHelper();
		try {
			statement = mySQLHelper.connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void setScore(String id, int courseId, int score) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getScore(String id, int courseId) {
		// TODO Auto-generated method stub
		int score = 0;
		String sqlSentence = "select * from "+tableName+" where id='"+id+"' and course_id="+courseId;
		try {
			resultSet = statement.executeQuery(sqlSentence);
			//未查询到结果
			if(!resultSet.next()){
				return 0;
			}
			score = resultSet.getInt(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return score;
	}

	@Override
	public TranscriptVO getScores(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static void main(String[] args){
		ScoreRegulationInterface scoreRegulation = new ScoreRegulationSQLImp();
		int score = scoreRegulation.getScore("1", 0);
		System.out.println(score);
	}
}
