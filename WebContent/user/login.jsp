<%@page import="javax.swing.text.AbstractDocument.Content"%>
<%@page import="cn.edu.nju.sj12.servlets.HandlerServlet"%>
<%@page import="cn.edu.nju.sj12.listeners.CounterListener"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	session = request.getSession(false);
	ServletContext context = getServletContext();
	System.out.println("login.session.count:"+session.getAttribute("myCount"));
	//每个首次打开的系统的客户端都将分配到一个标识count
	if (session.getAttribute("myCount") == null) {
		session.setAttribute("myCount", context.getAttribute("counter"));
		context.setAttribute("counter",
				(Integer) context.getAttribute("counter") + 1);
		int totalCounter = (Integer) context
				.getAttribute("totalCounter");
		int visitorCounter = (Integer) context
				.getAttribute("visitorCounter");
		totalCounter++;
		visitorCounter++;
		context.setAttribute("totalCounter", totalCounter);
		context.setAttribute("visitorCounter", visitorCounter);
		System.out.println("fjeoajfeawf "+totalCounter);
	} else {
		
	}
%>
<html>

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>学生成绩查询系统</title>
<style type="text/css">
.auto-style1 {
	text-align: center;
}
</style>
</head>

<body>
	<h1 class="auto-style1">欢迎登陆学生成绩查询系统</h1>
	<div class="auto-style1">
		<form method="post" action="/Homework/handlerServlet">
			<label id="userid_label" class="auto-style1">Userid:</label><input
				name="userid_text" type="text" />&nbsp;&nbsp; <label
				id="password_label">Password:</label><input name="password_text"
				type="password" /><br /> <br />
			<button type="submit">登陆并查询成绩</button>
		</form>
	</div>
	<p class="auto-style1">&nbsp;</p>
	<%
		int totalCounter = (Integer) context.getAttribute("totalCounter");
		int onlineCounter = (Integer) context.getAttribute("onlineCounter");
		int visitorCounter = (Integer) context
				.getAttribute("visitorCounter");
	%>
	<p class="auto-style1">
		当前在线有<%=totalCounter%>人在线，<%=onlineCounter%>人已登录，<%=visitorCounter%>人为游客
	</p>

</body>

</html>
