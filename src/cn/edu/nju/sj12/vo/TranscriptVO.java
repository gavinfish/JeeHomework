package cn.edu.nju.sj12.vo;

import java.util.Map;

/**
 * 一个学生的成绩单
 * @author SAMSUNG
 *
 */
public class TranscriptVO {
	private String id;
	private Map<Integer, Integer> scoreMap;
	
	public TranscriptVO(String id){
		this.id = id;
	}
	
	public Map<Integer, Integer> getScores(){
		return scoreMap;
	}
	
	public void addScore(int courseId, int score){
		scoreMap.put(courseId, score);
	}
	
	public String getId(){
		return this.id;
	}
}
