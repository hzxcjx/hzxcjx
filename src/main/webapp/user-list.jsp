<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
</head>
<body>
	<h2><%= session.getAttribute("name") %>, 欢迎使用本系统！</h2>
	<a href="reg.jsp">注册</a>
	
	<%
		//判断是否登陆
		if(session.getAttribute("name") == null){
			//还没有登陆
			out.print("对不起，请先<a href='login.jsp'>登陆</a>！");
		}else{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
			String sql = "select * from user_ order by uid_ desc";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			out.print("<table border='1'>");
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>" + rs.getInt(1) + "</td>");
				out.print("<td>" + rs.getString(2) + "</td>");
				out.print("<td>" + rs.getString(4) + "</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			rs.close();
			stmt.close();
			conn.close();
		}
	%>
</body>
</html>