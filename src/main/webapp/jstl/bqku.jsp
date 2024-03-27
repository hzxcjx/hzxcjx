<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<div>
		<c:choose>
				<c:when test="${param.age <= 12 }">你是儿童</c:when>
				<c:when test="${param.age <= 12 }">你是少年</c:when>
				<c:when test="${param.age <= 12 }">你是青年</c:when>
				<c:otherwise>你是老年</c:otherwise>
		</c:choose>
	</div>
</body>
</html>