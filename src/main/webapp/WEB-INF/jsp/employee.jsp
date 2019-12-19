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
			查询
			<br>
			<table class="table table-bordered" style="font-family:微软雅黑">
			<tr>
			<th style="text-align:center">EID</th>
			<th style="text-align:center">EName</th>
			<th style="text-align:center">EAge</th>
			</tr>
			<c:forEach items="${sessionScope.employee}" var="user">
			<tr>
			<td>${user.id }</td>
			<td>${user.name }</td>
			<td>${user.age }</td>
			</tr>
			</c:forEach>
			
			
				
			</table>
		
		</body>
	</html>