<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>second.jsp</h1>
	<h1><%= session.getId() %></h1>
	<%= pageContext.getAttribute("pageContext") %>
	<%= request.getAttribute("request") %>
	<%= session.getAttribute("session") %>
	<%= application.getAttribute("application") %>
</body>
</html>