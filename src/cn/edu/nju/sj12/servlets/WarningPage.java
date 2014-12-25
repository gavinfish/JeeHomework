package cn.edu.nju.sj12.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.nju.sj12.logic.user.UserRegulationInterface;
import cn.edu.nju.sj12.logic.user.UserRegulationXmlImp;
import cn.edu.nju.sj12.vo.UserVO;


public class WarningPage extends HttpServlet{
	static final private String CONTENT_TYPE = "text/html; charset=GBK"; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType(CONTENT_TYPE);
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if(session==null||(String)session.getAttribute("online")!="yes"){
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, "还没有登录");
			return;
		}
		int score = (int)session.getAttribute("score");
		if(score>=60){
			resp.sendRedirect("/Homework/formalPage");
			return;
		}
		String htmlString = "<html xmlns='http://www.w3.org/1999/xhtml'><head>"
				+ "<meta content='zh-cn' http-equiv='Content-Language' />"
				+ "<meta content='text/html; charset=utf-8' http-equiv='Content-Type' />"
				+ "<title>WarningPage</title>"
				+ "<style type='text/css'>"
				+ ".auto-style1 {"
				+ "text-align: center;"
				+ "}"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ "<h1 class='auto-style1'><strong>警示界面</strong></h1>"
				+ "<p class='auto-style1'>&nbsp;</p>"
				+ "<form method= 'GET' action= 'resp.setAttribut('Logout','yes')'  >"
				+ "<p class='auto-style1'><a href='/Homework/login'>注销</a></p>"
				+ "<p class='auto-style1'>你的成绩为"+score+"分，继续加油！</p>"
				+ "</body>"
				+ "</html>";
		out.println(htmlString);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
