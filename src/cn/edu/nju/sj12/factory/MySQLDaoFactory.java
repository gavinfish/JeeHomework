package cn.edu.nju.sj12.factory;

import cn.edu.nju.sj12.dao.IScoreDao;
import cn.edu.nju.sj12.dao.IUserDao;
import cn.edu.nju.sj12.dao.daoImpl.MySQLScoreDaoImpl;
import cn.edu.nju.sj12.dao.daoImpl.MySQLUserDaoImpl;

/**
 * 
 * @author ShenJie
 *
 * Code Every Day
 */

public class MySQLDaoFactory extends DaoFactory{

	@Override
	IUserDao getUserDao() {
		// TODO Auto-generated method stub
		return new MySQLUserDaoImpl();
	}

	@Override
	IScoreDao getScoreDao() {
		// TODO Auto-generated method stub
		return new MySQLScoreDaoImpl();
	}

	//Factoryµ÷ÓÃÊµÀý²âÊÔ
	public static void main(String args[]){
		DaoFactory.getInstance(DaoConfig.MYSQL).getUserDao().deleteUser("2");
	}
}
