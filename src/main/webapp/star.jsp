<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>你喜欢的名星</title>
</head>
<body>
	<h1>你喜欢的名星</h1>
	<form method="post" action="star-ok.jsp">
		<input type="checkbox" name="star" value="易烊千玺" />易烊千玺 <br>
		<input type="checkbox" name="star" value="刘德华" />刘德华 <br>
		<input type="checkbox" name="star" value="孙悟空" />孙悟空 <br>
		<input type="checkbox" name="star" value="谢妞" />谢妞 <br>
		<input type="checkbox" name="star" value="李白" />李白 <br>
		<input value="提交" type="submit">
	</form>
</body>
</html>