<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>first.jsp</h1>
	<%
		pageContext.setAttribute("pageContext", "pageContext");
		request.setAttribute("request", "request");
		session.setAttribute("session", "session");
		application.setAttribute("application", "application");
	%>
	
	<%= pageContext.getAttribute("pageContext") %>
	<%= request.getAttribute("request") %>
	<%= session.getAttribute("session") %>
	<%= application.getAttribute("application") %>
	
	<%
		/* request.getRequestDispatcher("second.jsp")
			.forward(request, response); */
		response.sendRedirect("second.jsp");
	%>
</body>
</html>