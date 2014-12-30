<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//response.setHeader("refresh", "url=/Homework/user/login.jsp");//定时跳转
		session.removeAttribute("isLog");
		ServletContext context = getServletContext();
		int onlineCounter = (Integer) context.getAttribute("onlineCounter");
		onlineCounter--;
		context.setAttribute("onlineCounter", onlineCounter);
		request.getRequestDispatcher("/user/login.jsp").forward(request, response);
	%>
</body>
</html>