package cn.edu.nju.sj12.model.course;

public interface ScoreRegulationInterface {
	public void setScore(String id, int courseId, int score);
	public int getScore(String id, int courseId);

}
