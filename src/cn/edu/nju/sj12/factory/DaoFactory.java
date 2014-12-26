package cn.edu.nju.sj12.factory;

import cn.edu.nju.sj12.dao.IScoreDao;
import cn.edu.nju.sj12.dao.IUserDao;

/**
 * 
 * @author ShenJie
 *
 * Code Every Day
 */

abstract class DaoFactory {
	public static DaoFactory getInstance(String classname){
		DaoFactory daoFactory = null;
		try {
			daoFactory = (DaoFactory)Class.forName(classname).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoFactory;
	}
	
	abstract IUserDao getUserDao();
	abstract IScoreDao getScoreDao();
}
