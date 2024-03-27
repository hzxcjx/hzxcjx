<%@page import="els.Stu"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#img{
		width:50px;
		height:50px;
	}
</style>
</head>
<body>
	 <form action="../use" method="post">
        <input type="submit" value="提交">
    </form>
	学号：${map['12345678902'].sid }<br>
	姓名：${map['12345678902'].sname }<br>
	身份证：${map['12345678902'].idCard }<br>
	手机号：${map['12345678902'].tel }<br>
	年龄：${map['12345678902'].age }<br>
	头像：<img src="${map['12345678902'].img }" id="img"><br>
</body>
</html>