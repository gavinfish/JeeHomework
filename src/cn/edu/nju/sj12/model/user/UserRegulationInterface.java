package cn.edu.nju.sj12.model.user;

import cn.edu.nju.sj12.beans.UserBean;

public interface UserRegulationInterface {
	public void addUser(UserBean user);
	public void deleteUser(String id);
	public UserBean getUser(String id);
	public void updateUser(UserBean user);
}
