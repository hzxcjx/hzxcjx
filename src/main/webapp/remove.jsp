<%@page import="tr03802war.ShopCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>移除购物车内的商品</title>
</head>
<body>
	<%
		//从session中获取购物车对象
		ShopCart shopCart = (ShopCart)session.getAttribute("shopCart");
		//如果session中还没有购物车，则创建购物车
		if(shopCart == null){
			new ShopCart();
		}
		//读取pid参数
		int pid = Integer.parseInt(request.getParameter("pid"));
		//从购物车中删除
		shopCart.remove(pid);
		
		//重定向到购物车
		response.sendRedirect("Shopcart.jsp");
	%>
</body>
</html>