<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		request.setCharacterEncoding("utf-8");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
		String sql = "insert into user_(name_,pwd_,time_) values(?,?,now())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, request.getParameter("name"));
		stmt.setString(2, request.getParameter("pwd"));
		stmt.executeUpdate();
		stmt.close();
		conn.close();
		
		response.sendRedirect("user-list.jsp");
	%>
	
</body>
</html>