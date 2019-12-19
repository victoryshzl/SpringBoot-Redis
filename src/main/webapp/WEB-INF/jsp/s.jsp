<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
			<title>用户登录</title>
		</head>
		<body>
			Search!!!
			<br>
			学号：${sessionScope.user.uid }<br>
			学生名：${sessionScope.user.username }<br>
			密码：${sessionScope.user.password }<br>
		
		</body>
	</html>