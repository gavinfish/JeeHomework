package cn.edu.nju.sj12.dao;

import java.util.Map;

/**
 * 
 * @author ShenJie
 *
 * Code Every Day
 */

public interface IScoreDao {
	public void updateScore(String id, int courseId, int score);
	public int getScore(String id, int courseId);
	public Map<Integer, Integer> getAllScores(String id);
}
