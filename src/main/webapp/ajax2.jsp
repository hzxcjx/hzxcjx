<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.get("ListServlet2", function(v){
			//$("#result").html(v);
		});
		
		$("#saying").click(function(){
			$.getJSON("ListServlet2",{}, function(v){
				for(var i = 0; i < v.length; i ++){
					var div = $("<div style='border-bottom:1px solid gray;'>");
					$("#result").append(div);
					
					var span1 = $("<span>");//时间
					span1.css("float", "right");
					span1.html(v[i].time);
					span1.appendTo(div);
					
					var span2 = $("<span>");//内容
					span2.html(v[i].content);
					span2.appendTo(div);
				}
			});
		});
	});
</script>
</head>
<body>
	<%= new Date() %>
	
	<button id="saying">获取留言</button>
	<div id="result"></div>
	
	
</body>
</html>