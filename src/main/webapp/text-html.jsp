<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response返回html文本</title>
</head>
<body>
	<%
		response.setContentType("text/html;charset=utf-8");//默认
		out.print("这是response返回的结果");
	%>
</body>
</html>