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
	<jsp:useBean id="myScore" type="cn.edu.nju.sj12.beans.ScoreBean" scope="request"></jsp:useBean>
	<h1 class="auto-style1">
		<strong>标准界面</strong>
	</h1>
	<p class="auto-style1">&nbsp;</p>
	<p class="auto-style1">恭喜！你的成绩为
	<jsp:getProperty property="score" name="myScore"/>
	分！</p>

</body>

</html>
