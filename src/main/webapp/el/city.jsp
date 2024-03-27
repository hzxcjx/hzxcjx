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
		String[] cheng = {"北京", "上海", "广州", "深圳", "香港"};
		request.setAttribute("cheng", cheng);
	%>
	${cheng[0]}
	${cheng[1]}
	${cheng[2]}
	${cheng[3]}
	${cheng[4]}
</body>
</html>