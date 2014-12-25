package cn.edu.nju.sj12.logic.course;

import cn.edu.nju.sj12.vo.TranscriptVO;

public interface ScoreRegulationInterface {
	public void setScore(String id, int courseId, int score);
	public int getScore(String id, int courseId);
	public TranscriptVO getScores(String id);
}
