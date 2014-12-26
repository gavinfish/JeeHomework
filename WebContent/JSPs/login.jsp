<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	session = request.getSession(false);
	if (session != null){
		session.invalidate();
	}
%>
<html>

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
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

</body>

</html>
