package cn.edu.nju.sj12.model.user;

import cn.edu.nju.sj12.vo.UserVO;

public interface UserRegulationInterface {
	public void addUser(UserVO user);
	public void deleteUser(String id);
	public UserVO getUser(String id);
	public void updateUser(UserVO user);
}
