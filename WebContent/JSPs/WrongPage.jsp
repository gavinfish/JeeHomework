<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>WrongPage</title>
<style type="text/css">
.auto-style1 {
	text-align: center;
}
</style>
</head>

<body>

	<h1 class="auto-style1">
		<strong>错误界面</strong>
	</h1>
	<p>&nbsp;</p>
	<p class="auto-style1">
		账号或密码错误，请点击<a href="/Homework/user/login.jsp">这里</a>重新登录！
	</p>
	<p class="auto-style1">&nbsp;</p>
	<%
		ServletContext context = getServletContext();
		int totalCounter = (Integer)context.getAttribute("totalCounter");
		int onlineCounter = (Integer)context.getAttribute("onlineCounter");
		int visitorCounter = totalCounter-onlineCounter;
	%>
	<p class="auto-style1">当前在线有<%=totalCounter %>人在线，<%=onlineCounter %>人已登录，<%=visitorCounter %>人为游客</p>
</body>

</html>
