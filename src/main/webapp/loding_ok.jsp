<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.xdevapi.PreparableStatement"%>
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
		//获得请求参数
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		//定义登陆sql
		String sql ="select * from user_ where username=? and userpass=?";
		
		//通过jdbc执行sql
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tr03802?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","123456");
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,name);
		stmt.setString(2,pwd);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			out.print("登陆成功");
			session.setAttribute("name", name);
			response.sendRedirect("plist.jsp");
		}else{
			out.print("<div>登陆失败，请检查用户名是否正确</div>");
			out.print("<div><a href='loding.jsp'>重新登陆</a></div>");	
		}
		rs.close();
		stmt.close();
		conn.close();
	%>
</body>
</html>