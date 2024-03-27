<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <h1>登录页面</h1>
    <form action="b.jsp" method="POST">
        <label for="username">用户名:</label>
        <input type="text" name="username" id="username" required><br>
        <label for="password">密码:</label>
        <input type="password" name="password" id="password" required><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>