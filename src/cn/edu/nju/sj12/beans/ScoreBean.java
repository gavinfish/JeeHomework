package cn.edu.nju.sj12.beans;

import java.io.Serializable;

/**
 * ¿Î³Ì³É¼¨µÄBean
 * @author ShenJie
 *
 * Code Every Day
 */

public class ScoreBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int courseId;
	private String courseName;
	private int score;
	
	public String getId(){
		return this.id;
	}
	
	public void setCourseId(int courseId){
		this.courseId = courseId;
	}
	
	public int getCourseId(){
		return this.courseId;
	}
	
	
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	
	public String getCourseName(){
		return this.courseName;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}
}
