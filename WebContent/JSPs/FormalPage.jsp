<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>FormalPage</title>
<style type="text/css">
.auto-style1 {
	text-align: center;
}
</style>
</head>

<body>
	<jsp:useBean id="myScore" type="cn.edu.nju.sj12.model.Score"
		scope="request"></jsp:useBean>
	<h1 class="auto-style1">
		<strong>标准界面</strong>
	</h1>
	<p class="auto-style1">&nbsp;</p>
	<p class="auto-style1">
		恭喜！你的成绩为
		<jsp:getProperty property="score" name="myScore" />
		分！
	</p>
	<p class="auto-style1">
		<a href="/Homework/JSPs/LogOut.jsp">注销</a>
	</p>
	<%
		ServletContext context = getServletContext();
		int totalCounter = (Integer) context.getAttribute("totalCounter");
		int onlineCounter = (Integer) context.getAttribute("onlineCounter");
		int visitorCounter = totalCounter - onlineCounter;
	%>
	<p class="auto-style1">
		当前在线有<%=totalCounter%>人在线，<%=onlineCounter%>人已登录，<%=visitorCounter%>人为游客
	</p>
</body>

</html>
