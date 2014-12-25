package cn.edu.nju.sj12.servlets;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import cn.edu.nju.sj12.logic.user.UserRegulationInterface;
import cn.edu.nju.sj12.logic.user.UserRegulationXmlImp;
import cn.edu.nju.sj12.vo.UserVO;


public class Login extends HttpServlet{
	static final private String CONTENT_TYPE = "text/html; charset=GBK"; 
	Map<String, Boolean> onlines = new HashMap<String, Boolean>();  
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType(CONTENT_TYPE);
		
		String id = req.getParameter("userid_text");
		if(id==null){
			id = "unknow";
		}
		String password_input = req.getParameter("password_text");
		if(password_input==null){
			password_input = "";
		}
		
		HttpSession session = req.getSession(true);
		session.setAttribute("online", "yes");
		if (id =="unknow") {
			if (null != session) {
				id = (String)session.getAttribute("id");
				onlines.remove(id);
				resp.sendRedirect("/Homework/user/login.html");
				return;
			}
		}
		String online = (String)session.getAttribute("online");
		UserRegulationInterface userRegulation = new UserRegulationXmlImp();
		UserVO user = userRegulation.getUser(id);
		if(user==null){
			resp.sendRedirect("/Homework/wrongPage");
			return;
		}

		String password = user.getPassword();
		//int score = user.getScore();	
		int score = 11;
		session.setAttribute("score", score);
		if(password_input.equals(password)){
			if(online!=null&&online.equals("yes")&&onlines.get(id)!=null){
				JOptionPane.showMessageDialog(null, "¸ÃÕËºÅÒÑ¾­µÇÂ¼£¡");
				resp.sendRedirect("/Homework/user/login.html");
				return;
			}
			session.setAttribute("id", id);
			onlines.put(id, true);
			if(score>=60){
				resp.sendRedirect("/Homework/formalPage");
			}
			else{
				resp.sendRedirect("/Homework/warningPage");
			}
			return;
		}
		else{
			resp.sendRedirect("/Homework/wrongPage");
			return;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
