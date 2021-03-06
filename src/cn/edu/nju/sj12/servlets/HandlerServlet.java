package cn.edu.nju.sj12.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.nju.sj12.factory.DaoConfig;
import cn.edu.nju.sj12.factory.DaoFactory;
import cn.edu.nju.sj12.model.Score;
import cn.edu.nju.sj12.model.User;

/**
 * Controller
 * @author ShenJie
 *
 * Code Every Day
 */

public class HandlerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String LOGIN_PAGE = "/user/login.jsp";
	private final String FORMAL_PAGE = "/JSPs/FormalPage.jsp";
	private final String WRONG_PAGE = "/JSPs/WrongPage.jsp";
	private final String WARNING_PAGE = "/JSPs/WarningPage.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(true);
		String id = req.getParameter("userid_text");
		String password = req.getParameter("password_text");
		boolean isLogin = checkIdentify(id, password);
		if(!isLogin){
			req.getRequestDispatcher(WRONG_PAGE).forward(req, resp);
			return;
		}
		else{
//			if(false){
//				//重复登录
//				System.out.println("该账号已经登录");
//				req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
//				return;
//			}
			session.setAttribute("isLog", "true");
			updateOnlineCounter();
			//未对此有要求，暂作mock
			int tempCourseId = 1;
			int score = getScore(id, tempCourseId);
			Score myScoreBean = new Score();
			myScoreBean.setScore(score);
			req.setAttribute("myScore", myScoreBean);
			if(score<60){
				req.getRequestDispatcher(WARNING_PAGE).forward(req, resp);
				return;
			}
			else{
				req.getRequestDispatcher(FORMAL_PAGE).forward(req, resp);
				return;
			}
		}
	}
	
	private boolean checkIdentify(String id, String password){
		if(id==null||id==""||password==null||password==""){
			return false;
		}
		User user = DaoFactory.getInstance(DaoConfig.MYSQL).getUserDao().getUser(id);
		if(user==null){
			return false;
		}
		String truePassword = user.getPassword();
		if(password.equals(truePassword)){
			return true;
		}
		else{
			return false;
		}
	}
	
	private int getScore(String id, int courseId){
		int score = 0;
		score = DaoFactory.getInstance(DaoConfig.MYSQL).getScoreDao().getScore(id, courseId);
		return score;
	}
	
	private void updateOnlineCounter(){
		ServletContext context = getServletContext();
		int onlineCounter = (int)context.getAttribute("onlineCounter");
		onlineCounter++;
		context.setAttribute("onlineCounter", onlineCounter);
	}
}
