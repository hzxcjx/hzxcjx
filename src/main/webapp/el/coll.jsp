<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		List<String> list = new ArrayList();
		list.add("中国");
		list.add("美国");
		list.add("印度");
		request.setAttribute("list", list);
		
		Map<String,Integer> map = new HashMap();
		map.put("a",100);
		map.put("b",200);
		request.setAttribute("map", map);
	%>
	${list[0]}
	${map.a},${map['a']}
	
	${param.id}
</body>
</html>