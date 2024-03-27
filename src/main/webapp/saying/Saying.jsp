<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>给网站留言</h1>
	<form action="../insert" method="post">
	<div>
		内容：<textarea rows="content" cols="content"></textarea>
	</div>
	<div>
		留言人：<input name="user" class="user">
	</div>
	<div>
		留言时间：<input type="submit" class="提交">
	</div>
	</form>
</body>
</html>