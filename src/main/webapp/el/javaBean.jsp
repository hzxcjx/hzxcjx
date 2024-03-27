<%@page import="java.sql.Date"%>
<%@page import="els.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = new User(1,"张三",Date.valueOf("2024-1-15"));
		request.setAttribute("u", user);
	%>
	${u.name}
</body>
</html>