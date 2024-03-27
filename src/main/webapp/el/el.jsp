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
		pageContext.setAttribute("a",10);
		request.setAttribute("b", 20);		
		request.setAttribute("a", 200);
		session.setAttribute("c", 30);
		application.setAttribute("d", 40);
	%>
	${a},${b},${c},${d},
	${requestScope.a}
	${pageScope.a},
	${sessionScope.a}
	${applicationScope.a}
	
</body>
</html>