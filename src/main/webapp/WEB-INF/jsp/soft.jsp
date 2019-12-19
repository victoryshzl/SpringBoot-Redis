 <%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
			<title>用户登录</title>
		</head>
		<body>
			排序!!!
			<br>
			<table class="table table-bordered" style="font-family:微软雅黑">
			<tr>
			<th style="text-align:center">uid</th>
			<th style="text-align:center">username</th>
			<th style="text-align:center">password</th>
			</tr>
			<c:forEach items="${sessionScope.sort}" var="user">
			<tr>
			<td>${user.uid }</td>
			<td>${user.username }</td>
			<td>${user.password }</td>
			</tr>
			</c:forEach>
			
			
				
			</table>
		
		</body>
	</html>