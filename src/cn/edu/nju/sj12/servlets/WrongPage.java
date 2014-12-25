package cn.edu.nju.sj12.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class WrongPage extends HttpServlet{
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
		String htmlString = "<html xmlns='http://www.w3.org/1999/xhtml'>"
				+ "<head>"
				+ "<meta content='zh-cn' http-equiv='Content-Language' />"
				+ "<meta content='text/html; charset=utf-8' http-equiv='Content-Type' />"
				+ "<title>WrongPage</title>"
				+ "<style type='text/css'>"
				+ ".auto-style1 {"
				+ "text-align: center;"
				+ "}"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ "<h1 class='auto-style1'><strong>错误界面</strong></h1>"
				+ "<p>&nbsp;</p>"
				+ "<p class='auto-style1'>账号或密码错误，请点击<a href='http://localhost:8080/Homework/user/login.html'>这里</a>重新登录！</p>"
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
