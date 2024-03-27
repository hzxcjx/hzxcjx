<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="x" uri="http://www.trkj.com/tr03802/tags" %> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>Insert title here</title> 
<style> 
.lzh_p{ 
font-size: 14px; 
} 
.lzh_p a{ 
text-decoration: none; 
margin: 5px 5px; 
padding: 3px 5px; 
border: 1px solid gray; 
font-size: 12px; 
} 
</style> 
</head> 
<body> 
<table> 
<tr> 
<th>id</th> 
<th>产品名</th> 
<th>单价</th> 
</tr> 
<c:forEach items="${list}" var="p"> 
<tr> 
<td>${p.pid}</td> 
<td>${p.name}</td> 
<td>${p.price}</td> 
</tr> 
</c:forEach> 
</table> 
<x:page controller="list" pagesize="2" total="${total}" curpage="${param.curpage}"/> 
</body> 
</html> 