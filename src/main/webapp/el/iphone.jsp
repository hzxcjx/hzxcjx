<%@page import="els.Pro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	 <%
        Pro sj = new Pro(1,"iPhone 14","../imgs/7.png",7999.00,"美国","白色","128GB");
        request.setAttribute("sj", sj);
    %>
    <h2>产品信息：</h2>
    <p>产品ID：${sj.id}</p >
    <p>产品名称：${sj.name}</p >
    <p>产品图片：<img src="${sj.img}" alt="产品图片" width="200"></p >
    <p>产品价格：${sj.price}元</p >
    <p>产品产地：${sj.add}</p >
    <p>产品颜色：${sj.color}</p >
    <p>产品规格：${sj.guige}</p >
</body>
</html>