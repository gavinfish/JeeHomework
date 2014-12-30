package cn.edu.nju.sj12.action.business;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个学生的成绩单
 * Map<课程号，成绩>
 * @author ShenJie
 *
 * Code Every Day
 */

public class TranscriptBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer, Integer> transcript;
	private String id;
	
	public TranscriptBean(){
		this.transcript = new HashMap<Integer, Integer>();
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setScore(int courseId,int score){
		this.transcript.put(courseId, score);
	}
	
	public void setScores(Map<Integer, Integer> transcript){
		this.transcript = transcript;
	}
	
	public void removeScore(int courseId){
		this.transcript.remove(courseId);
	}
	
	public Map<Integer, Integer> getTranscript(){
		return this.transcript;
	}
}
