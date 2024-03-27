<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>计算器</title>
</head>
<body>
	<div>
		<form action="callServlet" method="post" >
			<input name="a" value="${a}">
			<select name="o">	
				<option value="+" ${o eq '+' ? 'selected' : '' }>+</option>
				<option value="-" ${o eq '-' ? 'selected' : '' }>-</option>
				<option value="*" ${o eq '*' ? 'selected' : '' }>*</option>
				<option value="/" ${o eq '/' ? 'selected' : '' }>/</option>
				<option value="%" ${o eq '%' ? 'selected' : '' }>%</option>
			</select>
			<input name="b" value="${b}">
			<input type="submit" value="=">
		</form>
	</div>
	<div>${r}</div>
</body>
</html>