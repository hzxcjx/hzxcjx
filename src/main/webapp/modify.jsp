<%@page import="tr03802war.ShopCartDB"%>
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
		//从session中获取购物车对象
		ShopCartDB shopCart = (ShopCartDB)session.getAttribute("shopCart");
		//如果session中还没有购物车，则创建购物车
		if(shopCart == null){
			shopCart = new ShopCartDB();
		}
		//读取pid参数
		int pid = Integer.parseInt(request.getParameter("pid"));
		//读取数量
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		//保存到购物车
		shopCart.modify(pid,cnt);
		//将购物车存到session中
		response.sendRedirect("Shopcart.jsp");
	%>
</body>
</html>